/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jamar
 */
@Entity
@Table(name="Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Rol")
    private Long id;
    
    @Column(name="Rol")
    private String rol;
    
    @Column(name="Descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(Long id, String rol, String descripcion, List<Usuario> usuarios) {
        this.id = id;
        this.rol = rol;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
}
