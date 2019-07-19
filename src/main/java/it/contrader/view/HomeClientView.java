package it.contrader.view;

import it.contrader.main.MainDispatcher;
import it.contrader.controller.Request;
	
	public class HomeClientView extends AbstractView{
			String choice;

			public void showResults(Request request) {
				System.out.println("\n BENVENUTO A PROMO");

			}

			public void showOptions() {
				System.out.println("-------------MENU------------\n");
				System.out.println("NESSUNA OPZIONE DISPONIBILE!");
				System.out.println("\n Esatto, puoi solo uscire...");
				choice = this.getInput();

			}

			public void submit() {

				switch (choice) {

				case "e":
					MainDispatcher.getInstance().callAction("Login", "doControl", null);
					break;

				default:
					MainDispatcher.getInstance().callAction("Login", "doControl", null);
				}
			}

	    }
