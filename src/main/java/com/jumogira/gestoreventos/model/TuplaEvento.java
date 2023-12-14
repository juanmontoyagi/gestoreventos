package com.jumogira.gestoreventos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TuplaEvento<K, V> {
    private K eventos;
    private V detalles;
}
