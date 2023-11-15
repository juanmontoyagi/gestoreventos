package com.jumogira.gestoreventos.service;

import com.jumogira.gestoreventos.model.Comentario;
import com.jumogira.gestoreventos.repository.ComentarioRepository;
import com.jumogira.gestoreventos.util.ConstantesEventos;
import com.jumogira.gestoreventos.util.ConstantesUsuario;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ComentarioService {

    private final Logger LOGGER = LoggerFactory.getLogger(ComentarioService.class);

    private final ComentarioRepository comentarioRepository;

    public Mono<Comentario> save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Flux<Comentario> buscarComentariosPorEvento(String eventoId) {
        return comentarioRepository.findComentariosByEventoId(eventoId)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesEventos.ERROR_AL_BUSCAR_EVENTO + eventoId);
                    return Mono.empty();
                });
    }

    public Flux<Comentario> buscarComentariosPorUsuario(String usuarioId) {
        return comentarioRepository.findComentariosByUsuario(usuarioId)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesUsuario.USUARIO_NO_ENCONTRADO + usuarioId);
                    return Mono.empty();
                });
    }
}
