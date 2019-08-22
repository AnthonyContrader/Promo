import { Client } from './client'

export class Device {

    idDevice : number

    client : Client

    mac :string

    devtype : string

    position : string

    constructor(idDevice : number, client : Client, mac :string, devtype : string, position : string){

        this.idDevice = idDevice
        this.client = client
        this.mac = mac
        this.devtype = devtype
        this.position = position
    }
}