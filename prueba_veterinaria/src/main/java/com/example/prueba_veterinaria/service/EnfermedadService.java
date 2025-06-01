/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.service;

import com.example.prueba_veterinaria.model.Enfermedad;
import com.example.prueba_veterinaria.repository.EnfermedadRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class EnfermedadService {
    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public List<Enfermedad> findAll() {
        return enfermedadRepository.findAll();
    }

    public Enfermedad findById(Long id) {
        return enfermedadRepository.findById(id).orElse(null);
    }

    public Enfermedad save(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }

    public void deleteById(Long id) {
        enfermedadRepository.deleteById(id);
    }
}
