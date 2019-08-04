package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Shop;

import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Integer> {

	public Shop findByIdshop(Integer idshop);
	public List<Shop> findShopByType(String type);
	public List<Shop> findAllByName(String name);
}
