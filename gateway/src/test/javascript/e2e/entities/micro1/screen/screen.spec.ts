import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { ScreenComponentsPage, ScreenUpdatePage } from './screen.page-object';

describe('Screen e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let screenUpdatePage: ScreenUpdatePage;
    let screenComponentsPage: ScreenComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Screens', async () => {
        await navBarPage.goToEntity('screen');
        screenComponentsPage = new ScreenComponentsPage();
        expect(await screenComponentsPage.getTitle()).toMatch(/gatewayApp.micro1Screen.home.title/);
    });

    it('should load create Screen page', async () => {
        await screenComponentsPage.clickOnCreateButton();
        screenUpdatePage = new ScreenUpdatePage();
        expect(await screenUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro1Screen.home.createOrEditLabel/);
        await screenUpdatePage.cancel();
    });

    it('should create and save Screens', async () => {
        await screenComponentsPage.clickOnCreateButton();
        await screenUpdatePage.setOutputInput('output');
        expect(await screenUpdatePage.getOutputInput()).toMatch('output');
        await screenUpdatePage.setPositionInput('position');
        expect(await screenUpdatePage.getPositionInput()).toMatch('position');
        await screenUpdatePage.save();
        expect(await screenUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
