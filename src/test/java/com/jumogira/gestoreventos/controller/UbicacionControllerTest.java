package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Ubicacion;
import com.jumogira.gestoreventos.service.UbicacionService;
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
public class UbicacionControllerTest {

    @InjectMocks
    private UbicacionController ubicacionController;

    @Mock
    private UbicacionService ubicacionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUbicaciones() {
        Ubicacion ubicacion1 = new Ubicacion(1, "Centro Minorista", "Carrera 13", "Medellín");
        Ubicacion ubicacion2 = new Ubicacion(2, "Diskoteca", "Carrera 14", "Medellín");
        Flux<Ubicacion> ubicaciones = Flux.just(ubicacion1, ubicacion2);
        when(ubicacionService.findAll()).thenReturn(ubicaciones);
        Flux<Ubicacion> ubicacionesObtenidas = ubicacionController.consultarUbicaciones();
        ubicacionesObtenidas.subscribe();
        assertEquals(ubicaciones, ubicacionesObtenidas);
    }

    @Test
    public void testGetUbicacionById() {
        Ubicacion ubicacion1 = new Ubicacion(1, "Centro Minorista", "Carrera 13", "Medellín");
        Mono<Ubicacion> ubicaciones = Mono.just(ubicacion1);
        when(ubicacionService.findById(any())).thenReturn(ubicaciones);
        Mono<Ubicacion> ubicacionesObtenidas = ubicacionController.consultarUbicacionId(1);
        ubicacionesObtenidas.subscribe();
        assertEquals(ubicaciones,ubicacionesObtenidas);
    }
}
