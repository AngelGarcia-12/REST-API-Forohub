package com.forohub.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.api.domain.cursos.Curso;
import com.forohub.api.domain.topicos.DatosListaTopico;
import com.forohub.api.domain.topicos.DatosRegistroTopico;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void createTopic(@RequestBody @Valid DatosRegistroTopico data) {
        // if (repository.existsByTituloAndMensaje(data.titulo(), data.mensaje())) {
        //     ResponseEntity
        //             .status(HttpStatus.CONFLICT)      // 409
        //             .body("Ya existe un tópico con ese título y mensaje");
        // }
        repository.save(new Topico(data));
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<DatosListaTopico> listTopics(
        @RequestParam(required = false) Curso curso,
        @RequestParam(required = false) Integer anio,
        @PageableDefault(size = 10, sort = {"fechaCreacion"}, direction = Sort.Direction.ASC) 
        Pageable page) {
        return repository.findAll(page).map(DatosListaTopico::new);
    }

    @Transactional
    @PutMapping("/{id}")
    public void updateTopic(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico data) {
        Optional<Topico> optionalTopico = repository.findById(id);
        if(optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.updateInformation(data);
        }
        else {
            ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico data) {
        Optional<Topico> optionalTopico = repository.findById(id);
        if(optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
        }
        else {
            ResponseEntity.notFound().build();
        }
    }
}
