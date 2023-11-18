package com.jumogira.gestoreventos.service;

import com.jumogira.gestoreventos.model.Usuario;
import com.jumogira.gestoreventos.repository.UsuarioRepository;
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
public class UsuarioService {

    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    private UsuarioRepository usuarioRepository;

    public Mono<Usuario> save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Mono<Usuario> findById(String id) {
        return usuarioRepository.findById(id)
                .onErrorResume(error -> {
                    LOGGER.error(ConstantesUsuario.ERROR_AL_BUSCAR_USUARIO + id);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUsuario.USUARIO_NO_ENCONTRADO + id)
                                .getMostSpecificCause()));
    }

    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error(ConstantesUsuario.ERROR_AL_BUSCAR_TODOS_LOS_USUARIOS);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantesUsuario.NINGUN_USUARIO_ENCONTRADO)
                                .getMostSpecificCause()));
    }
}
