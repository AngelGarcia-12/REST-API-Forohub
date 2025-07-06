package com.forohub.api.domain.respuestas;

import java.time.LocalDate;

import com.forohub.api.domain.topicos.DatosRegistroTopico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
    @NotNull Long id,
    @NotBlank String mensaje,
    @NotNull @Valid DatosRegistroTopico topico,
    LocalDate fechaCreacion,
    @NotBlank String autor,
    @NotBlank String solucion
) {}
