import { Component } from '@angular/core';

import { UserService } from './shared/user.service';
import { UserSearchModel } from './shared/usersearch.model';

@Component({
  selector: 'app-usersearch',
  templateUrl: './app.usersearch.component.html',
  styleUrls: ['./app.component.css']
})
export class AppUserSearchComponent {
  messageType: string = 'none';
  message: string = "";

  userSearchModel: UserSearchModel = new UserSearchModel();

  constructor(private userService: UserService) {}

  onSearch() {
    let searchModel: {keywords: string, page: number};
    let rx = this.userService.search(searchModel.keywords, searchModel.page);
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