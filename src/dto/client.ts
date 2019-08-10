import { UserDTO } from './userdto';

export class Client{

    idClient: number;

    user: UserDTO ;

	username: string;
	
	password: string;

	scode: string;
	
    email: string;
    
    constructor(idClient: number, user: UserDTO, username: string, password: string, scode: string, email: string){

        this.idClient = idClient;
        this.user = user;
        this.username = username;
        this.password = password;
        this.scode = scode;
        this.email = email;


     

    }




}