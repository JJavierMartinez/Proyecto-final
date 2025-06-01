/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.Historial;
import com.example.prueba_veterinaria.service.HistorialService;
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
@RequestMapping("/api/historiales")
public class HistorialController {
    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<Historial> getAllHistoriales() {
        return historialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historial> getHistorialById(@PathVariable Long id) {
        Historial historial = historialService.findById(id);
        return historial != null ? ResponseEntity.ok(historial) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Historial> createHistorial(@RequestBody Historial historial) {
        Historial savedHistorial = historialService.save(historial);
        return ResponseEntity.created(URI.create("/api/historiales/" + savedHistorial.getId())).body(savedHistorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historial> updateHistorial(@PathVariable Long id, @RequestBody Historial historial) {
        if (!id.equals(historial.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Historial updatedHistorial = historialService.save(historial);
        return ResponseEntity.ok(updatedHistorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorial(@PathVariable Long id) {
        historialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Historial> getHistorialesByPaciente(@PathVariable Long pacienteId) {
        return historialService.findByPacienteId(pacienteId);
    }
}
