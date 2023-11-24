package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("ubicacion")
public class Ubicacion {

    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    private String ciudad;

}
