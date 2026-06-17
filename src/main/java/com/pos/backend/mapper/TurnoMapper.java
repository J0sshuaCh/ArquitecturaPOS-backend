package com.pos.backend.mapper;

import com.pos.backend.model.dto.TurnoResponseDTO;
import com.pos.backend.model.entity.TurnoCaja;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurnoMapper {
    TurnoMapper INSTANCE = Mappers.getMapper(TurnoMapper.class);

    TurnoResponseDTO toDTO(TurnoCaja entity);
    List<TurnoResponseDTO> toDTOList(List<TurnoCaja> entities);
}
