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
@Table(name="Pagos")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Pago")
    private Long id;
    
    @Column(name="Monto")
    private Float monto;
    
    @Column(name="Fecha")
    private Date fecha;
    
    @Column(name="Metodo_Pago")
    private String metodoPago;
    
   @OneToMany(mappedBy = "pago")
   @JsonIgnore
   private List<Cita> citas;

    public Pago() {
    }

    public Pago(Long id, Float monto, Date fecha, String metodoPago, List<Cita> citas) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.citas = citas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    
   
    
}
