/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author jamar
 */
public class HistorialEnfermedadId implements Serializable {

    private Long historial;
    private Long enfermedad;

    public HistorialEnfermedadId() {
    }

    public HistorialEnfermedadId(Long historial, Long enfermedad) {
        this.historial = historial;
        this.enfermedad = enfermedad;
    }

    public Long getHistorial() {
        return historial;
    }

    public void setHistorial(Long historial) {
        this.historial = historial;
    }

    public Long getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Long enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HistorialEnfermedadId that = (HistorialEnfermedadId) o;
        return historial.equals(that.historial)
                && enfermedad.equals(that.enfermedad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historial, enfermedad);
    }
}
