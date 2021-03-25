package com.example.zup.vacinabrasil.controller;

import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
import com.example.zup.vacinabrasil.service.VacinaService;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class VacinaControllerTest {

    @InjectMocks
    private VacinaController vacinaController;
    @Mock
    private VacinaService vacinaService;

    @BeforeEach

    public void setup(){
        Iterable<Vacina> vacinaIterable = List.of(EntityCreator.createValidVacina());
        BDDMockito.when(vacinaService.save(ArgumentMatchers.any(VacinaPostRequestBody.class)))
                .thenReturn(EntityCreator.createValidVacina());
    }

    @Test
    @DisplayName("Save Persists Vacina When Succesdful")
    void save_PersistAnime_WhenSuccesful(){
        Long expectedId = EntityCreator.createValidVacina().getId();
        VacinaPostRequestBody vacinaPostRequestBody = EntityCreator.createVacinaPostRequestBody();
        Vacina vacinaSalvo = vacinaController.save(vacinaPostRequestBody).getBody();
        Assertions.assertThat(vacinaSalvo).isNotNull();
        Assertions.assertThat(vacinaSalvo.getId()).isNotNull();
        Assertions.assertThat(vacinaSalvo.getVaccineName()).isEqualTo(vacinaPostRequestBody.getVaccineName());
        Assertions.assertThat(vacinaSalvo.getId()).isEqualTo(expectedId);
    }

//    @Test
//    @DisplayName("FindById returns Vacina When Succesful")
//    void findById_ReturnsVacina_WhenSuccesful(){
//        Long expectedId = EntityCreator.createValidVacina().getId();
//        Vacina vacina = vacinaController.findById(1L).getBody();
//
//        Assertions.assertThat(vacina).isNotNull();
//        Assertions.assertThat(vacina.getId()).isNotNull();
//        Assertions.assertThat(vacina.getId()).isEqualTo(expectedId);
//
//    }

//    @Test
//    @DisplayName("FindAll Returns Pageable Anime List When Succesful")
//    void findAll_ReturnsPageableAnimeList_WhenSuccesful(){
//        Vacina expected = EntityCreator.createValidVacina();
//        Iterable<Vacina> vacinaPage = vacinaController.findAll().getBody();
//
//        Assertions.assertThat(vacinaPage).isNotNull().contains(expected);
//    }
}