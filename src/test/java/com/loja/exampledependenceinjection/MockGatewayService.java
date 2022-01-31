package com.loja.exampledependenceinjection;

import java.math.BigDecimal;

import com.loja.exampledependenceinjection.pagamento.GatewayPagamento;

public class MockGatewayService implements GatewayPagamento {

	@Override
	public void efetuarPagamento(String numeroCartao, BigDecimal valor) {
		System.out.println("[MockGatewayService] Usando Mock de forma de pagamento");
	}
}
