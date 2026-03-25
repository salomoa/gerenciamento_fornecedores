package com.fornecedores.demo.controllers;


import com.fornecedores.demo.model.FornecedorModel;
import com.fornecedores.demo.services.FornecedorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/fornecedores","/fornecedores/"})
public class FornecedorController {

    @Autowired
    private FornecedorServices fornecedorServices;

    @GetMapping
        public ResponseEntity<List<FornecedorModel> > buscarTodosFornecedores(){
        List<FornecedorModel> fornecedores = fornecedorServices.buscarTodosOsFornecedores();
        return ResponseEntity.ok(fornecedorServices.buscarTodosOsFornecedores());
    }

    @PostMapping
        public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedor){
            FornecedorModel fmodel = fornecedorServices.criarFornecedor(fornecedor);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(fmodel.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(fmodel);
        }

    @DeleteMapping
        public ResponseEntity<FornecedorModel> deletarFornecedor(@RequestParam Long id){
        fornecedorServices.deletarFornecedores(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
        public Optional<FornecedorModel> buscarFornecedorPorId(@PathVariable Long id){
        return fornecedorServices.buscarFornecedorId(id);

    }

    @PutMapping("/{id}")
        public ResponseEntity<FornecedorModel> atualizarFonecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedor){
        FornecedorModel fornecedorModel = fornecedorServices.atualizarFornecedores(id, fornecedor);
        return ResponseEntity.ok().body(fornecedorModel);

    }

}
