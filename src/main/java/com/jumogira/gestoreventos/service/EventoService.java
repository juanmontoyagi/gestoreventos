package com.jumogira.gestoreventos.service;

import com.jumogira.gestoreventos.model.Evento;
import com.jumogira.gestoreventos.repository.EventoRepository;
import com.jumogira.gestoreventos.util.ConstantesEventos;
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
public class EventoService {

    private final Logger LOGGER = LoggerFactory.getLogger(EventoService.class);

    private EventoRepository eventoRepository;

    public Mono<Evento> save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Mono<Evento> findById(Integer id) {
        return eventoRepository.findById(id)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesEventos.ERROR_AL_BUSCAR_EVENTO + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesEventos.EVENTO_NO_ENCONTRADO + id)
                                .getMostSpecificCause()));
    }

    public Flux<Evento> findAll() {
        return eventoRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesEventos.ERROR_AL_CONSULTAR_TODOS_LOS_EVENTOS);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesEventos.NINGUN_EVENTO_ENCONTRADO)
                                .getMostSpecificCause()));
    }
}
