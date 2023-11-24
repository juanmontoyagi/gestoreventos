package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Usuario;
import com.jumogira.gestoreventos.service.UsuarioService;
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
public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsuarios() {
        Usuario usuario1 = new Usuario(1, "Juan", "juan@email.com", 22, true);
        Usuario usuario2 = new Usuario(2, "Pedro", "pedro@email.com", 27, true);

        Flux<Usuario> usuarios = Flux.just(usuario1, usuario2);
        when(usuarioService.findAll()).thenReturn(usuarios);
        Flux<Usuario> usuariosObtenidos = usuarioController.consultarUsuarios();
        usuariosObtenidos.subscribe();
        assertEquals(usuarios, usuariosObtenidos);
    }

    @Test
    public void testGetUsuarioById() {
        Usuario usuario1 = new Usuario(1, "Juan", "juan@email.com", 22, true);
        Mono<Usuario> usuarios = Mono.just(usuario1);
        when(usuarioService.findById(any())).thenReturn(usuarios);
        Mono<Usuario> usuariosObtenidos = usuarioController.consultarUsuarioId(1);
        usuariosObtenidos.subscribe();
        assertEquals(usuarios,usuariosObtenidos);
    }

}
