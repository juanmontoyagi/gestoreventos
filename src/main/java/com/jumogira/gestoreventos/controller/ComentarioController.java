package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Comentario;
import com.jumogira.gestoreventos.service.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/comentarios")
@AllArgsConstructor
public class ComentarioController {

    ComentarioService comentarioService;

    @PostMapping("/")
    public Mono<Comentario> guardar(@RequestBody @Validated Comentario evento) {
        return comentarioService.save(evento);
    }

    @GetMapping("/")
    public Flux<Comentario> consultarComentariosEvento(@RequestBody @Validated String eventoId) {
        return comentarioService.buscarComentariosPorEvento(eventoId);
    }

    @GetMapping("/")
    public Flux<Comentario> consultarComentariosUsuario(@RequestBody @Validated String usuarioId) {
        return comentarioService.buscarComentariosPorUsuario(usuarioId);
    }

}
