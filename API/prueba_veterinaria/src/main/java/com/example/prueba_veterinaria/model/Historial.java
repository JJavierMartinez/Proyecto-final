/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jamar
 */
@Entity
@Table(name="Historiales")
public class Historial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Historial")
    private Long id;
    
    @Column(name="Fecha_evento")
    private Date fecha_evento;
    
    @Column(name="Tipo_evento")
    private String tipo_evento;
    
    @Column(name="Notas")
    private String notas;
    
    @ManyToOne
    @JoinColumn(name="ID_Paciente")
    private Paciente paciente;
    
    @OneToMany(mappedBy = "historial")
    @JsonIgnore
    private List<HistorialEnfermedad> enfermedades;

    public Historial() {
    }

    public Historial(Long id, Date fecha_evento, String tipo_evento, String notas, Paciente paciente, List<HistorialEnfermedad> enfermedades) {
        this.id = id;
        this.fecha_evento = fecha_evento;
        this.tipo_evento = tipo_evento;
        this.notas = notas;
        this.paciente = paciente;
        this.enfermedades = enfermedades;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(Date fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<HistorialEnfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<HistorialEnfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    
    
    
}
