package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Evento;
import com.jumogira.gestoreventos.service.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/evento")
@AllArgsConstructor
public class EventoController {

    EventoService eventoService;

    @PostMapping("/")
    public Mono<Evento> guardar(@RequestBody @Validated Evento evento) {
        return eventoService.save(evento);
    }

    @GetMapping("/eventos")
    public Flux<Evento> consultarEventos() {
        return eventoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Evento> consultarEventoId(@PathVariable("id") Integer id) {
        return eventoService.findById(id);
    }


}
