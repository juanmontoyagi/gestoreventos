package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Evento {

    private String id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private boolean estado;
    private Ubicacion ubicacion;
    private List<Usuario> asistentes;

}
