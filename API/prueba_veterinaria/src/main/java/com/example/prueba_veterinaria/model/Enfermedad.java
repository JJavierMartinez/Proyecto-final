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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jamar
 */
@Entity
@Table(name="Enfermedades")
public class Enfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Enfermedad")
    private Long id;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "enfermedad")
    @JsonIgnore
    private List<HistorialEnfermedad> historiales;

    public Enfermedad() {
    }

    public Enfermedad(Long id, String nombre, String descripcion, List<HistorialEnfermedad> historiales) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.historiales = historiales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<HistorialEnfermedad> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<HistorialEnfermedad> historiales) {
        this.historiales = historiales;
    }

    
    
    
    
}
