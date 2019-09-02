import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { ClientComponentsPage, ClientUpdatePage } from './client.page-object';

describe('Client e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let clientUpdatePage: ClientUpdatePage;
    let clientComponentsPage: ClientComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Clients', async () => {
        await navBarPage.goToEntity('client');
        clientComponentsPage = new ClientComponentsPage();
        expect(await clientComponentsPage.getTitle()).toMatch(/gatewayApp.micro1Client.home.title/);
    });

    it('should load create Client page', async () => {
        await clientComponentsPage.clickOnCreateButton();
        clientUpdatePage = new ClientUpdatePage();
        expect(await clientUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro1Client.home.createOrEditLabel/);
        await clientUpdatePage.cancel();
    });

    it('should create and save Clients', async () => {
        await clientComponentsPage.clickOnCreateButton();
        await clientUpdatePage.setUsernameInput('username');
        expect(await clientUpdatePage.getUsernameInput()).toMatch('username');
        await clientUpdatePage.setPasswordInput('password');
        expect(await clientUpdatePage.getPasswordInput()).toMatch('password');
        await clientUpdatePage.setEmailInput('email');
        expect(await clientUpdatePage.getEmailInput()).toMatch('email');
        await clientUpdatePage.save();
        expect(await clientUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
