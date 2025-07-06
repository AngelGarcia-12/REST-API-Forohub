package com.forohub.api.domain.cursos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static Long id_re = 0L;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosCurso datos) {
        this.id = datos.id() != null ? datos.id() : id_re++;
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
    }

    public Curso updateInformationCurso(DatosCurso data) {
        this.nombre = data.nombre() != null ? data.nombre() : "";
        this.categoria = data.categoria();
        return this;
    }
}
