import { ClientDTO } from './clientdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @author PattyGè
 */
export class DeviceDTO {

    id: number;

	clientDTO: ClientDTO;
	
	mac: string;

	devtype: string;

	position: string;
    
}