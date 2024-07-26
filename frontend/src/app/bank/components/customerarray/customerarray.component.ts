import { Component } from '@angular/core';
import { Customer } from '../../types/Customer';
//import { FormGroup, FormBuilder, Validators } from '@angular/forms';
//import { of } from 'rxjs';



@Component({
  selector: 'app-customerarray',
  // standalone: true,
  // imports: [],
  templateUrl: './customerarray.component.html',
  styleUrls: ['./customerarray.component.css']
})
export class CustomerarrayComponent {
   customers:Customer[]=[
    new  Customer( "1","John Doe", "john@example.com", "john_doe", "password123", "User")
   ];
  
}
