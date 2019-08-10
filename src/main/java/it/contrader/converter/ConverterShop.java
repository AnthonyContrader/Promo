/*
package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ShopDTO;
import it.contrader.model.Shop;

public class ConverterShop {

	public static ShopDTO toDTO(Shop shop) {
		ShopDTO shopDTO = null;
		if (shop != null) {
			shopDTO = new ShopDTO();
			shopDTO.setIdshop(shop.getIdshop());
			shopDTO.setUser(ConverterUser.toDTO(shop.getUser()));
			shopDTO.setName(shop.getName());
			shopDTO.setType(shop.getType());
			shopDTO.setPosition(shop.getPosition());
			shopDTO.setBarcode(shop.getBarcode());
		}
		return shopDTO;
	}

	public static Shop toEntity(ShopDTO shopDTO) {
		Shop shop = null;
		if (shopDTO != null) {
			shop = new Shop();
			shop.setIdshop(shopDTO.getIdshop());
			shop.setUser(ConverterUser.toEntity(shopDTO.getUser()));
			shop.setName(shopDTO.getName());
			shop.setType(shopDTO.getType());
			shop.setPosition(shopDTO.getPosition());
			shop.setBarcode(shopDTO.getBarcode());			
		}
		return shop;
	}

	public static List<ShopDTO> toListDTO(List<Shop> list) {
		List<ShopDTO> listShopDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Shop shop : list) {
				listShopDTO.add(ConverterShop.toDTO(shop));
			}
		}
		return listShopDTO;
	}

	public static List<Shop> toListEntity(List<ShopDTO> listShopDTO) {
		List<Shop> list = new ArrayList<>();
		if (!listShopDTO.isEmpty()) {
			for (ShopDTO shopDTO : listShopDTO) {
				list.add(ConverterShop.toEntity(shopDTO));
			}
		}
		return list;
	}
}
*/