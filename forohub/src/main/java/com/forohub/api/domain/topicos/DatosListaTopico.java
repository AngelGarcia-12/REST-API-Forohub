package com.forohub.api.domain.topicos;

import java.time.LocalDate;

import com.forohub.api.domain.cursos.Curso;

public record DatosListaTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDate fechaCreacion,
    Boolean estado,
    String autor,
    Curso curso
) {
    public DatosListaTopico(Topico topico) {
        this(topico.getId(),
             topico.getTitulo(),
             topico.getMensaje(), 
             topico.getFechaCreacion(), 
             topico.getEstado(), 
             topico.getAutor(), 
             topico.getCurso()
        );
    }
}
