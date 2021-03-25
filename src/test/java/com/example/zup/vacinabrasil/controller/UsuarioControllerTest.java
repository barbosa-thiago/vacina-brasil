package com.example.zup.vacinabrasil.controller;


import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import com.example.zup.vacinabrasil.service.UsuarioService;
import com.example.zup.vacinabrasil.util.EntityCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class UsuarioControllerTest {
    @InjectMocks
    private UsuarioController usuarioController;
    @Mock
    private UsuarioService usuarioService;

    @BeforeEach

    public void setup(){
        Iterable<Usuario> usuarioIterable = List.of(EntityCreator.createValidUsuario());
        BDDMockito.when(usuarioService.save(EntityCreator.createUsuarioPostRequestBody()))
                .thenReturn(EntityCreator.createValidUsuario());
        BDDMockito.when(usuarioService.findbyId(ArgumentMatchers.anyLong()))
                .thenReturn(EntityCreator.createValidUsuario());
        BDDMockito.when(usuarioService.findAll()).thenReturn(usuarioIterable);
    }

    @Test
    @DisplayName("Save Persists Usuario When Succesdful")
    void save_PersistAnime_WhenSuccesful(){
        Long expectedId = EntityCreator.createValidUsuario().getId();
        UsuarioPostRequestBody usuarioPostRequestBody = EntityCreator.createUsuarioPostRequestBody();
        Usuario usuarioSalvo = usuarioController.save(usuarioPostRequestBody).getBody();
        Assertions.assertThat(usuarioSalvo).isNotNull();
        Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
        Assertions.assertThat(usuarioSalvo.getName()).isEqualTo(usuarioPostRequestBody.getName());
        Assertions.assertThat(usuarioSalvo.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("FindById returns Usuario When Succesful")
    void findById_ReturnsUsuario_WhenSuccesful(){
        Long expectedId = EntityCreator.createValidUsuario().getId();
        Usuario usuario = usuarioController.findById(1L).getBody();

        Assertions.assertThat(usuario).isNotNull();
        Assertions.assertThat(usuario.getId()).isNotNull();
        Assertions.assertThat(usuario.getId()).isEqualTo(expectedId);

    }

    @Test
    @DisplayName("FindAll Returns Pageable Anime List When Succesful")
    void findAll_ReturnsPageableAnimeList_WhenSuccesful(){
        Usuario expected = EntityCreator.createValidUsuario();
        Iterable<Usuario> usuarioPage = usuarioController.findAll().getBody();

        Assertions.assertThat(usuarioPage).isNotNull().contains(expected);
    }

}