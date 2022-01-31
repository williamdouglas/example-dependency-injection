package com.loja.exampledependenceinjection.venda;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.loja.exampledependenceinjection.pagamento.GatewayPagamento;

// Simula o registro de uma venda na base de dados
@Component
public class VendaService {
	private GatewayPagamento gatewayPagamento;

	// 2) variavel de instancia e construtor com a injeção do PagSeguroService
	// recebe de quem a usa a forma de pagamento.
	// Ainda temos alto acoplamento uma vez que mesmo transferindo a
	// responsabilidade
	// de instanciação por meio da classe de fora, VendaService ainda depende do
	// PagSeguroService.
	// 3) Veja que para alterar para PayPalService precisamos alterar o código de
	// VendaService. Neste caso usaremos Depence Inversion - DIP, desacoplar classes
	// do nosso código
	public VendaService(GatewayPagamento gatewayPagamento) {
		this.gatewayPagamento = gatewayPagamento;
	}

	public void registrar(Venda venda, String numeroCartao) {
		BigDecimal valorTotal = venda.getPrecoUnitario().multiply(new BigDecimal(venda.getQuantidade()));

		System.out.printf("[Venda] Registrando venda %s no valor total de %f...\n", venda.getProduto(), valorTotal);

		/*
		 * 1) Dependencia, acoplamento forte entre VendaService e PagSeguroService. Não
		 * temos a plugabilidade, ou seja, não conseguimos alterar ou inserir um novo
		 * meio de pagamento sem alterar esse código.
		 * 
		 * 2) De acordo com a inversão de controle invertemos o fluxo do programa
		 * deixando essa instanciação para uma classe externa e retirando daqui o forte
		 * acomplamento. Podemos usar para isso a Injeção de Dependências.
		 */
		// PagSeguroService pagSeguroService = new
		// PagSeguroService("80d987fa9s87df8dh8g8f99cx8x");
		gatewayPagamento.efetuarPagamento(numeroCartao, valorTotal);
	}
}
