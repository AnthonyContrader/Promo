package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Screen;

import java.util.List;

public interface ScreenRepository extends CrudRepository<Screen, Integer> {

	public Screen findScreenById(Integer idscreen);
	public List<Screen> findAllByOutput(String output);
}
