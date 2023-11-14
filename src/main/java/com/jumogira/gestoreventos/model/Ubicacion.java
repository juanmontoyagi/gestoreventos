package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Ubicacion {

    private String id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int capacidad;
}
