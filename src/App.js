
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  Offcanvas,Button} from 'react-bootstrap'
import { useState } from 'react';
function App() {
const [faculty ,setFaculty] = useState();
  return (
    <div class=" w-100 h-100 text-center row bg-danger   ">
    
    <nav class="navbar navbar-light bg-danger">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top"/>
      Bootstrap
    </a>
  </div>
</nav>
   

       <div class= "no-repeat position-absolute top-50 start-50 translate-middle  "style={{ 
        backgroundImage: 'url("https://www.educads.com/files/universities/canada/mcgill_university.png")'
        ,backgroundRepeat:'no-repeat'
        } } >
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  
      <div className=' mx-auto mb-5 justify-content-md-center col-lg-5'>
        <h3 class="user-select-auto">Please select your starting year</h3>
      <select class="form-select form-select-sm mb-5" aria-label=".form-select-lg example">
        <option selected class="col-md-auto">--</option>
       <option value="1">U0</option>
       <option value="2">U1</option>
      </select>
      </div>

      <div className=' mx-auto justify-content-md-center col-lg-5'>
      <h3>Please select your faculty </h3>
      <select class="form-select form-select-sm mb-5 " aria-label=".form-select-lg example">
        <option selected class="col-
        md-auto">--</option>
       <option onSelect={useState(1)}>Faculty of Science</option>
       <option value="2">Faculty of Enginnering</option>
       <option value="3">Faculty of Art</option>
       <option value="4">Desautels Faculty of Management</option>
       <option value="5">Faculty of Medicine and Health Sciences</option>
       <option value="6">Schulich School of Music</option>
      </select>
      </div>

      <div className=' mx-auto justify-content-md-center col-lg-5'>
      <h3>Please select your faculty </h3>
      <select class="form-select form-select-sm mb-3" aria-label=".form-select-lg example">
        <option selected class="col-
        md-auto">--</option>
       <option value="1">Computer Sience</option>
       <option value="2">Stats and Computer</option>
       <option value="3">Math and Computer</option>
      </select>
        </div>

    </div>
    </div>
    </div>
    
    
   
  );
}

export default App;
