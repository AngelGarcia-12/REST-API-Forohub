package com.forohub.api.domain.cursos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(
    @NotBlank String nombre,
    @NotNull Categoria categoria
) {}
