import { UserModel } from './user.model';

export class UserSearchModel {
    public users: UserModel[] = [];
    public page: number;
    public totalPages: number;
}