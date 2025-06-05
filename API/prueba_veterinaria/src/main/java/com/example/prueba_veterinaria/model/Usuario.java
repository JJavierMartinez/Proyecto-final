/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author jamar
 */
@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Usuario")
    private Long id;
    
    @Column(name="apellidos")
    private String apellidos;
    
    @Column(name="DNI")
    private String DNI;
    
    @Column(name="User")
    private String user;
    
    @Column(name="fecha_nac")
    private Date fecha_nac;
    
    @Column(name="fecha_alta")
    private Date fecha_alta;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="correo")
    private String correo;
    
    @Column(name="contrasena")
    private String contrasena;
    
    @ManyToOne
    @JoinColumn(name="ID_Rol")
    private Rol rol;
    
    @OneToMany(mappedBy = "dueno")
    @JsonIgnore
    private List<Paciente> pacientes;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Cita> citas;

    public Usuario() {
    }

    public Usuario(Long id, String apellidos, String DNI, String user, Date fecha_nac, Date fecha_alta, String telefono, String correo, String contrasena, Rol rol, List<Paciente> pacientes, List<Cita> citas) {
        this.id = id;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.user = user;
        this.fecha_nac = fecha_nac;
        this.fecha_alta = fecha_alta;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.pacientes = pacientes;
        this.citas = citas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    
    
    
    
}
