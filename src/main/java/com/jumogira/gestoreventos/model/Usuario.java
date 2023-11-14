package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    private String id;
    private String nombre;
    private String correo;
    private boolean genero;
    private Evento evento;

}
