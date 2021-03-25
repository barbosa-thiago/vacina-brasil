package com.example.zup.vacinabrasil.service;


import com.example.zup.vacinabrasil.mapper.UsuarioMapper;
import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.repository.UsuarioRepository;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import com.example.zup.vacinabrasil.utils.FindByIdOptionalHandler;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final FindByIdOptionalHandler findByIdOptionalHandler;

    public UsuarioService(UsuarioRepository usuarioRepository,
    FindByIdOptionalHandler findByIdOptionalHandler){
        this.usuarioRepository = usuarioRepository;
        this.findByIdOptionalHandler = findByIdOptionalHandler;
    }
    public Usuario save(UsuarioPostRequestBody usuarioPostRequestBody){
        return usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(usuarioPostRequestBody));
    }
    public Iterable<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findbyId(Long id){
        return findByIdOptionalHandler.findByIdOrThrowException(id, usuarioRepository);
    }
}

