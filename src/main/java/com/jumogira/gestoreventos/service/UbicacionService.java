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

    private UbicacionRepository ubicacionRepository;

    public Mono<Ubicacion> save(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public Mono<Ubicacion> findById(Integer id) {
        return ubicacionRepository.findById(id)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesUbicacion.ERROR_AL_BUSCAR_UBICACION + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUbicacion.UBICACION_NO_ENCONTRADA + id)
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

    public Mono<Void> deleteById(Integer id) {
        return ubicacionRepository.findById(id)
                .flatMap(ubicacion -> ubicacionRepository.deleteById(ubicacion.getId()).thenReturn(ubicacion))
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesUbicacion.ERROR_AL_BUSCAR_UBICACION + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUbicacion.UBICACION_NO_ENCONTRADA + id)
                                .getMostSpecificCause())).then();
    }

    public Mono<Void> deleteAll() {
        return ubicacionRepository.findAll()
                .flatMap(ubicaciones -> ubicacionRepository.deleteAll().thenReturn(ubicaciones))
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesUbicacion.ERROR_AL_CONSULTAR_TODAS_LAS_UBICACIONES, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUbicacion.NINGUN_UBICACION_ENCONTRADO)
                                .getMostSpecificCause())).then();
    }

    public Mono<Ubicacion> update(Integer id, Ubicacion ubicacion) {
        return ubicacionRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesUbicacion.ERROR_AL_BUSCAR_UBICACION + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUbicacion.UBICACION_NO_ENCONTRADA + id)
                                .getMostSpecificCause()))
                .flatMap(ubicacionEncontrada -> {
                    ubicacionEncontrada.setNombre(ubicacion.getNombre());
                    ubicacionEncontrada.setDireccion(ubicacion.getDireccion());
                    ubicacionEncontrada.setCiudad(ubicacion.getCiudad());
                    ubicacionEncontrada.setCapacidad(ubicacion.getCapacidad());
                    return ubicacionRepository.save(ubicacionEncontrada);
                });
    }



}
