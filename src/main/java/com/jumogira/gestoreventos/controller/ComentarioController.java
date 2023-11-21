package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Comentario;
import com.jumogira.gestoreventos.service.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comentario")
@AllArgsConstructor
public class ComentarioController {

    ComentarioService comentarioService;

    @PostMapping("/")
    public Mono<Comentario> guardar(@RequestBody @Validated Comentario comentario) {
        return comentarioService.save(comentario);
    }

    @GetMapping("/comentarios")
    public Flux<Comentario> consultarComentarios() {
        return comentarioService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Comentario> consultarComentarioId(@PathVariable("id") Integer id) {
        return comentarioService.findById(id);
    }

}
