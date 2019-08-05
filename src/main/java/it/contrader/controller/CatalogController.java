package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CatalogDTO;
import it.contrader.model.Shop;
import it.contrader.services.CatalogService;

import java.util.List;

@Controller
@RequestMapping("/Catalog")
public class CatalogController {

	private final CatalogService catalogService;
    private HttpSession session;
	
	@Autowired//costruttore
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	private void visualCatalog(HttpServletRequest request){
			List<CatalogDTO> allCatalog = this.catalogService.getListaCatalogDTO();
		request.setAttribute("allCatalogDTO", allCatalog);
	}
	
//gestione del catalog database
	@RequestMapping(value = "/catalogManagement", method = RequestMethod.GET)
	public String catalogManagement(HttpServletRequest request) {
		visualCatalog(request);
		return "homeCatalog";
	}

//insert del catalog 
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualCatalog(request);
		request.setAttribute("option", "insert");
		return "creaCatalog";

	}

//insert del catalog, ricordare che sul front end c'è da mettere che solo lo catalogtype=admin può accedere a questa sezione
	@RequestMapping(value = "/creaCatalog", method = RequestMethod.POST)
	public String insertCatalog(HttpServletRequest request) {
		
		CatalogDTO catalogObj = new CatalogDTO();
		
		String  name= request.getParameter("nome").toString();
		String  type= request.getParameter("tipo").toString();
		String price=request.getParameter("prezzo").toString();
		
		catalogObj.setName(name);
        catalogObj.setType(type);
        catalogObj.setPrice(price);
        
        catalogService.insertCatalog(catalogObj);
		        
        visualCatalog(request);
		return "homeCatalog";
	}
	
//Update del catalog
	@GetMapping("/viewNewCatalog")
	public String viewNewCatalog() {
		return "catalog/viewNewCatalog";		
	}
	
	@RequestMapping(value = "/viewCatalogUpdate", method = RequestMethod.GET)
	public String viewCatalogUpdate(HttpServletRequest request) {
		int idCatalog = Integer.parseInt(request.getParameter("idcatalog"));
		CatalogDTO catalog = catalogService.getCatalogDTOById(idCatalog);
		request.setAttribute("catalog", catalog);
		return "catalog/updateCatalog";		
	}
	
	@RequestMapping(value = "/updateCatalog", method = RequestMethod.POST)
	public String updateCatalog(HttpServletRequest request) {
		
		int idCatalogUpdate = Integer.parseInt(request.getParameter("idcatalog"));
		int iduserUpdate= Integer.parseInt(request.getParameter("idshop"));
		String nameUpdate = request.getParameter("nome");
		String typeUpdate = request.getParameter("tipo");
		String priceUpdate =request.getParameter("price");
		
		final CatalogDTO catalog = new CatalogDTO();
				catalog.setIdcatalog(iduserUpdate);
				catalog.setIdshop(idCatalogUpdate);
				catalog.setName(nameUpdate);
				catalog.setPrice(priceUpdate);
				catalog.setType(typeUpdate);
				
		catalogService.updateCatalog(catalog);
		visualCatalog(request);
		return "catalog/homeCatalog";	
	}
	
//delete del catalog
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idcatalog"));
		request.setAttribute("idcatalog", id);
		this.catalogService.deleteCatalogById(id);
		visualCatalog(request);
		return "homeCatalog";
		}
		
//cerca catalog in base al nome
	@RequestMapping(value = "/cercaCatalog", method = RequestMethod.GET)
	public String cercaCatalogName(HttpServletRequest request) {
		final String content = request.getParameter("search");
		List<CatalogDTO> nameCatalogs = this.catalogService.findCatalogDTObyName(content);
		request.setAttribute("allCatalogDTO", nameCatalogs);
		return "homeCatalog";
	}
		
//cerca catalog in base al tipo
		@RequestMapping(value = "/cercaCatalog", method = RequestMethod.GET)
		public String cercaCatalogType(HttpServletRequest request) {
			final String content = request.getParameter("search");
			List<CatalogDTO> typeCatalogs = this.catalogService.findCatalogDTObyType(content);
			request.setAttribute("allCatalogDTO", typeCatalogs);
			return "homeCatalog";
		}

}