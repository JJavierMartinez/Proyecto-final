/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.HistorialEnfermedad;
import com.example.prueba_veterinaria.model.HistorialEnfermedadId;
import com.example.prueba_veterinaria.service.HistorialEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jamar
 */
@RestController
@RequestMapping("/api/historial-enfermedades")
public class HistorialEnfermedadController {
    @Autowired
    private HistorialEnfermedadService historialEnfermedadService;

    @PostMapping
    public ResponseEntity<HistorialEnfermedad> createHistorialEnfermedad(@RequestBody HistorialEnfermedad historialEnfermedad) {
        HistorialEnfermedad saved = historialEnfermedadService.save(historialEnfermedad);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteHistorialEnfermedad(@RequestBody HistorialEnfermedadId id) {
        historialEnfermedadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<HistorialEnfermedad> getHistorialEnfermedad(@RequestBody HistorialEnfermedadId id) {
        HistorialEnfermedad historialEnfermedad = historialEnfermedadService.findById(id);
        return historialEnfermedad != null ? ResponseEntity.ok(historialEnfermedad) : ResponseEntity.notFound().build();
    }
}
