package it.contrader.servlets;

import java.util.List;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ClientDTO;
import it.contrader.service.Service;
import it.contrader.service.ClientService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClientServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ClientDTO> service = new ClientService();
		List<ClientDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ClientDTO> service = new ClientService();
		String mode = request.getParameter("mode");
		ClientDTO dto;
		int idclient;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CLIENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;
		
	
		case "READ":
			idclient = Integer.parseInt(request.getParameter("idclient"));
			dto = service.read(idclient);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/client/readclient.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/client/updateclient.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int idmoderator = Integer.parseInt(request.getParameter("idmoderator"));
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String scode = request.getParameter("scode").toString();
			String email = request.getParameter("email").toString();
			dto = new ClientDTO (idmoderator, username,password, scode, email);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			idclient = Integer.parseInt(request.getParameter("idclient"));
			idmoderator = Integer.parseInt(request.getParameter("idmoderator"));
			username = request.getParameter("username");
			password = request.getParameter("password");
			scode = request.getParameter("scode");
			email = request.getParameter("email");
			dto = new ClientDTO (idclient,idmoderator, username, password, scode, email);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idclient = Integer.parseInt(request.getParameter("idclient"));
			ans = service.delete(idclient);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;
		}
	}
}