package com.example.zup.vacinabrasil.utils;

import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FindByIdOptionalHandler {
    public Usuario findByIdOrThrowException(long id, UsuarioRepository usuarioRepository) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario not found"));
    }
}