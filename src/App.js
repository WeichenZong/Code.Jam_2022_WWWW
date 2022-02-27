
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  Offcanvas, Button
} from 'react-bootstrap'
import { useState } from 'react';
import Question from './question'
import Result from './result';
import {BrowserRouter as Router,Routes,Route } from 'react-router-dom';
function App() {
  
  return (
    <Router>
    <div className='App'>
      <Routes>
      <Route path = "/" element={<Question/>} />
      </Routes> 
    </div>
  </Router>
  );
}

export default App;
