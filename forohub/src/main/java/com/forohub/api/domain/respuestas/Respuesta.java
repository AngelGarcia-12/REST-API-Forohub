package com.forohub.api.domain.respuestas;

import java.time.LocalDate;

import com.forohub.api.domain.topicos.DatosRegistroTopico;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.AllArgsConstructor;

// @Table(name = "respuestas")
// @Entity(name = "Respuesta")
@Getter
@AllArgsConstructor
public class Respuesta {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    // @JoinColumn(name = "topico_id", nullable = false)
    private DatosRegistroTopico topico;

    private LocalDate fechaCreacion = LocalDate.now();
    private String autor;
    private String solucion;
}
