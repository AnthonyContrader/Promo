package com.project.contrader.service;

import com.project.contrader.service.dto.ScreenDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Screen.
 */
public interface ScreenService {

    /**
     * Save a screen.
     *
     * @param screenDTO the entity to save
     * @return the persisted entity
     */
    ScreenDTO save(ScreenDTO screenDTO);

    /**
     * Get all the screens.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ScreenDTO> findAll(Pageable pageable);


    /**
     * Get the "id" screen.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ScreenDTO> findOne(Long id);

    /**
     * Delete the "id" screen.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
