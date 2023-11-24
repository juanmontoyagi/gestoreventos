package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Comentario;
import com.jumogira.gestoreventos.service.ComentarioService;
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
public class ComentarioControllerTest {

    @InjectMocks
    private ComentarioController comentarioController;

    @Mock
    private ComentarioService comentarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetComentarios() {
        Comentario comentario1 = new Comentario(1, 1, 1, "Primer comentario del evento. ", "2023-11-23");
        Comentario comentario2 = new Comentario(2, 2, 1, "Segundo comentario del evento. ", "2023-11-23");

        Flux<Comentario> comentarios = Flux.just(comentario1, comentario2);
        when(comentarioService.findAll()).thenReturn(comentarios);

        Flux<Comentario> comentariosObtenidos = comentarioController.consultarComentarios();
        comentariosObtenidos.subscribe();
        assertEquals(comentarios, comentariosObtenidos);
    }

    @Test
    public void testGetComentarioById() {
        Comentario comentario1 = new Comentario(1, 1, 1, "Primer comentario del evento. ", "2023-11-23");
        Mono<Comentario> comentarios = Mono.just(comentario1);
        when(comentarioService.findById(any())).thenReturn(comentarios);
        Mono<Comentario> comentarioObtenido = comentarioController.consultarComentarioId(1);
        comentarioObtenido.subscribe();
        assertEquals(comentarios,comentarioObtenido);
    }

}
