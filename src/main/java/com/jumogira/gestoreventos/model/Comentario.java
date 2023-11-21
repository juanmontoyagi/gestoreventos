package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Table("comentario")
public class Comentario {

    @Id
    private Integer id;
    private Integer autor;
    private Integer evento;
    private String texto;
    private String fecha;

}
