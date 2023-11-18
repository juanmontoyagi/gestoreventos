package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Ubicacion;
import com.jumogira.gestoreventos.service.UbicacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ubicacion")
@AllArgsConstructor
public class UbicacionController {

    UbicacionService ubicacionService;

    @PostMapping("/")
    public Mono<Ubicacion> guardar(@RequestBody @Validated Ubicacion ubicacion) {
        return ubicacionService.save(ubicacion);
    }

    @GetMapping("/ubicaciones")
    public Flux<Ubicacion> consultarUbicaciones() {
        return ubicacionService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Ubicacion> consultarUbicacionId(Integer id) {
        return ubicacionService.findById(id);
    }

}
