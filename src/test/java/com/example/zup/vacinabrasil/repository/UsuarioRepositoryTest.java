package com.example.zup.vacinabrasil.repository;


import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.util.EntityCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;

@DataJpaTest
@DisplayName("Testes para Repositorio Usuario")
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Save Persist Usuario When Succesful")
    void save_PersistUsuario_WhenSuccesful(){
        Usuario usuarioParaSalvar = EntityCreator.createUsuarioToBeSaved();

        Usuario usuarioSalvo = usuarioRepository.save(usuarioParaSalvar);
        Assertions.assertThat(usuarioSalvo).isNotNull();
        Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
        Assertions.assertThat(usuarioSalvo.getName()).isEqualTo(usuarioParaSalvar.getName());
        Assertions.assertThat(usuarioSalvo.getCpf()).isEqualTo(usuarioParaSalvar.getCpf());
    }

    @Test
    @DisplayName("Save Throws ConstraintViolationException When cpf is empty")
    void save_ThrowsConstraintViolationException_WhenCpfIsEmpty(){
        Usuario usuario = new Usuario();
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()-> usuarioRepository.save(usuario));
    }
}