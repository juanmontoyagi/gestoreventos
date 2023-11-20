package com.jumogira.gestoreventos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Data
@Getter
@Setter
@Table("usuario")
public class Usuario {

    @Id
    private Integer id;
    private String nombre;
    private String correo;
    private int edad;
    private boolean genero;

}
