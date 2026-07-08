package com.pos.backend.controller;

import com.pos.backend.ws.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tipo-cambio")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    // Ej: GET /api/v1/tipo-cambio?monto=100&monedaOrigen=USD&monedaDestino=PEN
    @GetMapping
    public ResponseEntity<?> convertir(
            @RequestParam BigDecimal monto,
            @RequestParam String monedaOrigen,
            @RequestParam String monedaDestino) {
        try {
            BigDecimal montoConvertido = tipoCambioService.convertir(monto, monedaOrigen, monedaDestino);
            return ResponseEntity.ok(Map.of(
                    "montoOriginal", monto,
                    "montoConvertido", montoConvertido,
                    "monedaOrigen", monedaOrigen.toUpperCase(),
                    "monedaDestino", monedaDestino.toUpperCase(),
                    "tasaCambio", tipoCambioService.getTasaCambio()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
