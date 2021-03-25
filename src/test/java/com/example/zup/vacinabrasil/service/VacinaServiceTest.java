package com.example.zup.vacinabrasil.service;

import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.repository.VacinaRepository;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class VacinaServiceTest {
    @InjectMocks
    private VacinaService vacinaService;
    @Mock
    private VacinaRepository vacinaRepositoryMock;


    @Mock
    VacinaPostRequestBody vacinaPostRequestBody;

    Vacina expectedVacina = EntityCreator.createValidVacina();

    @BeforeEach
    void setup() {
        Iterable<Vacina> vacinaPage = List.of(EntityCreator.createValidVacina());
        BDDMockito.when(vacinaRepositoryMock.findAll()).thenReturn(vacinaPage);
        BDDMockito.when(vacinaRepositoryMock.save(ArgumentMatchers.any(Vacina.class)))
                .thenReturn(EntityCreator.createValidVacina());
    }

    @Test
    @DisplayName("Save Persists Vacina When Succesful")
    void save_PersistsVacina_WhenSuccesful() {
        Vacina savedVacina = vacinaService.save(EntityCreator.createVacinaPostRequestBody());

        Assertions.assertThat(savedVacina).isNotNull();
        Assertions.assertThat(savedVacina.getId()).isNotNull()
                .isEqualTo(expectedVacina.getId());
        Assertions.assertThat(savedVacina.getVaccinationDate()).isEqualTo(expectedVacina.getVaccinationDate());
        Assertions.assertThat(savedVacina.getVaccineName()).isEqualTo(expectedVacina.getVaccineName());
    }

//    @Test
//    @DisplayName("findAll ReturnsPageableVacinaList WhenSuccesful")
//    void findAll_ReturnsPageableVacinaList_WhenSuccesful() {
//        Iterable<Vacina> vacinaIterable = vacinaService.findAll();
//
//        Assertions.assertThat(vacinaIterable).isNotNull()
//                .contains(expectedVacina)
//                .doesNotContainNull();

//    }


}