import { element, by, ElementFinder } from 'protractor';

export class DeviceComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-device div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class DeviceUpdatePage {
    pageTitle = element(by.id('jhi-device-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    macInput = element(by.id('field_mac'));
    devtypeInput = element(by.id('field_devtype'));
    positionInput = element(by.id('field_position'));
    clientSelect = element(by.id('field_client'));

    async getPageTitle() {
        return this.pageTitle.getAttribute('jhiTranslate');
    }

    async setMacInput(mac) {
        await this.macInput.sendKeys(mac);
    }

    async getMacInput() {
        return this.macInput.getAttribute('value');
    }

    async setDevtypeInput(devtype) {
        await this.devtypeInput.sendKeys(devtype);
    }

    async getDevtypeInput() {
        return this.devtypeInput.getAttribute('value');
    }

    async setPositionInput(position) {
        await this.positionInput.sendKeys(position);
    }

    async getPositionInput() {
        return this.positionInput.getAttribute('value');
    }

    async clientSelectLastOption() {
        await this.clientSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async clientSelectOption(option) {
        await this.clientSelect.sendKeys(option);
    }

    getClientSelect(): ElementFinder {
        return this.clientSelect;
    }

    async getClientSelectedOption() {
        return this.clientSelect.element(by.css('option:checked')).getText();
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}
