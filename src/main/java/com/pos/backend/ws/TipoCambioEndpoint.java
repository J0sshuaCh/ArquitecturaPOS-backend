package com.pos.backend.ws;

import com.pos.backend.ws.model.TipoCambioRequest;
import com.pos.backend.ws.model.TipoCambioResponse;
import com.pos.backend.ws.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
@RequiredArgsConstructor
public class TipoCambioEndpoint {

    private static final String NAMESPACE_URI = "http://pos.com/tipocambio";

    private final TipoCambioService tipoCambioService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "tipoCambioRequest")
    @ResponsePayload
    public TipoCambioResponse convertir(@RequestPayload TipoCambioRequest request) {
        BigDecimal montoConvertido = tipoCambioService.convertir(
                request.getMonto(), request.getMonedaOrigen(), request.getMonedaDestino());

        TipoCambioResponse response = new TipoCambioResponse();
        response.setMontoOriginal(request.getMonto());
        response.setMontoConvertido(montoConvertido);
        response.setMonedaOrigen(request.getMonedaOrigen().toUpperCase());
        response.setMonedaDestino(request.getMonedaDestino().toUpperCase());
        response.setTasaCambio(tipoCambioService.getTasaCambio());
        return response;
    }
}
