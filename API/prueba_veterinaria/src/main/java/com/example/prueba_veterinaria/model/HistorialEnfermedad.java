/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author jamar
 */
@Entity
@Table(name="HistorialEnfermedad")
@IdClass(HistorialEnfermedadId.class)
public class HistorialEnfermedad {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Historial")
    private Historial historial;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Enfermedad")
    private Enfermedad enfermedad;
    
    @Column(name="Fecha_diagnostico")
    private Date fechaDiagnostico;
    
    @Column(name="Estado")
    private String estado;
    
    @Column(name="Tratamiento")
    private String tratamiento;
    
    @Column(name="Observaciones")
    private String observaciones;

    public HistorialEnfermedad() {
    }

    public HistorialEnfermedad(Historial historial, Enfermedad enfermedad, Date fechaDiagnostico, String estado, String tratamiento, String observaciones) {
        this.historial = historial;
        this.enfermedad = enfermedad;
        this.fechaDiagnostico = fechaDiagnostico;
        this.estado = estado;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
