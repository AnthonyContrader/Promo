export interface IScreen {
    id?: number;
    output?: string;
    position?: string;
}

export class Screen implements IScreen {
    constructor(public id?: number, public output?: string, public position?: string) {}
}
