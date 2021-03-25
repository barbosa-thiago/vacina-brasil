package com.example.zup.vacinabrasil.integration;


import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.repository.VacinaRepository;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class VacineControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private VacinaRepository vacinaRepository;

    @Test
    @DisplayName("Save Persists Vacina When Succesdful")
    void save_PersistVacina_WhenSuccesful() {
        VacinaPostRequestBody vacina = EntityCreator.createVacinaPostRequestBody();
        Vacina savedVacina = testRestTemplate.postForObject("http://localhost:8080/vacinas", vacina, Vacina.class);

        Assertions.assertThat(savedVacina).isNotNull();
        Assertions.assertThat(savedVacina.getId()).isNotNull();
        Assertions.assertThat(savedVacina.getVaccineName()).isEqualTo(vacina.getVaccineName());
    }
}
