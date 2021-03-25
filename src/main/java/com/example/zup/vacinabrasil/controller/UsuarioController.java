package com.example.zup.vacinabrasil.controller;

import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import com.example.zup.vacinabrasil.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioPostRequestBody usuarioPostRequestBody){
        return new ResponseEntity<>(usuarioService.save(usuarioPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> findAll(){
        return new ResponseEntity<>(usuarioService.findAll(),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.findbyId(id), HttpStatus.OK);
    }
}
