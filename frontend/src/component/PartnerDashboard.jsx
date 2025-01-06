import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function PartnerDashboard() {
  const navigate = useNavigate();
  const [company, setCompany] = useState(null);
  const [formData, setFormData] = useState({
    companyName: "",
    address: "",
    contactInfo: "",
  });

  useEffect(() => {
    fetchCompanyDetails();
  }, []);

  const fetchCompanyDetails = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/partner/my-company",
        { withCredentials: true }
      );
      setCompany(response.data);
    } catch (error) {
      console.error("Error fetching company details:", error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/partner/company-register",
        {
          name: formData.companyName,
          address: formData.address,
          contactInfo: formData.contactInfo,
        },
        {
          withCredentials: true,
        }
      );

      if (response.status === 200) {
        alert("Company registered successfully!");
        fetchCompanyDetails();
      }
    } catch (error) {
      console.error("Error registering company:", error);
      alert("Failed to register company. Please try again.");
    }
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Partner Dashboard</h2>
      {company ? (
        <div className="card">
          <div className="card-body">
            <h3 className="card-title">My Company Details</h3>
            <p>
              <strong>Name:</strong> {company.name}
            </p>
            <p>
              <strong>Address:</strong> {company.address}
            </p>
            <p>
              <strong>Contact Info:</strong> {company.contactInfo}
            </p>
          </div>
        </div>
      ) : (
        <div className="card">
          <div className="card-body">
            <h3 className="card-title">Register Your Company</h3>
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label className="form-label">Company Name</label>
                <input
                  type="text"
                  className="form-control"
                  name="companyName"
                  value={formData.companyName}
                  onChange={(e) =>
                    setFormData({ ...formData, companyName: e.target.value })
                  }
                  required
                />
              </div>
              <div className="mb-3">
                <label className="form-label">Address</label>
                <input
                  type="text"
                  className="form-control"
                  name="address"
                  value={formData.address}
                  onChange={(e) =>
                    setFormData({ ...formData, address: e.target.value })
                  }
                  required
                />
              </div>
              <div className="mb-3">
                <label className="form-label">Contact Info</label>
                <input
                  type="text"
                  className="form-control"
                  name="contactInfo"
                  value={formData.contactInfo}
                  onChange={(e) =>
                    setFormData({ ...formData, contactInfo: e.target.value })
                  }
                  required
                />
              </div>
              <button type="submit" className="btn btn-primary">
                Register Company
              </button>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}

export default PartnerDashboard;
