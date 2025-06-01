/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.prueba_veterinaria.repository;

import com.example.prueba_veterinaria.model.Rol;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jamar
 */
public interface RolRepository extends JpaRepository<Rol, Long>{
    Rol findByRol(String rol);
}
