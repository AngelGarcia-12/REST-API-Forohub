package com.forohub.api.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosUsuario(
    @NotNull Long id,
    @NotBlank String nombre,
    @NotBlank @Email String correoElectronico,
    @NotBlank @Size(min = 6, max = 15) String contrasena
) {}
