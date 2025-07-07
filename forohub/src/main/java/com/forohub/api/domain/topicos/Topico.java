package com.forohub.api.domain.topicos;

import java.time.LocalDate;

import com.forohub.api.domain.cursos.Curso;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos", uniqueConstraints = @UniqueConstraint(columnNames = { "titulo", "mensaje" }))
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    @Column(name = "status_topico")
    private Boolean estado;
    private String autor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = datos.fechaCreacion() != null ? datos.fechaCreacion() : LocalDate.now();
        this.estado = datos.estado() != null ? datos.estado() : true;
        this.autor = datos.autor();
        this.curso = new Curso(datos.curso());
    }

    public void updateInformation(@Valid DatosRegistroTopico data) {
        this.titulo = data.titulo() != null ? data.titulo() : "";
        this.mensaje = data.mensaje() != null ? data.mensaje() : "";
        this.fechaCreacion = data.fechaCreacion() != null ? data.fechaCreacion() : LocalDate.now();
        this.estado = data.estado() != null ? data.estado() : true;
        this.autor = data.autor() != null ? data.autor() : "";
        this.curso = this.curso.updateInformationCurso(data.curso());
    }
}
