package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Catalog;

import java.util.List;

public interface CatalogRepository extends CrudRepository<Catalog, Integer> {

	public List<Catalog> findCatalogByType(String type);
	public List<Catalog> findAllByName(String name);
	public List<Catalog> findAll();
}
