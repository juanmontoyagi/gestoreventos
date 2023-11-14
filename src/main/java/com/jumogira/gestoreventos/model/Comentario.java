package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comentario {

    private String id;
    private Usuario autor;
    private Evento evento;
    private String texto;
    private String fecha;

}
