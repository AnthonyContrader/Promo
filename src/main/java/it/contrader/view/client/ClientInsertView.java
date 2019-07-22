package it.contrader.view.client;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ClientInsertView extends AbstractView{
	private Request request;
	private int idAdmin;
	private String username;
	private String password;
	private String email;
	private String scode;
	private final String mode = "INSERT";

	public ClientInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("HomeModerator", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il idModeratore");
		    idAdmin=Integer.parseInt(getInput());
			System.out.println("Inserisci username dell'utente:");
			username = getInput();
			System.out.println("Inserisci password dell'utente:");
			password = getInput();
			System.out.println("Inserisci Scode dell'utente");
			scode = getInput();
			System.out.println("Inserisci email dell'utente:");
			email = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idadmin", idAdmin);
		request.put("username", username);
		request.put("password", password);
		request.put("scode", scode);
		request.put("email", email);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Client", "doControl", request);
	}


}
