package it.contrader.view.user;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class UserUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String username;
	private String password;
	private String usertype;
	private int barcode;
	private String scode;
	private final String mode = "UPDATE";

	public UserUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci Id dell'utente");
			id=Integer.parseInt(getInput());
			System.out.println("Inserisci nuova username dell'utente:");
			username = getInput();
			System.out.println("Modifica nuova password dell'utente:");
			password = getInput();
			System.out.println("Modifica il tipo dell'utente:");
			usertype = getInput();
			System.out.println("Modifica il barcode dell'utente:");
			barcode = Integer.parseInt(getInput());
			System.out.println("Modifica l'scode tipo dell'utente:");
			scode = getInput();
			
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("username", username);
		request.put("password", password);
		request.put("usertype", usertype);
		request.put("barcode", barcode);
		request.put("scode", scode);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
