package com.example.zup.vacinabrasil.integration;

import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.repository.UsuarioRepository;
import com.example.zup.vacinabrasil.util.EntityCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UsuarioControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("FindAll Returns Iterable Anime List When Succesful")
    void findAll_ReturnsPageableAnimeList_WhenSuccesful() {
        Usuario expected = usuarioRepository.save(EntityCreator.createUsuarioToBeSaved());
        Iterable<Usuario> usuarioIterable = testRestTemplate.exchange("http://localhost:8080/usuarios", HttpMethod.GET, null,
                new ParameterizedTypeReference<Iterable<Usuario>>() {
                }).getBody();

        System.out.println(usuarioIterable);
        Assertions.assertThat(usuarioIterable).isNotEmpty().hasSize(1).contains(expected);
    }
    @Test
    @DisplayName("FindById returns Usuario When Succesful")
    void findById_ReturnsUsuario_WhenSuccesful() {
        Usuario usuarioSaved = usuarioRepository.save(EntityCreator.createUsuarioToBeSaved());

        Long expectedId = usuarioSaved.getId();
        System.out.println(expectedId);
        testRestTemplate.getForObject("http://localhost:8080/usuarios/{id}", Usuario.class, expectedId);

        Assertions.assertThat(usuarioSaved).isNotNull();
        Assertions.assertThat(usuarioSaved.getId()).isNotNull().isEqualTo(expectedId);
    }
}
