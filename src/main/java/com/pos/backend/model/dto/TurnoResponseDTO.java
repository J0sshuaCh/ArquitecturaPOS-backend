package com.pos.backend.model.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TurnoResponseDTO {
    private Long id;
    private String cajero;
    private BigDecimal montoApertura;
    private BigDecimal montoCierre;
    private LocalDateTime fechaApertura;
    private Integer estado;
}
