import { element, by, ElementFinder } from 'protractor';

export class ScreenComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-screen div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class ScreenUpdatePage {
    pageTitle = element(by.id('jhi-screen-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    outputInput = element(by.id('field_output'));
    positionInput = element(by.id('field_position'));

    async getPageTitle() {
        return this.pageTitle.getAttribute('jhiTranslate');
    }

    async setOutputInput(output) {
        await this.outputInput.sendKeys(output);
    }

    async getOutputInput() {
        return this.outputInput.getAttribute('value');
    }

    async setPositionInput(position) {
        await this.positionInput.sendKeys(position);
    }

    async getPositionInput() {
        return this.positionInput.getAttribute('value');
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
