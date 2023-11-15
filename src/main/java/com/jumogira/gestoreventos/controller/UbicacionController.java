package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Ubicacion;
import com.jumogira.gestoreventos.service.UbicacionService;
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
@RequestMapping("/ubicacion")
@AllArgsConstructor
public class UbicacionController {

    UbicacionService ubicacionService;

    @PostMapping("/")
    public Mono<Ubicacion> guardar(@RequestBody @Validated Ubicacion ubicacion) {
        return ubicacionService.save(ubicacion);
    }

    @GetMapping("/")
    public Flux<Ubicacion> consultarUbicaciones() {
        return ubicacionService.findAll();
    }

    @GetMapping("/")
    public Mono<Ubicacion> consultarUbicacionId(String id) {
        return ubicacionService.findById(id);
    }

}
