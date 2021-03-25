package com.example.zup.vacinabrasil.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cpf;
    private int age;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Column(unique = true)
    private String email;
    @JsonBackReference
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
    private List<Vacina> vacina;

    public Usuario() {
    }

    public Usuario(Long id, String cpf, int age, String name,
                   String email, List<Vacina> vacina) {
        this.cpf = cpf;
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.vacina = vacina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) &&
                cpf.equals(usuario.cpf) &&
                email.equals(usuario.email);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vacina=" + vacina +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, email, vacina);
    }

    public List<Vacina> getVacina() {
        return vacina;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVacina(List<Vacina> vacina) {
        this.vacina = vacina;
    }
}

