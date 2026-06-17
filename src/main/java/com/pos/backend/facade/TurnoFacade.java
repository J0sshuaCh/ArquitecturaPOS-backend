package com.pos.backend.facade;

import com.pos.backend.mapper.TurnoMapper;
import com.pos.backend.model.dto.TurnoAperturaRequestDTO;
import com.pos.backend.model.dto.TurnoCierreRequestDTO;
import com.pos.backend.model.dto.TurnoResponseDTO;
import com.pos.backend.model.entity.TurnoCaja;
import com.pos.backend.service.TurnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TurnoFacade {

    private final TurnoService turnoService;
    private final TurnoMapper turnoMapper;

    public TurnoResponseDTO abrirTurno(TurnoAperturaRequestDTO dto) {
        TurnoCaja entity = turnoService.abrir(dto.getCajero(), dto.getMontoApertura());
        return turnoMapper.toDTO(entity);
    }

    public TurnoResponseDTO cerrarTurno(TurnoCierreRequestDTO dto) {
        TurnoCaja entity = turnoService.cerrar(dto.getId(), dto.getMontoCierre());
        return turnoMapper.toDTO(entity);
    }

    public List<TurnoResponseDTO> obtenerHistorial() {
        List<TurnoCaja> entities = turnoService.obtenerHistorial();
        return turnoMapper.toDTOList(entities);
    }
}
