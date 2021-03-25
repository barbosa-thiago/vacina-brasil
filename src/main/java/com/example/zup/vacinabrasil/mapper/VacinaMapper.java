package com.example.zup.vacinabrasil.mapper;

import com.example.zup.vacinabrasil.models.Vacina;
import com.example.zup.vacinabrasil.requests.VacinaPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class VacinaMapper {
    public static final VacinaMapper INSTANCE = Mappers.getMapper(VacinaMapper.class);

    public abstract Vacina toVacina(VacinaPostRequestBody vacinaPostRequestBody);
}
