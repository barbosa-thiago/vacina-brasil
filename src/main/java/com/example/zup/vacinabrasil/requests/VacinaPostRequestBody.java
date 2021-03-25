package com.example.zup.vacinabrasil.requests;

import com.example.zup.vacinabrasil.models.Usuario;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinaPostRequestBody {

    @NotEmpty
    private String vaccineName;
    @ManyToOne
    @NotNull
    private Usuario usuario;
    private LocalDate vaccinationDate;

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}
