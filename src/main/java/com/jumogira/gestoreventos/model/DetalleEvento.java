package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table("detalle_eventos")
public class DetalleEvento {

    @Id
    private Integer id;
    private Integer serial_eventos;
    private String datosAdicionales;

    public static DetalleEvento convertirStringADetalleEvento(String eventoEnString){
        DetalleEvento detalleEvento = new DetalleEvento();
        detalleEvento.setSerial_eventos(Integer.valueOf(eventoEnString.split("'serial':")[1].split(", 'nombre':")[0]));
        detalleEvento.setDatosAdicionales(obtenerDatosAdicionalesEventos(eventoEnString.split("'datosAdicionales':")[1],eventoEnString.split(", 'serial':")[0]));
        return detalleEvento;
    }

    protected static String obtenerDatosAdicionalesEventos(String datosAdicionales, String key){
        key = key.replaceFirst("\\{", "");
        datosAdicionales = datosAdicionales.replaceFirst("'","");
        return datosAdicionales.split("}'}")[0] + ", " + key + "}";
    }

}
