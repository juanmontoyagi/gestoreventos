package com.jumogira.gestoreventos.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends R2dbcRepository<ComentarioRepository, String> {

}
