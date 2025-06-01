/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.service;

import com.example.prueba_veterinaria.model.Historial;
import com.example.prueba_veterinaria.repository.HistorialRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    public List<Historial> findAll() {
        return historialRepository.findAll();
    }

    public Historial findById(Long id) {
        return historialRepository.findById(id).orElse(null);
    }

    public Historial save(Historial historial) {
        return historialRepository.save(historial);
    }

    public void deleteById(Long id) {
        historialRepository.deleteById(id);
    }

    public List<Historial> findByPacienteId(Long pacienteId) {
        return historialRepository.findByPacienteId(pacienteId);
    }
}
