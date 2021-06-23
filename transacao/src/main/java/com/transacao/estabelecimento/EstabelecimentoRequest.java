package com.transacao.estabelecimento;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoRequest {


    @NotBlank
    @JsonProperty
    private String nome;
    @NotBlank
    @JsonProperty
    private String cidade;
    @NotBlank
    @JsonProperty
    private String endereco;

    @Deprecated
    public EstabelecimentoRequest() {

    }

    public EstabelecimentoRequest( @JsonProperty String nome,  @JsonProperty String cidade,  @JsonProperty String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

}
