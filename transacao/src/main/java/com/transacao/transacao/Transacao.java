package com.transacao.transacao;

import com.transacao.cartao.Cartao;
import com.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }


    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
