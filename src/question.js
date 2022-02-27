

import 'bootstrap/dist/css/bootstrap.min.css';
import {
  Offcanvas, Button
} from 'react-bootstrap'
import { useState,withRouter} from 'react';
import logo from './logo2.jpeg';
import { Route } from 'react-router-dom'
//URL url = "https://localhost:3000/api/send";

function Question({ navigation }) {
    var string ="/result"
    const axios = require('axios').default;
  const [faculty, setFaculty] = useState("");
  const [year, setYear] = useState("");
  const [program, setProgram] = useState("");
  
  
  return (
    <div class=" text-center row bg-danger   ">
      <nav class="navbar navbar-light bg-danger">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <img src={logo} alt="" width="40" height="40" class="d-inline-block align-text-middle" />
            McGill Auto Program planner
          </a>
        </div>
      </nav>


      <div class="no-repeat position-absolute top-50 start-50 translate-middle   " style={{
        backgroundImage: 'url("https://www.educads.com/files/universities/canada/mcgill_university.png")'
        , backgroundRepeat: 'no-repeat'
      }} >
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

          <div className=' mx-auto mb-3 justify-content-md-center col-lg-5'>
            <h3 class="user-select-auto">Please select your starting year</h3>
            <select class="form-select form-select-sm mb-5" value ={year}onChange={e=>setYear(e.target.value)} aria-label=".form-select-lg example">
              <option selected class="col-md-auto">--</option>
              <option >U0</option>
              <option >U1</option>
            </select>
          </div>
          <div className=' mx-auto mb-3 justify-content-md-center col-lg-5'>
            <h3>Please select your faculty </h3>
            <select class="form-select form-select-sm mb-5 " value ={faculty }onChange={e=>setFaculty(e.target.value)} aria-label=".form-select-lg example">
              <option selected class="col-
          md-auto">--</option>
              <option >Faculty of Science</option>
              <option >Faculty of Enginnering</option>
              <option >Faculty of Art</option>
              <option >Desautels Faculty of Management</option>
              <option >Faculty of Medicine and Health Sciences</option>
              <option >Schulich School of Music</option>
            </select>
          </div>

          <div className=' mx-auto justify-content-md-center col-lg-5'>
            <h3>Please select your Program </h3>
            <select class="form-select form-select-sm mb-3" value ={program} onChange={e=>setProgram(e.target.value)} aria-label=".form-select-lg example">
              <option selected class="col-
          md-auto">--</option>
              <option >Computer Science</option>
              <option >Honors Computer Science</option>
              <option >Stats and Computer</option>
              <option >Honors Stats and Computer</option>
              <option >Neuroscience</option>
              <option >Biology</option>
              <option >Physics</option>
              <option >Chemistry</option>
              <option >Math and Physics</option>
              <option >Probabillity and Statistics</option>
            </select>
           
            <a href={string} class="btn btn-primary active" role="button" data-bs-toggle="button" aria-pressed="true">Submit</a>
           

          </div>
        
        </div>
      </div>
    </div>



  );
}

export default Question;
