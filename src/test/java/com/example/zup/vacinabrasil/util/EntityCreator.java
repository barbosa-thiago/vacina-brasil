package com.example.zup.vacinabrasil.util;

import com.example.zup.vacinabrasil.VaccineName;
import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.models.UsuarioBuilder;
import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.models.VacinaBuilder;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class EntityCreator {
    public static UsuarioPostRequestBody createUsuarioPostRequestBody() {
        return new UsuarioPostRequestBody("12312312312",
                65,
                "Joao",
                "joao@joao.com");
    }

    public static Usuario createValidUsuario() {
        return new UsuarioBuilder()
                .id(1L)
                .cpf("12312312312")
                .name("Joao")
                .email("joao@joao.com")
                .age(65)
                .createUsuario();
    }

    public static Usuario createUsuarioToBeSaved() {
        return new UsuarioBuilder()
                .name("Joao")
                .cpf("12312312312")
                .age(65)
                .email("joao@joao.com")
                .createUsuario();
    }

    public static Vacina createVacinaToBeSaved() {
        return new VacinaBuilder()
                .vaccineName(VaccineName.CORONAVAC)
                .vaccinationDate(LocalDate.now())
                .usuario(createValidUsuario())
                .createVacina();
    }

    public static Vacina createValidVacina() {
        return new VacinaBuilder()
                .id(1L)
                .vaccineName(VaccineName.CORONAVAC)
                .vaccinationDate(LocalDate.now())
                .usuario(createValidUsuario())
                .createVacina();
    }

    public static VacinaPostRequestBody createVacinaPostRequestBody(){
        return new VacinaPostRequestBody(VaccineName.CORONAVAC,
                createValidUsuario(),
                LocalDate.now());
    }

}
