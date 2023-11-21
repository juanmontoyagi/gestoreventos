package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("evento")
public class Evento {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private int capacidad;

}
