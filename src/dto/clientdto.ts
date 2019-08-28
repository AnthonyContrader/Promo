import { UserDTO } from './userdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @author PattyGè
 */
export class ClientDTO {

    id: number;

    userDTO : UserDTO;
	
	username: string;
	
	password: string;

	email: string;

    
}