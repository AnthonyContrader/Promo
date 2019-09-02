export interface IShop {
    id?: number;
    name?: string;
    type?: string;
    position?: string;
}

export class Shop implements IShop {
    constructor(public id?: number, public name?: string, public type?: string, public position?: string) {}
}
