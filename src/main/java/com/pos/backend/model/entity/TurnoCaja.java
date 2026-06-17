package com.pos.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TURNO_CAJA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurnoCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CAJERO", nullable = false, length = 100)
    private String cajero;

    @Column(name = "MONTO_APERTURA", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoApertura;

    @Column(name = "MONTO_CIERRE", precision = 10, scale = 2)
    private BigDecimal montoCierre;

    @Column(name = "FECHA_APERTURA", nullable = false)
    private LocalDateTime fechaApertura;

    @Column(name = "ESTADO", nullable = false)
    private Integer estado;

    @Column(name = "PROCESADO_DW", nullable = false)
    private Integer procesadoDw;
}
