package it.contrader.view.client;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class ClientUpdateView extends AbstractView {
	private Request request;

	private int idclient;
	private int idAdmin;
	private String username;
	private String password;
	private String scode;
	private String email;
	
	private final String mode = "UPDATE";

	public ClientUpdateView() {
	}

	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Client", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void  showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			idclient = Integer.parseInt(getInput());
			System.out.println("Inserisci id del moderatore:");
			idAdmin = Integer.parseInt(getInput());
			System.out.println("Inserisci username dell'utente:");
			username = getInput();
			System.out.println("Inserisci password dell'utente:");
			password = getInput();
			System.out.println("Inserisci scode dell'utente:");
			scode = getInput();
			System.out.println("Inserisci l'email dell'utente:");
			email = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idclient", idclient);
		request.put("idadmin", idAdmin);
		request.put("username", username);
		request.put("password", password);
		request.put("scode", scode);
		request.put("email", email);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Client", "doControl", request);
	}

}
