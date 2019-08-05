package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.CatalogDTO;
import it.contrader.model.Catalog;

public class ConverterCatalog {

	public static CatalogDTO toDTO(Catalog catalog) {
		CatalogDTO catalogDTO = null;
		if (catalog != null) {
			catalogDTO = new CatalogDTO();
			catalogDTO.setIdcatalog(catalog.getIdcatalog());
			catalogDTO.setName(catalog.getName());
			catalogDTO.setType(catalog.getType());
			catalogDTO.setPrice(catalog.getPrice());
		}
		return catalogDTO;
	}

	public static Catalog toEntity(CatalogDTO catalogDTO) {
		Catalog catalog = null;
		if (catalogDTO != null) {
			catalog = new Catalog();
			catalog.setIdcatalog(catalogDTO.getIdcatalog());
			catalog.setName(catalogDTO.getName());
			catalog.setType(catalogDTO.getType());
			catalog.setType(catalogDTO.getType());
			catalog.setPrice(catalogDTO.getPrice());			
		}
		return catalog;
	}

	public static List<CatalogDTO> toListDTO(List<Catalog> list) {
		List<CatalogDTO> listCatalogDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Catalog catalog : list) {
				listCatalogDTO.add(ConverterCatalog.toDTO(catalog));
			}
		}
		return listCatalogDTO;
	}

	public static List<Catalog> toListEntity(List<CatalogDTO> listCatalogDTO) {
		List<Catalog> list = new ArrayList<>();
		if (!listCatalogDTO.isEmpty()) {
			for (CatalogDTO catalogDTO : listCatalogDTO) {
				list.add(ConverterCatalog.toEntity(catalogDTO));
			}
		}
		return list;
	}
}
