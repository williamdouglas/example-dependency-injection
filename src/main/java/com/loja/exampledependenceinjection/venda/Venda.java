package com.loja.exampledependenceinjection.venda;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Venda {
    private String produto;
    private int quantidade;
    private BigDecimal precoUnitario;

    // public String getProduto() {
    //     return produto;
    // }

    // public void setProduto(String produto) {
    //     this.produto = produto;
    // }

    // public int getQuantidade() {
    //     return quantidade;
    // }

    // public void setQuantidade(int quantidade) {
    //     this.quantidade = quantidade;
    // }

    // public BigDecimal getPrecoUnitario() {
    //     return precoUnitario;
    // }

    // public void setPrecoUnitario(BigDecimal precoUnitario) {
    //     this.precoUnitario = precoUnitario;
    // }
}
