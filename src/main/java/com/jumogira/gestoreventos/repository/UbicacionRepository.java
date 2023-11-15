package com.jumogira.gestoreventos.repository;

import com.jumogira.gestoreventos.model.Ubicacion;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepository extends R2dbcRepository<Ubicacion, String> {

}
