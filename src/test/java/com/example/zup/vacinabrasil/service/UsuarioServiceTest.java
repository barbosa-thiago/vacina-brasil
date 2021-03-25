package com.example.zup.vacinabrasil.service;

import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.repository.UsuarioRepository;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import com.example.zup.vacinabrasil.util.EntityCreator;
import com.example.zup.vacinabrasil.utils.FindByIdOptionalHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;
    @Mock
    private UsuarioRepository usuarioRepositoryMock;
    @Mock
    FindByIdOptionalHandler findByIdOptionalHandlerMock;
    @Mock
    UsuarioPostRequestBody usuarioPostRequestBody;
    Usuario expectedUsuario = EntityCreator.createValidUsuario();

    @BeforeEach
    void setup() {
        Iterable<Usuario> usuarioPage = List.of(EntityCreator.createValidUsuario());
        BDDMockito.when(usuarioRepositoryMock.findAll()).thenReturn(usuarioPage);
        BDDMockito.when(findByIdOptionalHandlerMock
                .findByIdOrThrowException(ArgumentMatchers.anyLong(), ArgumentMatchers.any(UsuarioRepository.class)))
                .thenReturn(EntityCreator.createValidUsuario());
        BDDMockito.when(usuarioRepositoryMock.save(ArgumentMatchers.any(Usuario.class)))
                .thenReturn(EntityCreator.createValidUsuario());
    }

    @Test
    @DisplayName("Save Persists Usuario When Succesful")
    void save_PersistsUsuario_WhenSuccesful() {
        Usuario savedUsuario = usuarioService.save(EntityCreator.createUsuarioPostRequestBody());

        Assertions.assertThat(savedUsuario).isNotNull();
        Assertions.assertThat(savedUsuario.getId()).isNotNull()
                .isEqualTo(expectedUsuario.getId());
        Assertions.assertThat(savedUsuario.getCpf()).isEqualTo(expectedUsuario.getCpf());
        Assertions.assertThat(savedUsuario.getName()).isEqualTo(expectedUsuario.getName());
    }

    @Test
    @DisplayName("findAll ReturnsPageableUsuarioList WhenSuccesful")
    void findAll_ReturnsIterableUsuarioList_WhenSuccesful() {
        Iterable<Usuario> usuarioIterable = usuarioService.findAll();

        Assertions.assertThat(usuarioIterable).isNotNull()
                .contains(expectedUsuario)
                .doesNotContainNull();

    }

    @Test
    @DisplayName("FindById Returns Usuario When Succesful ")
    void FindById_ReturnsUsuario_WhenSuccesful() {
        Usuario usuario = usuarioService.findbyId(1L);


        Assertions.assertThat(usuario).isNotNull();
        Assertions.assertThat(usuario.getId()).isNotNull()
                .isEqualTo(expectedUsuario.getId());
        Assertions.assertThat(usuario.getName()).isNotNull()
                .isEqualTo(expectedUsuario.getName());
        Assertions.assertThat(usuario.getAge()).isEqualTo(expectedUsuario.getAge());
    }
}