
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
function Table() {

    return (
        <div>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Semesters</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Comp 202</td>
                        <td>Comp 250</td>
                        <td>Comp 273</td>
                        <td>Math 240</td>
                        <td>Null</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Comp 206</td>
                        <td>Comp 310</td>
                        <td>Math 340</td>
                        <td>Comp 302</td>
                        <td>Comp 252</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Comp 303</td>
                        <td>Math 318</td>
                        <td>NULL</td>
                        <td>NULL</td>
                        <td>NULL</td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td>Comp 362</td>
                        <td>NULL</td>
                        <td>NULL</td>
                        <td>NULL</td>
                        <td>NULL</td>
                    </tr>
                </tbody>
            </table>
        </div>

    );
}

export default Table;
