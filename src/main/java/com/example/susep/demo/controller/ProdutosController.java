package com.example.susep.demo.controller;

import com.example.susep.demo.client.response.Produto;
import com.example.susep.demo.usecase.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping("/dados")
    public List<Produto> getDadosProdutos() {
        List<Produto> produto = produtosService.getDadosProdutos();
        if (produto == null) {
            produtosService.atualizarCache();
        }

        return produto;
    }

    @GetMapping("/dados/filtrar")
    public Optional<Produto> getProdutoByNumeroProcesso(@RequestParam String numeroProcesso) {
        return produtosService.getProdutoByNumeroProcesso(numeroProcesso);
    }

}