package com.jumogira.gestoreventos.repository;

import com.jumogira.gestoreventos.model.Evento;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EventoRepository extends R2dbcRepository<Evento, String> {

    Flux<Evento> findByEstado(boolean estado);

    Flux<Evento> findByFecha(String fecha);

}
