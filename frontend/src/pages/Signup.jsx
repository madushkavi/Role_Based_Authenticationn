import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

function Signup() {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('');
  
const navigate=useNavigate();
  const handleSubmit = async (e) => {
    e.preventDefault();
    
    const userData = {
      userName,
      password,
      role
    };

    try {
      const response = await axios.post('http://localhost:8080/api/auth/register', userData);
        if(response){
            alert("Success Register");
            navigate('/');
        }

    } catch (error) {
        alert(error);
        navigate('/signup');
    }
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Signup</h2>
      <form onSubmit={handleSubmit} className="form-group">
        <div className="mb-3">
          <label className="form-label">User Name</label>
          <input
            type="text"
            className="form-control"
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Password</label>
          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Role (Partner,Client)</label>
          <input
            type="text"
            className="form-control"
            value={role}
            onChange={(e) => setRole(e.target.value.toUpperCase())}
            required
          />
        </div>
        <button type="submit" className="btn " style={{backgroundColor:'#035c59',color:'white'}}>Register</button>
      </form>
      <div>
        Already have an account?{" "}
        <span>
          <Link
            to="/"
            style={{
              textDecoration: "none",
              color: "#035c59",
              fontWeight: "bold",
            }}
          >
            Login
          </Link>
        </span>
      </div>
    </div>
  );
}

export default Signup;
