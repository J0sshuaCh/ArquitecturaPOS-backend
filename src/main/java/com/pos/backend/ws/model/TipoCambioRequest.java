package com.pos.backend.ws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "monto", "monedaOrigen", "monedaDestino" })
@XmlRootElement(name = "tipoCambioRequest", namespace = "http://pos.com/tipocambio")
public class TipoCambioRequest {

    @XmlElement(namespace = "http://pos.com/tipocambio", required = true)
    private BigDecimal monto;

    @XmlElement(namespace = "http://pos.com/tipocambio", required = true)
    private String monedaOrigen;

    @XmlElement(namespace = "http://pos.com/tipocambio", required = true)
    private String monedaDestino;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
}
