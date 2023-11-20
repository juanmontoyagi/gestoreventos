package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Comentario {

    private Integer id;
    private Usuario autor;
    private Evento evento;
    private String texto;
    private String fecha;

}
