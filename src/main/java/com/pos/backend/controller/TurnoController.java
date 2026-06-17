package com.pos.backend.controller;

import com.pos.backend.facade.TurnoFacade;
import com.pos.backend.model.dto.TurnoAperturaRequestDTO;
import com.pos.backend.model.dto.TurnoCierreRequestDTO;
import com.pos.backend.model.dto.TurnoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
@CrossOrigin
@RequiredArgsConstructor
public class TurnoController {

    private final TurnoFacade turnoFacade;

    @PostMapping("/abrir")
    public ResponseEntity<?> abrirTurno(@Valid @RequestBody TurnoAperturaRequestDTO request) {
        try {
            return new ResponseEntity<>(turnoFacade.abrirTurno(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/cerrar")
    public ResponseEntity<?> cerrarTurno(@Valid @RequestBody TurnoCierreRequestDTO request) {
        try {
            return ResponseEntity.ok(turnoFacade.cerrarTurno(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> obtenerHistorial() {
        return ResponseEntity.ok(turnoFacade.obtenerHistorial());
    }
}
