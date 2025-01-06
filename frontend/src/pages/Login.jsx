import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

    const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    const loginData = {
      userName,
      password
    };

    try {
      const response = await axios.post('http://localhost:8080/api/auth/login', loginData);
      const userRole=response.data.toUpperCase();
      
      console.log(userRole);
      if (userRole === 'ADMIN') {
        navigate('/admin');
      } else if (userRole === 'PARTNER') {
        navigate('/partner');
      } else if (userRole === 'CLIENT') {
        navigate('/client');
      }
    } catch (error) {
        console.log("wrong");
      setMessage('Invalid credentials');
    }
    
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Login</h2>
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
        <button type="submit" className="btn btn-primary">Login</button>
      </form>
      {message && <div className="alert alert-info mt-3">{message}</div>}
    </div>
  );
}

export default Login;
