package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterShop;
import it.contrader.dao.ShopRepository;
import it.contrader.dto.ShopDTO;
import it.contrader.model.Shop;

@Service
public class ShopService {

	private final ShopRepository ShopRepository;

	@Autowired
	public ShopService(ShopRepository ShopRepository) {
		this.ShopRepository = ShopRepository;
	}

	public List<ShopDTO> getListaShopDTO() {
		return ConverterShop.toListDTO((List<Shop>) ShopRepository.findAll());
	}
//ottieni i dati da dto in base all'id passato
	public ShopDTO getShopDTOById(Integer idshop) {
		return ConverterShop.toDTO(ShopRepository.findById(idshop).get());
	}
//inserisci il valore nel DTO
	public boolean insertShop(ShopDTO shopDTO) {
		return ShopRepository.save(ConverterShop.toEntity(shopDTO)) != null;
	}

//update shop in DTO
	public boolean updateShop(ShopDTO shopDTO) {
		return ShopRepository.save(ConverterShop.toEntity(shopDTO)) != null;
	}
//delete shop in DTO
	public void deleteShopById(Integer id) {
		ShopRepository.deleteById(id);
	}
	
//ottieni dal nome la lista degli shop
	public List<ShopDTO> findShopDTObyName(String name) {
		final List<Shop> list = ShopRepository.findAllByName(name);
		final List<ShopDTO> shopDTOs = new ArrayList<>();
		list.forEach(i -> shopDTOs.add(ConverterShop.toDTO(i)));
		return shopDTOs;
		}
		
//ottieni dal tipo la lista degli shop
	public List<ShopDTO> findShopDTObyType(String type) {
		final List<Shop> list = ShopRepository.findShopByType(type);
		final List<ShopDTO> shopDTOs = new ArrayList<>();
		list.forEach(i -> shopDTOs.add(ConverterShop.toDTO(i)));
		return shopDTOs;
		}	
}
