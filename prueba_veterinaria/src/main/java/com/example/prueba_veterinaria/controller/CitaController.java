/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.Cita;
import com.example.prueba_veterinaria.service.CitaService;
import java.net.URI;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jamar
 */
@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Long id) {
        Cita cita = citaService.findById(id);
        return cita != null ? ResponseEntity.ok(cita) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita savedCita = citaService.save(cita);
        return ResponseEntity.created(URI.create("/api/citas/" + savedCita.getId())).body(savedCita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Long id, @RequestBody Cita cita) {
        if (!id.equals(cita.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Cita updatedCita = citaService.save(cita);
        return ResponseEntity.ok(updatedCita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Cita> getCitasByPaciente(@PathVariable Long pacienteId) {
        return citaService.findByPacienteId(pacienteId);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public List<Cita> getCitasByVeterinario(@PathVariable Long veterinarioId) {
        return citaService.findByVeterinarioId(veterinarioId);
    }

    @GetMapping("/fecha")
    public List<Cita> getCitasByFecha(@RequestParam Date fecha) {
        return citaService.findByFecha(fecha);
    }
}
