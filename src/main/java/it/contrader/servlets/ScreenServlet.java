package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ScreenDTO;
import it.contrader.service.Service;
import it.contrader.service.ScreenService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScreenServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ScreenDTO> service = new ScreenService();
		List<ScreenDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ScreenDTO> service = new ScreenService();
		String mode = request.getParameter("mode");
		ScreenDTO dto;
		int idscreen;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SCREENLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;

		case "READ":
			idscreen = Integer.parseInt(request.getParameter("idscreen"));
			dto = service.read(idscreen);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/screen/readscreen.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/user/updatescreen.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String output = request.getParameter("output").toString();
			dto = new ScreenDTO (output);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			idscreen = Integer.parseInt(request.getParameter("idscreen"));
			output = request.getParameter("output");
			dto = new ScreenDTO (idscreen,output);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idscreen = Integer.parseInt(request.getParameter("idscreen"));
			ans = service.delete(idscreen);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;
		}
	}
}