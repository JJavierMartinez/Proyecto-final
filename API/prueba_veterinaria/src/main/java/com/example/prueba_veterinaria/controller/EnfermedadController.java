/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.Enfermedad;
import com.example.prueba_veterinaria.service.EnfermedadService;
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
@RequestMapping("/api/enfermedades")
public class EnfermedadController {
    @Autowired
    private EnfermedadService enfermedadService;

    @GetMapping
    public List<Enfermedad> getAllEnfermedades() {
        return enfermedadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enfermedad> getEnfermedadById(@PathVariable Long id) {
        Enfermedad enfermedad = enfermedadService.findById(id);
        return enfermedad != null ? ResponseEntity.ok(enfermedad) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Enfermedad> createEnfermedad(@RequestBody Enfermedad enfermedad) {
        Enfermedad savedEnfermedad = enfermedadService.save(enfermedad);
        return ResponseEntity.created(URI.create("/api/enfermedades/" + savedEnfermedad.getId())).body(savedEnfermedad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enfermedad> updateEnfermedad(@PathVariable Long id, @RequestBody Enfermedad enfermedad) {
        if (!id.equals(enfermedad.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Enfermedad updatedEnfermedad = enfermedadService.save(enfermedad);
        return ResponseEntity.ok(updatedEnfermedad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnfermedad(@PathVariable Long id) {
        enfermedadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
