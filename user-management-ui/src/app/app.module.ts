import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AppUserComponent } from './app.user.component';
import { AppUserSearchComponent } from './app.usersearch.component';
import { UserService } from './shared/user.service';

@NgModule({
  declarations: [
    AppComponent,
    AppUserComponent,
    AppUserSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [ UserService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
