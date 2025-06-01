/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;


/**
 *
 * @author jamar
 */
@Entity
@Table(name="Citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Cita")
    private Long id;
    
    @Column(name="Motivo")
    private String motivo;
    
    @Column(name="Fecha")
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name="ID_Veterinario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="ID_Pago")
    private Pago pago;
    
    @ManyToOne
    @JoinColumn(name="ID_Paciente")
    private Paciente paciente;

    public Cita() {
    }

    public Cita(Long id, String motivo, Date fecha, Usuario usuario, Pago pago, Paciente paciente) {
        this.id = id;
        this.motivo = motivo;
        this.fecha = fecha;
        this.usuario = usuario;
        this.pago = pago;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    
    
}
