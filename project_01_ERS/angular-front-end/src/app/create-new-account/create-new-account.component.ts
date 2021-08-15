import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-new-account',
  templateUrl: './create-new-account.component.html',
  styleUrls: ['./create-new-account.component.css']
})
export class CreateNewAccountComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    console.log(form)
    
    this.http.post('http://localhost:8020/employee-reimbursment-system01/employee', 
                    JSON.stringify({id: form.value.employeeId, 
                                    name: form.value.name,
                                    username: form.value.username, 
                                    password: form.value.password
                                    }))
                    .subscribe({
                      next:(data:any)=>{
                        console.log(data)
                          localStorage.setItem("username", form.value.username)
                          this.router.navigate(['employeehome'])
                        }, 
                    })
                    
                    

  }

}
