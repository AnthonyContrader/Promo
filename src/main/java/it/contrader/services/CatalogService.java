package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCatalog;
import it.contrader.dao.CatalogRepository;
import it.contrader.dto.CatalogDTO;
import it.contrader.model.Catalog;

@Service
public class CatalogService {

	private final CatalogRepository CatalogRepository;

	@Autowired
	public CatalogService(CatalogRepository CatalogRepository) {
		this.CatalogRepository = CatalogRepository;
	}

	public List<CatalogDTO> getListaCatalogDTO() {
		return ConverterCatalog.toListDTO((List<Catalog>) CatalogRepository.findAll());
	}
//ottieni i dati da dto in base all'id passato
	public CatalogDTO getCatalogDTOById(Integer idcatalog) {
		return ConverterCatalog.toDTO(CatalogRepository.findById(idcatalog).get());
	}
//inserisci il valore nel DTO
	public boolean insertCatalog(CatalogDTO catalogDTO) {
		return CatalogRepository.save(ConverterCatalog.toEntity(catalogDTO)) != null;
	}

//update catalog in DTO
	public boolean updateCatalog(CatalogDTO catalogDTO) {
		return CatalogRepository.save(ConverterCatalog.toEntity(catalogDTO)) != null;
	}
//delete catalog in DTO
	public void deleteCatalogById(Integer id) {
		CatalogRepository.deleteById(id);
	}
	
//ottieni dal nome la lista dei catalog
	public List<CatalogDTO> findCatalogDTObyName(String name) {
		final List<Catalog> list = CatalogRepository.findAllByName(name);
		final List<CatalogDTO> catalogDTOs = new ArrayList<>();
		list.forEach(i -> catalogDTOs.add(ConverterCatalog.toDTO(i)));
		return catalogDTOs;
		}
		
//ottieni dal tipo la lista dei catalog
	public List<CatalogDTO> findCatalogDTObyType(String type) {
		final List<Catalog> list = CatalogRepository.findCatalogByType(type);
		final List<CatalogDTO> catalogDTOs = new ArrayList<>();
		list.forEach(i -> catalogDTOs.add(ConverterCatalog.toDTO(i)));
		return catalogDTOs;
		}	
}
