package com.app.orientanet.service;

import com.app.orientanet.model.entity.Estudiante;
import com.app.orientanet.model.entity.Usuario;
import com.app.orientanet.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario saveUsuario (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getUsuarioById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }

    public Usuario updateUsuario(Integer id, Usuario usuarioDetalles) {
        return usuarioRepository.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setUsername(usuarioDetalles.getUsername());
                    existingUsuario.setContrasena(usuarioDetalles.getContrasena());
                    return usuarioRepository.save(existingUsuario);
                }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deleteUsuario(Integer id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }


}
