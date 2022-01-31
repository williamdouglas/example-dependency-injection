package com.loja.exampledependenceinjection.pagamento;

import java.lang.management.GarbageCollectorMXBean;
import java.math.BigDecimal;

// Simulando a integração com a API gateway de pagamento do PagSeguro
public class PayPalService implements GatewayPagamento {
	private String usuario;
	private String senha;

	public PayPalService(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	@Override
	public void efetuarPagamento(String numeroCartao, BigDecimal valor) {
		System.out.printf("[PayPal] Usando usuario: %s\n", usuario);
		System.out.printf("[PayPal] Cobrando %f do cartao %s...\n", valor, numeroCartao);
	}
}
