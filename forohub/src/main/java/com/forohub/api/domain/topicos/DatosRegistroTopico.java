package com.forohub.api.domain.topicos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.forohub.api.domain.cursos.DatosCurso;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
    @NotBlank String titulo,
    @NotBlank String mensaje,
    @JsonFormat(pattern = "dd-MM-yyyy") LocalDate fechaCreacion,
    Boolean estado,
    @NotBlank String autor,
    @NotNull @Valid DatosCurso curso
) {} 
