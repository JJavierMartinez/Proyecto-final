/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.service;

import com.example.prueba_veterinaria.model.HistorialEnfermedad;
import com.example.prueba_veterinaria.model.HistorialEnfermedadId;
import com.example.prueba_veterinaria.repository.HistorialEnfermedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class HistorialEnfermedadService {
    @Autowired
    private HistorialEnfermedadRepository historialEnfermedadRepository;

    public HistorialEnfermedad save(HistorialEnfermedad historialEnfermedad) {
        return historialEnfermedadRepository.save(historialEnfermedad);
    }

    public void delete(HistorialEnfermedadId id) {
        historialEnfermedadRepository.deleteById(id);
    }

    public HistorialEnfermedad findById(HistorialEnfermedadId id) {
        return historialEnfermedadRepository.findById(id).orElse(null);
    }
}
