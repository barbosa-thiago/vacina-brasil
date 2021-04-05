package com.example.zup.vacinabrasil.requests;

import com.example.zup.vacinabrasil.VaccineName;
import com.example.zup.vacinabrasil.models.Usuario;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinaPostRequestBody {

    @NotNull
    private VaccineName vaccineName;
    @ManyToOne
    @NotNull
    private Usuario usuario;
    private LocalDate vaccinationDate;

    public VacinaPostRequestBody(@NotNull VaccineName vaccineName, @NotNull Usuario usuario, LocalDate vaccinationDate) {
        this.vaccineName = vaccineName;
        this.usuario = usuario;
        this.vaccinationDate = vaccinationDate;
    }

    public VaccineName getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(VaccineName vaccineName) {
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
