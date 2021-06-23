package com.transacao.transacao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transacao.cartao.CartaoRequest;
import com.transacao.estabelecimento.EstabelecimentoRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRequest {

    @NotBlank
    @JsonProperty
    private String id;
    @NotNull
    @JsonProperty
    private BigDecimal valor;
    @NotNull
    @JsonProperty
    private EstabelecimentoRequest estabelecimento;
    @NotNull
    @JsonProperty
    private CartaoRequest cartao;
    @NotNull
    @JsonProperty
    private LocalDateTime efetivadaEm;


    public TransacaoRequest() {}

    public TransacaoRequest(  String id,   BigDecimal valor,   EstabelecimentoRequest estabelecimento,   CartaoRequest cartao,
                              LocalDateTime efetivadaEm) {
        super();
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, efetivadaEm,estabelecimento.toModel(), cartao.toModel());
    }


    @Override
    public String toString() {
        return "TransacaoRequest{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
