package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.DeviceDTO;
import it.contrader.services.DeviceService;

import java.util.List;

@Controller
@RequestMapping("/Device")
public class DeviceController {

	private final DeviceService deviceService;
	//private HttpSession session;
	
	@Autowired
	public DeviceController(DeviceService deviceService) {
		
		this.deviceService = deviceService;
		
	}
//visualizza tutti i device
	private void visualDevice(HttpServletRequest request){
		
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDeviceDTO", allDevice);
		
	}
//gestione del device database
	@RequestMapping(value = "/deviceManagement", method = RequestMethod.GET)
	public String deviceManagement(HttpServletRequest request) {
		
		visualDevice(request);
		return "homeDevice";		
		
	}
//delete del device
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("iddevice"));
		request.setAttribute("iddevice", id);
		this.deviceService.deleteDeviceById(id);
		visualDevice(request);
		return "homeDevice";
		
	}
//insert del device 
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		
		visualDevice(request);
		request.setAttribute("option", "insert");
		return "creaDevice";
		
	}
//cerca del device
	@RequestMapping(value = "/cercaDevice", method = RequestMethod.GET)
	public String cercaDevice(HttpServletRequest request) {

		final String content = request.getParameter("search");
		List<DeviceDTO> allDevice = this.deviceService.findDeviceDTOByMac(content);
		request.setAttribute("allDeviceDTO", allDevice);
		return "homeDevice";

	}
//insert del device
	@RequestMapping(value = "/creaDevice", method = RequestMethod.POST)
	public String insertDevice(HttpServletRequest request) {
		
		DeviceDTO deviceObj = new DeviceDTO();
		
		String mac = request.getParameter("mac").toString();
		String devtype = request.getParameter("devtype").toString();
		String position = request.getParameter("position").toString();
		
		deviceObj.setMac(mac);
		deviceObj.setDevtype(devtype);
		deviceObj.setPosition(position);
        //deviceObj.setIddevice(deviceObj.getIddevice());
		//CONTROLLARE SE METTERE
		deviceService.insertDevice(deviceObj);
		
		visualDevice(request);
		return "homeDevice";
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String mac = request.getParameter("mac");
		final String devtype = request.getParameter("devtype");
		final DeviceDTO deviceDTO = DeviceService.getByDevicenameAndPassword(mac, devtype);
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", deviceDTO);
			if (ruolo.equals("ADMIN")) {
				return "home";
			} else if (ruolo.equals("CHATMASTER")) {
				return "home";
			}
		}
		return "index";
	}*/
}
