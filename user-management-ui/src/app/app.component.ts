import { Component, ViewChild } from '@angular/core';
import { DatePipe } from '@angular/common';
import { NgForm } from '@angular/forms';

import { UserService } from './shared/user.service';

import { UserSearchModel } from './shared/usersearch.model';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') searchForm: NgForm;

  constructor(private userService: UserService) {}

  onSubmit() {
    let searchModel = this.mapper({ keywords: "", page: 0}, this.searchForm);
  }

  private mapper(searchModel: {keywords: string, page: number}, searchForm: NgForm) : {keywords: string, page: number} {
    searchModel.keywords = this.searchForm.value.keywords;
    searchModel.page = this.searchForm.value.page;

    return searchModel;
  }
}
