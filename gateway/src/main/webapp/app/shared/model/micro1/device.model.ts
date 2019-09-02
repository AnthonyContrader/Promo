export interface IDevice {
    id?: number;
    mac?: string;
    devtype?: string;
    position?: string;
    clientId?: number;
}

export class Device implements IDevice {
    constructor(public id?: number, public mac?: string, public devtype?: string, public position?: string, public clientId?: number) {}
}
