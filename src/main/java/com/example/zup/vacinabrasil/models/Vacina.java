package com.example.zup.vacinabrasil.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String vaccineName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;
    private LocalDate vaccinationDate;

    public Vacina() {
    }

    public Vacina(Long id, @NotNull String vaccineName, @NotNull Usuario usuario, @NotNull LocalDate vaccinationDate) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.usuario = usuario;
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", usuario=" + usuario +
                ", vaccinationDate=" + vaccinationDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacina)) return false;
        Vacina vacina = (Vacina) o;
        return Objects.equals(id, vacina.id) &&
                Objects.equals(usuario, vacina.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario);
    }
}
