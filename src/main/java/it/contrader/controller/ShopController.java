package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private void visualShop(HttpServletRequest request){
			List<ShopDTO> allShop = this.shopService.getListaShopDTO();
		request.setAttribute("allShopDTO", allShop);
	}
	
//gestione dello shop database
	@RequestMapping(value = "/shopManagement", method = RequestMethod.GET)
	public String shopManagement(HttpServletRequest request) {
		visualShop(request);
		return "homeShop";
	}

//insert dello shop 
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualShop(request);
		request.setAttribute("option", "insert");
		return "creaShop";

	}

//insert dello shop, ricordare che sul front end c'è da mettere che solo lo shoptype=admin può accedere a questa sezione
	@RequestMapping(value = "/creaShop", method = RequestMethod.POST)
	public String insertShop(HttpServletRequest request) {
		
		ShopDTO shopObj = new ShopDTO();
		
		String  name= request.getParameter("nome").toString();
		String  position= request.getParameter("posizione").toString();
		String  barcode= request.getParameter("barcode").toString();
		String type=request.getParameter("tipo").toString();
		
		shopObj.setName(name);
		shopObj.setPosition(position);
        shopObj.setBarcode(barcode);
        shopObj.setType(type);
		shopService.insertShop(shopObj);
		
		visualShop(request);
		return "homeShop";
	}
	
//Update dello shop
	@GetMapping("/viewNewShop")
	public String viewNewShop() {
		return "shop/viewNewShop";		
	}
	
	@RequestMapping(value = "/viewShopUpdate", method = RequestMethod.GET)
	public String viewShopUpdate(HttpServletRequest request) {
		int idShop = Integer.parseInt(request.getParameter("idshop"));
		ShopDTO shop = shopService.getShopDTOById(idShop);
		request.setAttribute("shop", shop);
		return "shop/updateShop";		
	}
	
	@RequestMapping(value = "/updateShop", method = RequestMethod.POST)
	public String updateShop(HttpServletRequest request) {
		
		int idUpdate = Integer.parseInt(request.getParameter("idshop"));
	    int iduserUpdate= Integer.parseInt(request.getParameter("iduser"));
		String nameUpdate = request.getParameter("nome");
		String positionUpdate = request.getParameter("posizione");
		String typeUpdate = request.getParameter("tipo");
		String barcodeUpdate =request.getParameter("barcode");
		
		final ShopDTO shop = new ShopDTO(idUpdate, iduserUpdate ,nameUpdate, positionUpdate, typeUpdate, barcodeUpdate);
		
		shopService.updateShop(shop);
		visualShop(request);
		return "shop/homeShop";	
	}
	
//delete dello shop
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idshop"));
		request.setAttribute("idshop", id);
		this.shopService.deleteShopById(id);
		visualShop(request);
		return "homeShop";
		}
		
//cerca shop in base al nome
	@RequestMapping(value = "/cercaShop", method = RequestMethod.GET)
	public String cercaShopName(HttpServletRequest request) {
		final String content = request.getParameter("search");
		List<ShopDTO> nameShops = this.shopService.findShopDTObyName(content);
		request.setAttribute("allShopDTO", nameShops);
		return "homeShop";
	}
		
//cerca shop in base al tipo
		@RequestMapping(value = "/cercaShop", method = RequestMethod.GET)
		public String cercaShopType(HttpServletRequest request) {
			final String content = request.getParameter("search");
			List<ShopDTO> typeShops = this.shopService.findShopDTObyType(content);
			request.setAttribute("allShopDTO", typeShops);
			return "homeShop";
		}

}