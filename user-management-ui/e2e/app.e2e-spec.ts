import { UserManagementUiPage } from './app.po';

describe('user-management-ui App', () => {
  let page: UserManagementUiPage;

  beforeEach(() => {
    page = new UserManagementUiPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
