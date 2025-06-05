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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jamar
 */
@Entity
@Table(name="Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Paciente")
    private Long id;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Apellidos")
    private String apellidos;
    
    @Column(name="DNI_Mascota")
    private String dniMascota;
    
    @Column(name="Fecha_nac")
    private Date fecha_nac;
    
    @Column(name="Seguro")
    private boolean seguro;
    
    @Column(name="Especie")
    private String especie;
    
    @Column(name="Raza")
    private String raza;
    
    @Column(name="Fecha_registro")
    private Date fecha_registro;
    
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    List<Historial> historial; 
    
    @ManyToOne
    @JoinColumn(name="ID_Dueno")
    private Usuario dueno;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellidos, String dniMascota, Date fecha_nac, boolean seguro, String especie, String raza, Date fecha_registro, List<Historial> historial, Usuario dueno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dniMascota = dniMascota;
        this.fecha_nac = fecha_nac;
        this.seguro = seguro;
        this.especie = especie;
        this.raza = raza;
        this.fecha_registro = fecha_registro;
        this.historial = historial;
        this.dueno = dueno;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDniMascota() {
        return dniMascota;
    }

    public void setDniMascota(String dniMascota) {
        this.dniMascota = dniMascota;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }

    public Usuario getDueno() {
        return dueno;
    }

    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }

    
    
    
    
}
