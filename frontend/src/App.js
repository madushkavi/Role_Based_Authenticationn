import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from './pages/Login';
import Signup from './pages/Signup';
import AdminDashboard from './component/AdminDashboard'
import PartnerDashboard from './component/PartnerDashboard'
import ClientDashboard from './component/ClientDashboard'

function App() {
  return (
    <BrowserRouter>
      <div>
      <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/client" element={<ClientDashboard />} />
          <Route path="/partner" element={<PartnerDashboard />} />
          <Route path="/admin" element={<AdminDashboard />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
