package com.example.zup.vacinabrasil.controller;

import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
import com.example.zup.vacinabrasil.service.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("vacinas")
public class VacinaController {
    private final VacinaService vacinaService;
    public VacinaController(VacinaService vacinaService){
        this.vacinaService = vacinaService;
    }

    @PostMapping
    public ResponseEntity<Vacina> save(@RequestBody @Valid VacinaPostRequestBody vacinaPostRequestBody){
        return new ResponseEntity<>(vacinaService.save(vacinaPostRequestBody), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<Vacina>> findAll(){
        return  new ResponseEntity<>(vacinaService.findAll(), HttpStatus.OK);
    }
}
