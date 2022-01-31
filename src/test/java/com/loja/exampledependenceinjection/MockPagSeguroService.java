package com.loja.exampledependenceinjection;

import java.math.BigDecimal;

import com.loja.exampledependenceinjection.pagamento.PagSeguroService;

/*
 * Classe criada para simular o service de forma de pagamento.
 * Isso foi feito a titulo de teste uma vez que utilizar no teste a
 * classe PagSeguroService efetua uma transação na operadora de cartão real
 */
public class MockPagSeguroService extends PagSeguroService {
	public MockPagSeguroService(String token) {
		super(token);
	}

	@Override
	public void efetuarPagamento(String numeroCartao, BigDecimal valor) {
		System.out.println("[Mock] Não faz nada");
	}
}
