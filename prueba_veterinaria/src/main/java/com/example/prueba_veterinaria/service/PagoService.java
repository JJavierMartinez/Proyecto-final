/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.service;

import com.example.prueba_veterinaria.model.Pago;
import com.example.prueba_veterinaria.repository.PagoRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago findById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }
}
