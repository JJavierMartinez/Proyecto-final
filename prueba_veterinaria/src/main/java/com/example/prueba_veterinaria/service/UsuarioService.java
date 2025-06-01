/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.service;

import com.example.prueba_veterinaria.model.Usuario;
import com.example.prueba_veterinaria.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jamar
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUser(username);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByCorreo(email);
    }

    public List<Usuario> findByRol(Long rolId) {
        return usuarioRepository.findByRolId(rolId);
    }

    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }
}
