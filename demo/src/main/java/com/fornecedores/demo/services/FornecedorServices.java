package com.fornecedores.demo.services;

import com.fornecedores.demo.model.FornecedorModel;
import com.fornecedores.demo.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServices {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorModel> findAll() {
        return fornecedorRepository.findAll();
    }

    public FornecedorModel criarFornecedor(FornecedorModel fornecedor) { return fornecedorRepository.save(fornecedor); }

    public Optional<FornecedorModel> buscarPeloId(Long id) { return fornecedorRepository.findById(id); }

    public FornecedorModel atualizar(Long id, FornecedorModel fornecedor) {
        FornecedorModel fmodel = fornecedorRepository.findById(id).get();
        fmodel.setNomeFantasia(fornecedor.getNomeFantasia());
        fmodel.setCnpj(fornecedor.getCnpj());
        fmodel.setContato(fornecedor.getContato());
        return fornecedorRepository.save(fmodel);
    }

    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }

}
