package com.example.zup.vacinabrasil.models;

import com.example.zup.vacinabrasil.enumvaccinename.VaccineName;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinaBuilder {
    private Long id;
    private @NotNull VaccineName vaccineName;
    private @NotNull Usuario usuario;
    private @NotNull LocalDate vaccinationDate;

    public VacinaBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public VacinaBuilder vaccineName(@NotNull VaccineName vaccineName) {
        this.vaccineName = vaccineName;
        return this;
    }

    public VacinaBuilder usuario(@NotNull Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public VacinaBuilder vaccinationDate(@NotNull LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
        return this;
    }

    public Vacina createVacina() {
        return new Vacina(id, vaccineName, usuario, vaccinationDate);
    }
}