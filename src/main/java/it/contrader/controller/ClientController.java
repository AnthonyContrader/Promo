package it.contrader.controller;
import java.util.List;
import it.contrader.dto.ClientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ClientService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class ClientController implements Controller {

	/**
	 * definisce il pacchetto di vista client.
	 */
	private static String sub_package = "client.";
	
	private ClientService clientService;
	/**
	 * Costruisce un oggetto di tipo clientService per poterne usare i metodi
	 */
	public ClientController() {
		this.clientService = new ClientService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		int idAdmin;
		String username;
		String password;
		String email;
		String scode;

		switch (mode) {
		
		// Arriva qui dalla clientReadView. Invoca il Service con il parametro id e invia alla clientReadView uno client da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("idclient").toString());
			ClientDTO clientDTO = clientService.read(id);
			request.put("client", clientDTO);
			MainDispatcher.getInstance().callView(sub_package + "ClientRead", request);
			break;
		
		// Arriva qui dalla clientInsertView. Estrae i parametri da inserire e chiama il service per inserire uno client con questi parametri
		case "INSERT":
			
			idAdmin= Integer.parseInt(request.get("idadmin").toString());
			System.out.print(idAdmin);
			username = request.get("username").toString();
			System.out.print(username);
			password = request.get("password").toString();
			System.out.print(password);
			scode = request.get("scode").toString();
			System.out.print(scode);
			email = request.get("email").toString();
			System.out.print(email);
			
									
			
			ClientDTO clienttoinsert = new ClientDTO(idAdmin, username, password, email, scode);
			//invoca il service
			
			boolean n = clientService.insert(clienttoinsert);
			
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ClientInsert", request);
			break;
		
		// Arriva qui dalla clientDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("idclient").toString());
			//Qui chiama il service
			clientService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ClientDelete", request);
			break;
		
		// Arriva qui dalla clientUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("idclient").toString());
			idAdmin = Integer.parseInt(request.get("idadmin").toString());
			username = request.get("username").toString();
			password = request.get("password").toString();
			email = request.get("email").toString();
			scode = request.get("scode").toString();
			ClientDTO clienttoupdate = new ClientDTO(idAdmin, username, password, email, scode);
			clienttoupdate.setId(id);
			clientService.update(clienttoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ClientUpdate", request);
			break;
			
		//Arriva qui dalla clientView Invoca il Service e invia alla clientView il risultato da mostrare 
		case "CLIENTLIST":
			List<ClientDTO> clientsDTO = clientService.getAll();
			//Impacchetta la request con la lista degli client
			request.put("clients", clientsDTO);
			MainDispatcher.getInstance().callView("Client", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ClientRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ClientInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ClientUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ClientDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeModerator", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
