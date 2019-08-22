import { UserDTO } from './userdto';

export class Client{

    idclient: number;

    user: UserDTO ;

	username: string;
	
	password: string;

	scode: string;
	
    email: string;
    
    constructor(idclient: number, user: UserDTO, username: string, password: string, scode: string, email: string){

        this.idclient = idclient;
        this.user = user;
        this.username = username;
        this.password = password;
        this.scode = scode;
        this.email = email;


     

    }




}