
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import logo from './logo2.jpeg';
import Table from './Table'
function Result() {

    return (
        <div>
            <div class="px-4 py-5 my-5 text-center">
                <img src={logo} alt="" width="40" height="40" class="d-inline-block align-text-middle" />
               
                <Table/>
                
            </div>
        </div>
    );
}

export default Result;
