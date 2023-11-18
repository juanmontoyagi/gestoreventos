package com.jumogira.gestoreventos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("ubicacion")
public class Ubicacion {

    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int capacidad;
}
