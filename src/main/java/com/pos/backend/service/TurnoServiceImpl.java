package com.pos.backend.service;

import com.pos.backend.model.entity.TurnoCaja;
import com.pos.backend.repository.TurnoCajaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TurnoServiceImpl implements TurnoService {

    private final TurnoCajaRepository repository;

    @Override
    @Transactional
    public TurnoCaja abrir(String cajero, BigDecimal montoApertura) {
        log.info("Llamando a SP_ABRIR_TURNO para cajero: {}", cajero);
        Long generatedId = repository.abrirTurno(cajero, montoApertura);
        return repository.findById(generatedId)
                .orElseThrow(() -> new RuntimeException("Error: No se encontró el turno generado"));
    }

    @Override
    @Transactional
    public TurnoCaja cerrar(Long id, BigDecimal montoCierre) {
        log.info("Llamando a SP_CERRAR_TURNO para id: {}", id);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Error: El turno no existe");
        }
        repository.cerrarTurno(id, montoCierre);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: No se encontró el turno cerrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TurnoCaja> obtenerHistorial() {
        log.info("Obteniendo historial completo de turnos...");
        List<TurnoCaja> turnos = repository.findAll();
        log.info("Turnos encontrados: {}", turnos.size());
        return turnos;
    }
}
