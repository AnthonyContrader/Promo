package com.project.contrader.service.mapper;

import com.project.contrader.domain.*;
import com.project.contrader.service.dto.DeviceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Device and its DTO DeviceDTO.
 */
@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface DeviceMapper extends EntityMapper<DeviceDTO, Device> {

    @Mapping(source = "client.id", target = "clientId")
    DeviceDTO toDto(Device device);

    @Mapping(source = "clientId", target = "client")
    Device toEntity(DeviceDTO deviceDTO);

    default Device fromId(Long id) {
        if (id == null) {
            return null;
        }
        Device device = new Device();
        device.setId(id);
        return device;
    }
}
