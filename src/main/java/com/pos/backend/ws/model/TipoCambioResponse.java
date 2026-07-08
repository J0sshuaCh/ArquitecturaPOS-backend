package com.pos.backend.ws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "montoOriginal", "montoConvertido", "monedaOrigen", "monedaDestino", "tasaCambio" })
@XmlRootElement(name = "tipoCambioResponse", namespace = "http://pos.com/tipocambio")
public class TipoCambioResponse {

    @XmlElement(namespace = "http://pos.com/tipocambio")
    private BigDecimal montoOriginal;

    @XmlElement(namespace = "http://pos.com/tipocambio")
    private BigDecimal montoConvertido;

    @XmlElement(namespace = "http://pos.com/tipocambio")
    private String monedaOrigen;

    @XmlElement(namespace = "http://pos.com/tipocambio")
    private String monedaDestino;

    @XmlElement(namespace = "http://pos.com/tipocambio")
    private BigDecimal tasaCambio;

    public BigDecimal getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(BigDecimal montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public BigDecimal getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(BigDecimal montoConvertido) {
        this.montoConvertido = montoConvertido;
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

    public BigDecimal getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(BigDecimal tasaCambio) {
        this.tasaCambio = tasaCambio;
    }
}
