/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.Paciente;
import com.example.prueba_veterinaria.service.PacienteService;
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
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteService.findById(id);
        return paciente != null ? ResponseEntity.ok(paciente) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente savedPaciente = pacienteService.save(paciente);
        return ResponseEntity.created(URI.create("/api/pacientes/" + savedPaciente.getId())).body(savedPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        if (!id.equals(paciente.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Paciente updatedPaciente = pacienteService.save(paciente);
        return ResponseEntity.ok(updatedPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dueno/{duenoId}")
    public List<Paciente> getPacientesByDueno(@PathVariable Long duenoId) {
        return pacienteService.findByDuenoId(duenoId);
    }

    @GetMapping("/especie/{especie}")
    public List<Paciente> getPacientesByEspecie(@PathVariable String especie) {
        return pacienteService.findByEspecie(especie);
    }
}
