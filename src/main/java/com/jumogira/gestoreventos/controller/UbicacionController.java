package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Ubicacion;
import com.jumogira.gestoreventos.service.UbicacionService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/{id}")
    public Mono<Ubicacion> consultarUbicacionId(@PathVariable("id") Integer id) {
        return ubicacionService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> eliminarUbicacionId(@PathVariable("id") Integer id) {
        return ubicacionService.deleteById(id);
    }

    @DeleteMapping(value = "/delete-ubicaciones")
    public Mono<Void> eliminarUbicaciones() {
        return ubicacionService.deleteAll();
    }

    @PutMapping(value = "/{id}")
    public Mono<Ubicacion> actualizarUbicacionId(@PathVariable("id") Integer id, @RequestBody @Validated Ubicacion ubicacion) {
        return ubicacionService.update(id, ubicacion);
    }

}
