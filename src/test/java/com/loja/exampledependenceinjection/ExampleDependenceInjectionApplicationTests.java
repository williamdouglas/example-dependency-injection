package com.loja.exampledependenceinjection;

import java.math.BigDecimal;

import javax.management.RuntimeErrorException;

import com.loja.exampledependenceinjection.pagamento.PagSeguroService;
import com.loja.exampledependenceinjection.pagamento.PayPalService;
import com.loja.exampledependenceinjection.venda.Venda;
import com.loja.exampledependenceinjection.venda.VendaService;

import org.junit.jupiter.api.Test;

// @SpringBootTest
class VendaServiceTest {
	@Test
	public void registrarVenda() {
		Venda venda = new Venda();
		venda.setProduto("Camiseta branca básica");
		venda.setQuantidade(2);
		venda.setPrecoUnitario(new BigDecimal(109.5));

		// 2) Para se utilizar o vendaService necessitamos passar uma instancia de
		// PagSeguroService, ou seja, a quem usa fica a responsabilidade de passar a
		// forma de pagamento e não a classe VendaService.
		// VendaService vendaService = new VendaService(new PagSeguroService("80d987fa9s87df8dh8g8f99cx8x"));
		// VendaService vendaService = new VendaService(new MockPagSeguroService("80d987fa9s87df8dh8g8f99cx8x"));
		// VendaService vendaService = new VendaService(new PayPalService("teste", "1234"));
		// Aqui estamos injetando dependencias manualmente, passando para o VendaService a dependencia
		// que ele utilizará 
		VendaService vendaService = new VendaService(new MockGatewayService());

		vendaService.registrar(venda, "7876876509893426");

		// 1) Erro na forma de pagamento escolhido prejudicaria o teste do método
		// VendaService que está correto.
		// throw new RuntimeException("Erro cobrando com o PagSeguro");
	}
}
