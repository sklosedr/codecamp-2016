import { browser, element, by } from 'protractor';

export class Codecamp2016FrontendWebappPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
