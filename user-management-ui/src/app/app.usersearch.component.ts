import { Component, ViewChild } from '@angular/core';
import { DatePipe } from '@angular/common';
import { NgForm } from '@angular/forms';

import { UserService } from './shared/user.service';
import { UserSearchModel } from './shared/usersearch.model';

@Component({
  selector: 'app-usersearch',
  templateUrl: './app.usersearch.component.html',
  styleUrls: ['./app.component.css']
})
export class AppUserSearchComponent {
  @ViewChild('f') searchForm: NgForm;
  messageType: string = 'none';
  message: string = "";

  userSearchModel: UserSearchModel = new UserSearchModel();

  constructor(private userService: UserService) {}

  onSubmit() {
    let keywords = this.searchForm.value.keywords;
    let page = 0;
    let rx = this.userService.search(keywords, page);
    rx.subscribe(
      (res) => {
        this.userSearchModel.users = res.users;
        this.userSearchModel.totalPages = res.pages;
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

}