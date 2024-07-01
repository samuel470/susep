package com.example.susep.demo.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {

    @JsonProperty("tipoproduto")
    private String tipoProduto;

    @JsonProperty("entnome")
    private String entNome;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("numeroprocesso")
    private String numeroProcesso;

    @JsonProperty("ramo")
    private String ramo;

    @JsonProperty("subramo")
    private String subRamo;

    // Getters and Setters
    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getEntNome() {
        return entNome;
    }

    public void setEntNome(String entNome) {
        this.entNome = entNome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getSubRamo() {
        return subRamo;
    }

    public void setSubRamo(String subRamo) {
        this.subRamo = subRamo;
    }
}
