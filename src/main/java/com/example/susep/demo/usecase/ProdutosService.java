package com.example.susep.demo.usecase;

import com.example.susep.demo.client.DadosSusep;
import com.example.susep.demo.client.response.Produto;
import com.example.susep.demo.client.response.ProdutosResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private DadosSusep produtosClient;

    @Autowired
    private Cache<String, String> produtosCache;

    private static final String CACHE_KEY = "produtos";

    @Scheduled(cron = "0 0 0 * * ?") // Executa à meia-noite todos os dias
    public String atualizarCache() {
        String response = produtosClient.getDadosProdutos();
        produtosCache.put(CACHE_KEY, response);
        return response;
    }


    public List<Produto> getDadosProdutos() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String ifPresent = produtosCache.getIfPresent(CACHE_KEY) != null ? produtosCache.getIfPresent(CACHE_KEY) : atualizarCache();
            ProdutosResponse map = mapper.readValue(ifPresent, ProdutosResponse.class);
            if (map==null){
                atualizarCache();
                return mapper.readValue(produtosCache.getIfPresent(CACHE_KEY), ProdutosResponse.class).getProdutos();
            }
            List<Produto> produtos= map.getProdutos();
            return produtos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }

    public Optional<Produto> getProdutoByNumeroProcesso(String numeroProcesso) {
        List<Produto> response = getDadosProdutos();
        if (response != null) {

            Optional<Produto> first = response.stream()
                    .filter(produto -> produto.getNumeroProcesso().equals(numeroProcesso))
                    .findFirst();


            return first;
        }
        return Optional.empty();
    }

}