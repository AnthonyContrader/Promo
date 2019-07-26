package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.DeviceDTO;
import it.contrader.service.Service;
import it.contrader.service.DeviceService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class DeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeviceServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<DeviceDTO> service = new DeviceService();
		List<DeviceDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<DeviceDTO> service = new DeviceService();
		String mode = request.getParameter("mode");
		DeviceDTO dto;
		int iddevice;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "DEVICELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/device/devicemanager.jsp").forward(request, response);
			break;

		case "READ":
			iddevice = Integer.parseInt(request.getParameter("iddevice").toString());
			dto = service.read(iddevice);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/device/readdevice.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/device/updatedevice.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int idowner = Integer.parseInt(request.getParameter("idowner").toString());
			String mac = request.getParameter("mac").toString();
			String devtype = request.getParameter("devtype").toString();
			String position = request.getParameter("position").toString();
			dto = new DeviceDTO (idowner,mac,devtype,position);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/device/devicemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			iddevice = Integer.parseInt(request.getParameter("iddevice"));
			idowner = Integer.parseInt(request.getParameter("idowner"));
			mac = request.getParameter("mac");
			devtype = request.getParameter("devtype");
			position = request.getParameter("position");
			iddevice = Integer.parseInt(request.getParameter("iddevice"));
			dto = new DeviceDTO (iddevice, idowner, mac, devtype, position);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/device/devicemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			iddevice = Integer.parseInt(request.getParameter("iddevice"));
			ans = service.delete(iddevice);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/device/devicemanager.jsp").forward(request, response);
			break;
		}
	}
}