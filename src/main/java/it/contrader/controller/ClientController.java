package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ClientDTO;
import it.contrader.dto.DeviceDTO;

import it.contrader.service.ClientService;
import it.contrader.service.DeviceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Client")
public class ClientController {

/*	private final ClientService clientService;
	private final DeviceService deviceService;
	private HttpSession session;*/
	
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	DeviceService deviceService;
	
	
	/*@Autowired
	public ClientController(ClientService clientService, DeviceService deviceService) {
		this.clientService = clientService;
		this.deviceService = deviceService;
	}
	
	
	
	@GetMapping("/viewloginClient")
	public String viewloginClient() {
		return clientService;		
	}*/
	
	
	@PostMapping(value = "/loginClient")
	public ClientDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {
		return(clientService.getByUsernameAndPassword(username, password));
	}
	
	
	/*@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	
	@GetMapping("/freeEnter")
	public String freeEnter() {
		return "client/homeFreeClient";		
	}
	
	private void visualDevice(HttpServletRequest request){
		List<DeviceDTO> allDevice = this.deviceService.getListaDeviceDTO();
		request.setAttribute("allDevice", allDevice);
	}*/
	
	@GetMapping(value = "/deviceManagement")
	public List <DeviceDTO> getAllDevices (@RequestParam("idclient") Integer idclient){
		return deviceService.findDevicesByClient(idclient);
	}
	
	/*
	@GetMapping("/viewNewDevice")
	public String viewNewDevice() {
		return "client/viewNewDevice";		
	}
	
	@RequestMapping(value = "/insertNewDevice", method = RequestMethod.POST)
	public String insertNewDevice(HttpServletRequest request) {
		Integer idclient = Integer.parseInt(request.getParameter("idclient").toString());
		ClientDTO client = clientService.getClientDTOById(idclient);
		String mac = request.getParameter("mac").toString();
		String devtype = request.getParameter("devtype").toString();
		String position = request.getParameter("position").toString();

		DeviceDTO device = new DeviceDTO(0, client, mac, devtype, position);
		
		deviceService.insertDevice(device);

		visualDevice(request);
		return "client/deviceManagement";
	}
	
	@RequestMapping(value = "/viewDeviceUpdate", method = RequestMethod.GET)
	public String viewDeviceUpdate(HttpServletRequest request) {
		int iddevice = Integer.parseInt(request.getParameter("iddevice"));
		DeviceDTO device = deviceService.getDeviceDTOById(iddevice);
		request.setAttribute("device", device);
		return "client/updateDevice";		
	}
	
	@RequestMapping(value = "/updateDevice", method = RequestMethod.POST)
	public String updateDevice(HttpServletRequest request) {
		int iddevice = Integer.parseInt(request.getParameter("iddevice"));
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		ClientDTO client = clientService.getClientDTOById(idclient);
		String macUpdate = request.getParameter("mac");
		String devtypeUpdate = request.getParameter("devtype");
		String positionUpdate = request.getParameter("position");
		
		final DeviceDTO device = new DeviceDTO(iddevice, client, macUpdate, devtypeUpdate, positionUpdate);
		device.setIddevice(iddevice);
		
		deviceService.updateDevice(device);
		
		visualDevice(request);
		return "client/deviceManagement";	
	}
	
	@RequestMapping(value = "/deleteDevice", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int iddevice = Integer.parseInt(request.getParameter("iddevice"));
		request.setAttribute("iddevice", iddevice);
		this.deviceService.deleteDeviceById(iddevice);
		visualDevice(request);
		return "client/deviceManagement";
	}*/
	
}