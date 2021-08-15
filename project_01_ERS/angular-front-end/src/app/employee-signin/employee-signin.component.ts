import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-signin',
  templateUrl: './employee-signin.component.html',
  styleUrls: ['./employee-signin.component.css']
})
export class EmployeeSigninComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { 
    console.log("im here!")
  }

  ngOnInit(): void {

  }

  onSubmit(form:NgForm){
    console.log(form)
    this.http.post('http://localhost:8020/employee-reimbursment-system01/login', 
                    JSON.stringify({username: form.value.username, password: form.value.password}))
                    .subscribe({
                      next:(data:any)=>{
                        console.log(data)
                        if(data.status === 'success'){
                          localStorage.setItem("username", form.value.username)
                          this.router.navigate(['employeehome'])
                        }
                        }, 
                    })
  }

}
