package com.example.zup.vacinabrasil.repository;

import com.example.zup.vacinabrasil.models.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
}
