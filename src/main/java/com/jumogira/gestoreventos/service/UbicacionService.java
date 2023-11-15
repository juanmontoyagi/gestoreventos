package com.jumogira.gestoreventos.service;

import com.jumogira.gestoreventos.model.Ubicacion;
import com.jumogira.gestoreventos.repository.UbicacionRepository;
import com.jumogira.gestoreventos.util.ConstantesUbicacion;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UbicacionService {

    private final Logger LOGGER = LoggerFactory.getLogger(UbicacionService.class);

    private final UbicacionRepository ubicacionRepository;

    public Mono<Ubicacion> save(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public Mono<Ubicacion> findById(String id) {
        return ubicacionRepository.findById(id)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesUbicacion.ERROR_AL_BUSCAR_UBICACION + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUbicacion.NINGUN_UBICACION_ENCONTRADO + id)
                                .getMostSpecificCause()));
    }

    public Flux<Ubicacion> findAll() {
        return ubicacionRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesUbicacion.ERROR_AL_CONSULTAR_TODAS_LAS_UBICACIONES);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUbicacion.NINGUN_UBICACION_ENCONTRADO)
                                .getMostSpecificCause()));
    }

}
