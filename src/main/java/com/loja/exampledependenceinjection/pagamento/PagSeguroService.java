package com.loja.exampledependenceinjection.pagamento;

import java.math.BigDecimal;

// Simulando a integração com a API gateway de pagamento do PagSeguro
public class PagSeguroService implements GatewayPagamento {
    private String token;

    public PagSeguroService(String token) {
        this.token = token;
    }

    @Override
	public void efetuarPagamento(String numeroCartao, BigDecimal valor) {
        System.out.printf("[PagSeguro] Usando token: %s\n", token);
        System.out.printf("[PagSeguro] Cobrando %f do cartao %s...\n", valor, numeroCartao);
    }
}
