package com.example.zup.vacinabrasil.mapper;

import com.example.zup.vacinabrasil.models.Usuario;
import com.example.zup.vacinabrasil.requests.UsuarioPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UsuarioMapper {

    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    public abstract Usuario toUsuario(UsuarioPostRequestBody usuarioPostRequestBody);
}
