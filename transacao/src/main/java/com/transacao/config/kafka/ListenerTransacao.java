package com.transacao.config.kafka;

import com.transacao.transacao.Transacao;
import com.transacao.transacao.TransacaoRepository;
import com.transacao.transacao.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    TransacaoRepository transacaoRepository;


    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoRequest transacaoRequest) {

        System.out.println("-------------------------------");
        System.out.println(transacaoRequest);
        Transacao transacao = transacaoRequest.toModel();
        transacaoRepository.save(transacao);
        System.out.println("-------------------------------");
    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }


}
