package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Evento;
import com.jumogira.gestoreventos.service.EventoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventoControllerTest {

    @InjectMocks
    private EventoController eventoController;

    @Mock
    private EventoService eventoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEventos() {
        Evento evento1 = new Evento(1, "Concierto", "Concierto de rock", "2021-10-10", 100);
        Evento evento2 = new Evento(2, "Feria", "Feria de ganado", "2021-10-10", 100);
        Flux<Evento> eventos = Flux.just(evento1, evento2);
        when(eventoService.findAll()).thenReturn(eventos);
        Flux<Evento> eventosObtenidos = eventoController.consultarEventos();
        eventosObtenidos.subscribe();
        assertEquals(eventos, eventosObtenidos);
    }

    @Test
    public void testGetEventoById() {
        Evento evento1 = new Evento(1, "Concierto", "Concierto de rock", "2021-10-10", 100);
        Mono<Evento> eventos = Mono.just(evento1);
        when(eventoService.findById(any())).thenReturn(eventos);
        Mono<Evento> eventoObtenido = eventoController.consultarEventoId(1);
        eventoObtenido.subscribe();
        assertEquals(eventos,eventoObtenido);
    }

}
