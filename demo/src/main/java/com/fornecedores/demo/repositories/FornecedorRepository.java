package com.fornecedores.demo.repositories;

import com.fornecedores.demo.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

}
