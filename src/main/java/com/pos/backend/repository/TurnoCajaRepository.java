package com.pos.backend.repository;

import com.pos.backend.model.entity.TurnoCaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TurnoCajaRepository extends JpaRepository<TurnoCaja, Long> {

    List<TurnoCaja> findByEstadoOrderByFechaAperturaDesc(Integer estado);

    @Procedure(procedureName = "SP_ABRIR_TURNO")
    Long abrirTurno(
        @Param("p_cajero") String cajero, 
        @Param("p_monto_apertura") BigDecimal montoApertura
    );

    @Procedure(procedureName = "SP_CERRAR_TURNO")
    void cerrarTurno(
        @Param("p_id_turno") Long idTurno, 
        @Param("p_monto_cierre") BigDecimal montoCierre
    );
}
