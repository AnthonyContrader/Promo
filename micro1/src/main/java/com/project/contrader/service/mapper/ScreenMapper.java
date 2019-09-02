package com.project.contrader.service.mapper;

import com.project.contrader.domain.*;
import com.project.contrader.service.dto.ScreenDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Screen and its DTO ScreenDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ScreenMapper extends EntityMapper<ScreenDTO, Screen> {



    default Screen fromId(Long id) {
        if (id == null) {
            return null;
        }
        Screen screen = new Screen();
        screen.setId(id);
        return screen;
    }
}
