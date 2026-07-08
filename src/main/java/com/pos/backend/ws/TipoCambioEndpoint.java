package com.pos.backend.ws;

import com.pos.backend.ws.model.TipoCambioRequest;
import com.pos.backend.ws.model.TipoCambioResponse;
import com.pos.backend.ws.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class TipoCambioEndpoint {

    private static final String NAMESPACE_URI = "http://pos.com/tipocambio";

    private final TipoCambioService tipoCambioService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "tipoCambioRequest")
    @ResponsePayload
    public TipoCambioResponse convertir(@RequestPayload TipoCambioRequest request) {
        return tipoCambioService.convertir(request);
    }
}
