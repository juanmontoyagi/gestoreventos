package com.jumogira.gestoreventos.model;

import com.jumogira.gestoreventos.service.EventoService;
import com.jumogira.gestoreventos.util.ConstantesEventos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("evento")
public class Evento implements IOperacionSeguridad{

    private final Logger LOGGER = LoggerFactory.getLogger(EventoService.class);

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private int capacidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String iniciarProcesoAsignacionSeguridad(int capacidad) {
        LOGGER.info(ConstantesEventos.INICIO_PROCESO_VALIDACION_ASIGNACION_SEGURIDAD);
        return capacidad > 0
                ? ConstantesEventos.ASIGNACION_SEGURIDAD_ASIGNADA
                : ConstantesEventos.ASIGNACION_SEGURIDAD_NO_ASIGNADA;
    }

    public static Evento convertirStringAEvento(String eventoEnString){
        Evento evento = new Evento();
        evento.setTitulo(eventoEnString.split("'titulo':")[1].split(", 'descripcion':")[0].replace("'",""));
        evento.setDescripcion(eventoEnString.split("'descripcion':")[1].split(", 'fecha':")[0].replace("'",""));
        evento.setFecha(eventoEnString.split("'fecha':")[1].split(", 'capacidad':")[0]) ;
        evento.setCapacidad(Integer.valueOf(eventoEnString.split("'capacidad':")[1].split(", 'datosAdicionales':")[0]));
        return evento;
    }
}
