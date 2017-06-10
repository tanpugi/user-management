import { Component, ViewChild } from '@angular/core';
import { DatePipe } from '@angular/common';
import { NgForm } from '@angular/forms';

import { UserService } from './shared/user.service';
import { UserModel } from './shared/user.model'

@Component({
  selector: 'app-user',
  templateUrl: './app.user.component.html',
  styleUrls: ['./app.component.css']
})
export class AppUserComponent {
  @ViewChild('f') userForm: NgForm;
  messageType: string = 'none';
  message: string = "";
  defaultType: string = "normal";
  defaultDob: string = "";

  constructor(private userService: UserService) {}

  onSubmit() {
    let userModel = this.mapper(new UserModel(), this.userForm);
    let rx = this.userService.addUser(userModel);
    rx.subscribe(
      (res) => {
        this.messageType = 'success';
        this.message = "User data saved!";
        this.clearForm();
        setTimeout(() => { 
          this.messageType = 'none';
        }, 3000);
      },
      (err) => {
        this.messageType = 'error';
        this.message = "Something went wrong! Please try again!";
        setTimeout(() => { 
          this.messageType = 'none';
        }, 3000);
      }
    )
  }

  clearForm() {
    this.userForm.reset();
    this.userForm.form.patchValue({ 'type': this.defaultType});
  }

  private mapper(userModel: UserModel, userForm: NgForm) : UserModel {
    userModel.type = this.userForm.value.type;
    userModel.firstName = this.userForm.value.fname;
    userModel.lastName = this.userForm.value.lname;
    userModel.email = this.userForm.value.email;
    userModel.introduction = this.userForm.value.introDesc;
    userModel.dateOfBirth = new Date(this.userForm.value.dob);
    userModel.accessCode = this.userForm.value.accessCode;
    userModel.jobDescription = this.userForm.value.jobDesc;

    return userModel;
  }
}
