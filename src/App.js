
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  Offcanvas,Button} from 'react-bootstrap'
import { useState } from 'react';
function App() {
const [faculty ,setFaculty] = useState();
  return (
    <div className='App'  >
        <div className='bg-image mx-auto my-auto'>
        <img src="https://www.educads.com/files/universities/canada/mcgill_university.png"  ></img>
        </div>
        <div>
        <div className=' mx-auto justify-content-md-center col-lg-5'>
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
     
      <p class="user-select-auto">Please select your major</p>
      <select class="form-select form-select-sm mb-3" aria-label=".form-select-lg example">
        <option selected class="col-
        md-auto">--</option>
       <option value="1">Computer Sience</option>
       <option value="2">Stats and Computer</option>
       <option value="3">Math and Computer</option>
      </select>
        </div>
    </div>
     
    
    
   
  );
}

export default App;
