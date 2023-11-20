package com.jumogira.gestoreventos.service;

import com.jumogira.gestoreventos.model.Comentario;
import com.jumogira.gestoreventos.model.Ubicacion;
import com.jumogira.gestoreventos.repository.ComentarioRepository;
import com.jumogira.gestoreventos.util.ConstantesComentario;
import com.jumogira.gestoreventos.util.ConstantesEventos;
import com.jumogira.gestoreventos.util.ConstantesUbicacion;
import com.jumogira.gestoreventos.util.ConstantesUsuario;
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
public class ComentarioService {

    private final Logger LOGGER = LoggerFactory.getLogger(ComentarioService.class);

    private ComentarioRepository comentarioRepository;

    public Mono<Comentario> save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Mono<Comentario> findById(Integer id) {
        return comentarioRepository.findById(id)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesComentario.ERROR_AL_ENCONTRAR_COMENTARIO + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesComentario.ERROR_AL_ENCONTRAR_COMENTARIO + id)
                                .getMostSpecificCause()));
    }

    public Flux<Comentario> findAll() {
        return comentarioRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesComentario.NINGUN_COMENTARIO_ENCONTRADO);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesComentario.NINGUN_COMENTARIO_ENCONTRADO)
                                .getMostSpecificCause()));
    }

}
