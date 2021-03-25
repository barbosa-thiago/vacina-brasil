package com.example.zup.vacinabrasil.controller;

import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
import com.example.zup.vacinabrasil.service.VacinaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("vacinas")
public class VacinaController {
    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService){
        this.vacinaService = vacinaService;
    }

    @PostMapping
    public Vacina save(@RequestBody @Valid VacinaPostRequestBody vacinaPostRequestBody){
        return vacinaService.save(vacinaPostRequestBody);
    }
}
