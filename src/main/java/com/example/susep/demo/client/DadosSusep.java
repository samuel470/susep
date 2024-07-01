package com.example.susep.demo.client;

import com.example.susep.demo.client.response.ProdutosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "produtosClient", url = "https://dados.susep.gov.br/olinda/servico/produtos/versao/v1/odata/")
public interface DadosSusep {

    @GetMapping("DadosProdutos?$format=json")
    String getDadosProdutos();
}