package com.example.zup.vacinabrasil.models;

import java.util.List;

public class UsuarioBuilder {
    private Long id;
    private String cpf;
    private int age;
    private String name;
    private String email;
    private List<Vacina> vacina;

    public UsuarioBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public UsuarioBuilder age(int age) {
        this.age = age;
        return this;
    }

    public UsuarioBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder vacina(List<Vacina> vacina) {
        this.vacina = vacina;
        return this;
    }

    public Usuario createUsuario() {
        return new Usuario(id, cpf, age, name, email, vacina);
    }
}