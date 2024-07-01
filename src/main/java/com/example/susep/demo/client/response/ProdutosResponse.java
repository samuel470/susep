package com.example.susep.demo.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ProdutosResponse {

    @JsonProperty("@odata.context")
    private String odataContext;

    @JsonProperty("value")
    private List<Produto> produtos;

    // Getters and Setters
    public String getOdataContext() {
        return odataContext;
    }

    public void setOdataContext(String odataContext) {
        this.odataContext = odataContext;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
