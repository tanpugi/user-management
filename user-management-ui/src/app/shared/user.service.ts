import { Injectable, OnDestroy } from '@angular/core';
import { Http } from '@angular/http'
import { Subject, Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/share';

import { UserModel } from './user.model'

@Injectable()
export class UserService {

    constructor(private _http: Http) {}

    public addUser(userModel: UserModel): Observable<any> {
        return this._http
            .get('./assets/useradd.json', userModel)
            .map((res: any) => res.json())
            .share();
    }

    public search(keywords: string, page: number): Observable<any> {
        return this._http
            .get('./assets/usersearch.json?keywords=${keywords}&page=${page}')
            .map((res: any) => res.json())
            .share();
    }
}