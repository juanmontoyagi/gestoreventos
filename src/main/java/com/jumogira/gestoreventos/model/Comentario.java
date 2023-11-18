package com.jumogira.gestoreventos.model;

import lombok.*;

@AllArgsConstructor
@Data
public class Comentario {

    private String id;
    private Usuario autor;
    private Evento evento;
    private String texto;
    private String fecha;

}
