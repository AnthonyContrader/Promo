package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ShopDTO;
import it.contrader.services.ShopService;

import java.util.List;

@Controller
@RequestMapping("/Shop")
public class ShopController {

	private final ShopService shopService;
	private HttpSession session;
	
	@Autowired//costruttore
	public ShopController(ShopService shopService) {
		
		this.shopService = shopService;
		
	}
//visualizza tutti i shop
	private void visualShop(HttpServletRequest request){
		
		List<ShopDTO> allShop = this.shopService.getListaShopDTO();
		request.setAttribute("allShopDTO", allShop);
		
	}
//gestione del shop database
	@RequestMapping(value = "/shopManagement", method = RequestMethod.GET)
	public String shopManagement(HttpServletRequest request) {
		
		visualShop(request);
		return "homeshop.jsp";
		
	}
//delete del shop
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idshop"));
		request.setAttribute("idshop", id);
		this.shopService.deleteShopById(id);
		visualShop(request);
		return "homeshop.jsp";
		
	}
//insert del shop 
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualShop(request);
		request.setAttribute("option", "insert");
		return "creashop.jsp";

	}
//cerca shop in base al nome
	@RequestMapping(value = "/cercaShop", method = RequestMethod.GET)
	public String cercaShopName(HttpServletRequest request) {
		final String content = request.getParameter("search");
		List<ShopDTO> allShop = this.shopService.findShopDTObyName(content);
		request.setAttribute("allShopDTO", allShop);
		return "homeshop.jsp";
	}
		
//cerca shop in base al tipo
		@RequestMapping(value = "/cercaShop", method = RequestMethod.GET)
		public String cercaShopType(HttpServletRequest request) {
			final String content = request.getParameter("search");
			List<ShopDTO> allShop = this.shopService.findShopDTObyType(content);
			request.setAttribute("allShopDTO", allShop);
			return "homeshop.jsp";
		}
		
//insert del shop, ricordare che sul front end c'è da mettere che solo lo usertype=admin può accedere a questa sezione
	@RequestMapping(value = "/creaShop", method = RequestMethod.POST)
	public String insertShop(HttpServletRequest request) {
		
		ShopDTO shopObj = new ShopDTO();
		String  name= request.getParameter("name").toString();
		String  position= request.getParameter("position").toString();
		String  barcode= request.getParameter("barcode").toString();
		String type=request.getParameter("type").toString();
		
		shopObj.setName(name);
		shopObj.setPosition(position);
        shopObj.setBarcode(barcode);
        shopObj.setType(type);
		shopService.insertShop(shopObj);
		
		visualShop(request);
		return "homeshop.jsp";
	}
	
}