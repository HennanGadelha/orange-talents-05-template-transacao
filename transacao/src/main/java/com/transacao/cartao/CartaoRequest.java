package com.transacao.cartao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CartaoRequest {

    @NotBlank
    @JsonProperty
    private String id;
    @NotBlank
    @JsonProperty
    private String email;

    @Deprecated
    public CartaoRequest() {

    }

    public CartaoRequest( @JsonProperty String id,  @JsonProperty String email) {
        super();
        this.id = id;
        this.email = email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }


}
