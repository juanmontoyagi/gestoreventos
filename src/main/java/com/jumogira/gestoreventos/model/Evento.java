package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evento {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private boolean estado;
    private Ubicacion ubicacion;
    private List<Usuario> asistentes;

}
