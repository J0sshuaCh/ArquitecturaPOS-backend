package com.pos.backend.controller;

import com.pos.backend.ws.model.TipoCambioRequest;
import com.pos.backend.ws.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/tipo-cambio")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    @GetMapping
    public ResponseEntity<?> convertir(
            @RequestParam BigDecimal monto,
            @RequestParam String monedaOrigen,
            @RequestParam String monedaDestino) {
        try {
            TipoCambioRequest request = new TipoCambioRequest();
            request.setMonto(monto);
            request.setMonedaOrigen(monedaOrigen);
            request.setMonedaDestino(monedaDestino);
            return ResponseEntity.ok(tipoCambioService.convertir(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
