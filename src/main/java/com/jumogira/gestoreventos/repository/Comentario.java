package com.jumogira.gestoreventos.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Comentario extends R2dbcRepository<Comentario, String> {

}
