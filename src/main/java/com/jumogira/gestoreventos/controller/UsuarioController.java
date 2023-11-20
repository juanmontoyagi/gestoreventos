package com.jumogira.gestoreventos.controller;

import com.jumogira.gestoreventos.model.Usuario;
import com.jumogira.gestoreventos.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    UsuarioService usuarioService;

    @PostMapping("/")
    public Mono<Usuario> guardar(@RequestBody @Validated Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/usuarios")
    public Flux<Usuario> consultarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Usuario> consultarUsuarioId(@PathVariable("id") Integer id) {
        return usuarioService.findById(id);
    }

}
