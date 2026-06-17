package com.pos.backend.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TurnoAperturaRequestDTO {
    
    @NotBlank(message = "El nombre del cajero es obligatorio")
    private String cajero;

    @NotNull(message = "El monto de apertura es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El monto no puede ser negativo")
    private BigDecimal montoApertura;
}
