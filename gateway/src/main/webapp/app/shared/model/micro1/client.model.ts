export interface IClient {
    id?: number;
    username?: string;
    password?: string;
    email?: string;
}

export class Client implements IClient {
    constructor(public id?: number, public username?: string, public password?: string, public email?: string) {}
}
