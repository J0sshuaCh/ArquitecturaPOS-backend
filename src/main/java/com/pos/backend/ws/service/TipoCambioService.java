package com.pos.backend.ws.service;

import com.pos.backend.ws.model.TipoCambioRequest;
import com.pos.backend.ws.model.TipoCambioResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TipoCambioService {

    private static final BigDecimal TASA_CAMBIO = new BigDecimal("3.75");

    public TipoCambioResponse convertir(TipoCambioRequest request) {
        BigDecimal montoConvertido = convertir(
                request.getMonto(), request.getMonedaOrigen(), request.getMonedaDestino());

        String origen = request.getMonedaOrigen() == null ? "" : request.getMonedaOrigen().trim().toUpperCase();
        String destino = request.getMonedaDestino() == null ? "" : request.getMonedaDestino().trim().toUpperCase();

        TipoCambioResponse response = new TipoCambioResponse();
        response.setMontoOriginal(request.getMonto());
        response.setMontoConvertido(montoConvertido);
        response.setMonedaOrigen(origen);
        response.setMonedaDestino(destino);
        response.setTasaCambio(TASA_CAMBIO);
        return response;
    }

    private BigDecimal convertir(BigDecimal monto, String monedaOrigen, String monedaDestino) {
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
}
