package com.fornecedores.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_fornecedores")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String cnpj;
    private String contato;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Column(name = "nome_fantasia")
    public String getNomeFantasia() { return nomeFantasia; }

    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    @Column(name = "contato_cliente")
    public String getContato() { return contato; }

    public void setContato(String contato) { this.contato = contato; }
}
