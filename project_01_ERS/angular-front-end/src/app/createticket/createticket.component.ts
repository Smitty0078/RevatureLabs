import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createticket',
  templateUrl: './createticket.component.html',
  styleUrls: ['./createticket.component.css']
})
export class CreateticketComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    console.log(form)

    this.http.post('http://localhost:8020/employee-reimbursment-system01/tickets', 
                    JSON.stringify({id: form.value.ticketId,
                                    employee_id: form.value.employeeId, 
                                    amount: form.value.amount, 
                                    description: form.value.description
                                    }))
                    .subscribe({
                      next:(data:any)=>{
                        console.log(data)
                          localStorage.setItem("ticketId", form.value.ticketId)
                          alert("Successfully Created Ticket")
                          this.router.navigate(['employeehome'])
                        }, 
                    })

  }

}
