package com.loja.exampledependenceinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.loja.exampledependenceinjection.pagamento.GatewayPagamento;
import com.loja.exampledependenceinjection.pagamento.PagSeguroService;
import com.loja.exampledependenceinjection.pagamento.PayPalService;
import com.loja.exampledependenceinjection.venda.VendaService;

@Configuration
public class LojaConfig {
	@Bean
	public PagSeguroService pagSeguroService() {
		return new PagSeguroService("80d987fa9s87df8dh8g8f99cx8x");
	}
	
	@Primary
	@Bean
	public PayPalService payPalService() {
		return new PayPalService("teste", "1234");
	}

	// @Bean
	// public VendaService vendaService(GatewayPagamento gatewayPagamento) {
	// return new VendaService(gatewayPagamento);
	// }
}
