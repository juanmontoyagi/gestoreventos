package com.jumogira.gestoreventos.repository;

import com.jumogira.gestoreventos.model.Comentario;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ComentarioRepository extends R2dbcRepository<Comentario, String> {

    Flux<Comentario> findComentariosByEventoId(String eventoId);

    Flux<Comentario> findComentariosByUsuario(String usuarioId);

}
