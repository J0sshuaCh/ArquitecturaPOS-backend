package com.pos.backend.service;

import com.pos.backend.model.entity.TurnoCaja;

import java.math.BigDecimal;
import java.util.List;

public interface TurnoService {
    TurnoCaja abrir(String cajero, BigDecimal montoApertura);
    TurnoCaja cerrar(Long id, BigDecimal montoCierre);
    List<TurnoCaja> obtenerHistorial();
}
