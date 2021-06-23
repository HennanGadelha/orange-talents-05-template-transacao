package com.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class ConsultaTransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> consultarTransacao(@PathVariable String idCartao,
                                                @PageableDefault(direction = Sort.Direction.DESC, page = 0, size = 10)
                                                        Pageable pageable) {

        Page<Transacao> transacoes = transacaoRepository.findByCartaoId(idCartao, pageable);

       if(transacoes.isEmpty()) return ResponseEntity.notFound().build();

       return ResponseEntity.ok().body(transacoes.map(TransacaoResponse::new));



    }



}
