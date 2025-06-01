/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.prueba_veterinaria.controller;

import com.example.prueba_veterinaria.model.Usuario;
import com.example.prueba_veterinaria.service.UsuarioService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
    if (usuario.getId() != null && usuarioService.existsById(usuario.getId())) {
        return ResponseEntity.badRequest()
               .body("Error: Ya existe un usuario con el ID proporcionado");
    }
    
    Usuario savedUsuario = usuarioService.save(usuario);
    return ResponseEntity.created(URI.create("/api/usuarios/" + savedUsuario.getId()))
           .body(savedUsuario);
}

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!id.equals(usuario.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuarioExistente = usuarioService.findById(id);
        if (usuario.getApellidos() == null) {
            usuario.setApellidos(usuarioExistente.getApellidos());
        }
        if (usuario.getCitas() == null) {
            usuario.setCitas(usuarioExistente.getCitas());
        }
        if(usuario.getContrasena() == null) {
            usuario.setContrasena(usuarioExistente.getContrasena());
        }
        if(usuario.getCorreo() == null){
            usuario.setCorreo(usuarioExistente.getCorreo());
        }
        if(usuario.getDNI() == null){
            usuario.setDNI(usuarioExistente.getDNI());
        }
        if(usuario.getFecha_alta() == null){
            usuario.setFecha_alta(usuarioExistente.getFecha_alta());
        }
        if(usuario.getFecha_nac() == null){
            usuario.setFecha_nac(usuarioExistente.getFecha_nac());
        }
        if(usuario.getPacientes() == null){
            usuario.setPacientes(usuarioExistente.getPacientes());
        }
        if(usuario.getRol() == null){
            usuario.setRol(usuarioExistente.getRol());
        }
        if(usuario.getTelefono() == null){
            usuario.setTelefono(usuarioExistente.getTelefono());
        }
        if(usuario.getUser() == null){
            usuario.setUser(usuarioExistente.getUser());
        }
        Usuario updatedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> getUsuarioByUsername(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.findByEmail(email);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rol/{rolId}")
    public List<Usuario> getUsuariosByRol(@PathVariable Long rolId) {
        return usuarioService.findByRol(rolId);
    }
}
