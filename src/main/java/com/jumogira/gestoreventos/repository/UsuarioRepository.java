package com.jumogira.gestoreventos.repository;

import com.jumogira.gestoreventos.model.Usuario;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UsuarioRepository extends R2dbcRepository<Usuario, String> {

    Flux<Usuario> findByNombre(String nombre);

}
