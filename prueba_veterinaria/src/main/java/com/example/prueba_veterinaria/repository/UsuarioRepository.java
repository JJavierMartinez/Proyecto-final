/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.prueba_veterinaria.repository;

import com.example.prueba_veterinaria.model.Usuario;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jamar
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUser(String username);
    Optional<Usuario> findByCorreo(String email);
    List<Usuario> findByRolId(Long rolId);
}
