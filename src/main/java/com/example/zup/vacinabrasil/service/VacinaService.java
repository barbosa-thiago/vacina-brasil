package com.example.zup.vacinabrasil.service;

import com.example.zup.vacinabrasil.mapper.VacinaMapper;
import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.repository.VacinaRepository;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VacinaService {
    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository){
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina save(VacinaPostRequestBody vacinaPostRequestBody){
        vacinaPostRequestBody.setVaccinationDate(LocalDate.now());
        return vacinaRepository.save(VacinaMapper.INSTANCE.toVacina(vacinaPostRequestBody));
    }
}
