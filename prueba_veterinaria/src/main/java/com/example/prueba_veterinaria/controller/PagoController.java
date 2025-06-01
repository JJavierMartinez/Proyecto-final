/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.Pago;
import com.example.prueba_veterinaria.service.PagoService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jamar
 */
@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Pago pago = pagoService.findById(id);
        return pago != null ? ResponseEntity.ok(pago) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        Pago savedPago = pagoService.save(pago);
        return ResponseEntity.created(URI.create("/api/pagos/" + savedPago.getId())).body(savedPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Long id, @RequestBody Pago pago) {
        if (!id.equals(pago.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Pago updatedPago = pagoService.save(pago);
        return ResponseEntity.ok(updatedPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
