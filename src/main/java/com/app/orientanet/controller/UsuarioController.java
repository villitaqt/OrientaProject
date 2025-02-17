package com.app.orientanet.controller;

import com.app.orientanet.model.entity.Usuario;
import com.app.orientanet.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
/* TODO: agregar @VAlid */
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuarioCreado);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuario = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuario);
    }

    //ResponseEntity.of <---- SE USA PARA MANEJAR OPTIONAL<>
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.of(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuarioDetalles) {
        Usuario usuario = usuarioService.updateUsuario(id, usuarioDetalles);
        return ResponseEntity.ok(usuario);
    }
}
