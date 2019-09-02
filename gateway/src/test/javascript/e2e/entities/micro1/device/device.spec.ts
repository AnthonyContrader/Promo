import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { DeviceComponentsPage, DeviceUpdatePage } from './device.page-object';

describe('Device e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let deviceUpdatePage: DeviceUpdatePage;
    let deviceComponentsPage: DeviceComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Devices', async () => {
        await navBarPage.goToEntity('device');
        deviceComponentsPage = new DeviceComponentsPage();
        expect(await deviceComponentsPage.getTitle()).toMatch(/gatewayApp.micro1Device.home.title/);
    });

    it('should load create Device page', async () => {
        await deviceComponentsPage.clickOnCreateButton();
        deviceUpdatePage = new DeviceUpdatePage();
        expect(await deviceUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro1Device.home.createOrEditLabel/);
        await deviceUpdatePage.cancel();
    });

    it('should create and save Devices', async () => {
        await deviceComponentsPage.clickOnCreateButton();
        await deviceUpdatePage.setMacInput('mac');
        expect(await deviceUpdatePage.getMacInput()).toMatch('mac');
        await deviceUpdatePage.setDevtypeInput('devtype');
        expect(await deviceUpdatePage.getDevtypeInput()).toMatch('devtype');
        await deviceUpdatePage.setPositionInput('position');
        expect(await deviceUpdatePage.getPositionInput()).toMatch('position');
        await deviceUpdatePage.clientSelectLastOption();
        await deviceUpdatePage.save();
        expect(await deviceUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
