import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    console.log(form)
    /*  TODO: do this after manager servlet created *******
    this.http.post('http://localhost:8020/employee-reimbursment-system01/adminlogin', 
                    JSON.stringify({username: form.value.username, password: form.value.password}))
                    .subscribe({
                      next:(data:any)=>{
                        console.log(data)
                        if(data.status === 'success'){
                          localStorage.setItem("username", form.value.username)
                          //add employee component here
                        }
                        }, 
                    })
                    */
  }

}
