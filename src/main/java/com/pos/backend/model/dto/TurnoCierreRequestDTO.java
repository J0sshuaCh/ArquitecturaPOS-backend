package com.pos.backend.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TurnoCierreRequestDTO {
    
    @NotNull(message = "El ID del turno es obligatorio")
    private Long id;

    @NotNull(message = "El monto de cierre es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El monto no puede ser negativo")
    private BigDecimal montoCierre;
}
