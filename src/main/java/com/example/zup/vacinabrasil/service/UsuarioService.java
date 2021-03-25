package com.example.zup.vacinabrasil.service;


import com.example.zup.vacinabrasil.mapper.UsuarioMapper;
import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.repository.UsuarioRepository;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(UsuarioPostRequestBody usuarioPostRequestBody){
        return usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioPostRequestBody));
    }

    public Iterable<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

}

