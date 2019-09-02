import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { ShopComponentsPage, ShopUpdatePage } from './shop.page-object';

describe('Shop e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let shopUpdatePage: ShopUpdatePage;
    let shopComponentsPage: ShopComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Shops', async () => {
        await navBarPage.goToEntity('shop');
        shopComponentsPage = new ShopComponentsPage();
        expect(await shopComponentsPage.getTitle()).toMatch(/gatewayApp.micro2Shop.home.title/);
    });

    it('should load create Shop page', async () => {
        await shopComponentsPage.clickOnCreateButton();
        shopUpdatePage = new ShopUpdatePage();
        expect(await shopUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro2Shop.home.createOrEditLabel/);
        await shopUpdatePage.cancel();
    });

    it('should create and save Shops', async () => {
        await shopComponentsPage.clickOnCreateButton();
        await shopUpdatePage.setNameInput('name');
        expect(await shopUpdatePage.getNameInput()).toMatch('name');
        await shopUpdatePage.setTypeInput('type');
        expect(await shopUpdatePage.getTypeInput()).toMatch('type');
        await shopUpdatePage.setPositionInput('position');
        expect(await shopUpdatePage.getPositionInput()).toMatch('position');
        await shopUpdatePage.save();
        expect(await shopUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
