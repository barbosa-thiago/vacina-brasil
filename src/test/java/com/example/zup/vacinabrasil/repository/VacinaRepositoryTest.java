package com.example.zup.vacinabrasil.repository;

import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.util.EntityCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;

@DataJpaTest
@DisplayName("Testes para o repositorio Vacina")
class VacinaRepositoryTest {
    @Autowired
    private VacinaRepository vacinaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Save Persist Vacina When Succesful")
    void save_PersistVacina_WhenSuccesful(){
        Vacina vacinaToBeSaved = EntityCreator.createVacinaToBeSaved();
        usuarioRepository.save(EntityCreator.createUsuarioToBeSaved());
        Vacina vacinaSaved = vacinaRepository.save(vacinaToBeSaved);
        Assertions.assertThat(vacinaSaved).isNotNull();
        Assertions.assertThat(vacinaSaved.getId()).isNotNull();
        Assertions.assertThat(vacinaSaved.getVaccineName()).isEqualTo(vacinaToBeSaved.getVaccineName());
        Assertions.assertThat(vacinaSaved.getUsuario()).isEqualTo(vacinaToBeSaved.getUsuario());
    }

    @Test
    @DisplayName("Save Throws ConstraintViolationException When cpf is empty")
    void save_ThrowsConstraintViolationException_WhenUsuarioIsEmpty(){
        Vacina vacina = new Vacina();
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()-> vacinaRepository.save(vacina));
    }
}