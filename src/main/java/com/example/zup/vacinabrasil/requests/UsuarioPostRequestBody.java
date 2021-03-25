package com.example.zup.vacinabrasil.requests;

import com.example.zup.vacinabrasil.models.Vacina;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class UsuarioPostRequestBody {

    @NotNull(message = "name cannot be null")
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String cpf;
    private int age;
    @NotNull(message = "email cannot be null")
    @NotEmpty
    @Email
    private String email;
    @Size(max = 2)
    private List<Vacina> vacina;

    public UsuarioPostRequestBody() {
    }

    public UsuarioPostRequestBody(String cpf, int age, String name, String email) {
        this.cpf = cpf;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioPostRequestBody{" +
                "cpf='" + cpf + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioPostRequestBody)) return false;
        UsuarioPostRequestBody that = (UsuarioPostRequestBody) o;
        return age == that.age &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, age, name, email);
    }

    public List<Vacina> getVacina() {
        return vacina;
    }

    public void setVacina(List<Vacina> vacina) {
        this.vacina = vacina;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
