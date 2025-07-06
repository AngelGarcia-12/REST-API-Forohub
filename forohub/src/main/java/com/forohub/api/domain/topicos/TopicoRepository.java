package com.forohub.api.domain.topicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
    // @Query("""
    // SELECT t
    // FROM   Topico t
    // JOIN FETCH t.curso
    // WHERE  (:nombre IS NULL
    //         OR LOWER(t.curso.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
    //    AND (:anio IS NULL
    //         OR FUNCTION('year', t.fechaCreacion) = :anio)
    // """)
    // Page<Topico> findTopic(@Param("nombre") String nombre, @Param("anio") Integer anio, Pageable page);
}
