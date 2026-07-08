package com.pos.backend.ws.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TipoCambioService {

    // Tasa fija de referencia: 1 USD = 3.75 PEN
    private static final BigDecimal TASA_CAMBIO = new BigDecimal("3.75");

    public BigDecimal convertir(BigDecimal monto, String monedaOrigen, String monedaDestino) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser nulo o negativo");
        }

        String origen = monedaOrigen == null ? "" : monedaOrigen.trim().toUpperCase();
        String destino = monedaDestino == null ? "" : monedaDestino.trim().toUpperCase();

        if (origen.equals(destino)) {
            return monto.setScale(2, RoundingMode.HALF_UP);
        }
        if (origen.equals("USD") && destino.equals("PEN")) {
            return monto.multiply(TASA_CAMBIO).setScale(2, RoundingMode.HALF_UP);
        }
        if (origen.equals("PEN") && destino.equals("USD")) {
            return monto.divide(TASA_CAMBIO, 2, RoundingMode.HALF_UP);
        }
        throw new IllegalArgumentException("Conversión no soportada: " + origen + " -> " + destino);
    }

    public BigDecimal getTasaCambio() {
        return TASA_CAMBIO;
    }
}
