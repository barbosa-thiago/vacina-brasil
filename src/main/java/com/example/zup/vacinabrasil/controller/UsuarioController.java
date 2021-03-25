package com.example.zup.vacinabrasil.controller;

import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import com.example.zup.vacinabrasil.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario save(@RequestBody @Valid UsuarioPostRequestBody usuarioPostRequestBody){
        return usuarioService.save(usuarioPostRequestBody);
    }

    @GetMapping
    public Iterable<Usuario> listAll(){
        return usuarioService.findAll();
    }
}
