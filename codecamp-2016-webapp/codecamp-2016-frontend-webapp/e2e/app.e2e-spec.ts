import { Codecamp2016FrontendWebappPage } from './app.po';

describe('codecamp-2016-frontend-webapp App', function() {
  let page: Codecamp2016FrontendWebappPage;

  beforeEach(() => {
    page = new Codecamp2016FrontendWebappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
