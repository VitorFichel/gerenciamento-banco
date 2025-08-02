package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class TesteBanco {

	@Test
	void testarCadastroDePoupancas() throws ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "Raimundo");
		
		Conta c1 = new Poupanca(1, p1);
		Conta c2 = new Poupanca(2, p2);
		
		EstruturaDeDadosDeConta estr = new VetorDeContas();
		Banco b = new Banco(estr);
		
		assertTrue(b.inserir(c1));
		assertTrue(b.inserir(c2));
		
		assertFalse(b.inserir(c1));
		
		assertEquals(0, b.saldo(1));
		assertEquals(0, b.saldo(2));
		try {
            b.saldo(3);
            fail("Deveria ter gerado excecao de conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// Comportamento esperado!
		}
	}
	
	@Test
	void testarCadastroDeContas() throws ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "Raimundo");
		
		Conta c1 = new ContaComum(1, p1);
		Conta c2 = new ContaComum(2, p2);
		
		EstruturaDeDadosDeConta estr = new ArrayListDeContas();
		Banco b = new Banco(estr);
		
		assertTrue(b.inserir(c1));
		assertTrue(b.inserir(c2));
		
		assertFalse(b.inserir(c1));
		
		assertEquals(0, b.saldo(1));
		assertEquals(0, b.saldo(2));
		try {
            b.saldo(3);
            fail("Deveria ter gerado excecao de conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// Comportamento esperado!
		}
	}
	
	@Test
	void testarCreditoDebitoDeContas() throws ExcecaoSaldoInsuficiente, ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new ContaComum(1, p1);
		
		EstruturaDeDadosDeConta estr = new ListaDeContas();
		Banco b = new Banco(estr);
		
		b.inserir(c1);
		b.deposito(1, 100);
		assertEquals(100, b.saldo(1));
		b.saque(1, 99);
		assertEquals(1, b.saldo(1));
		try {
			b.saque(1, 2);
			fail("Deveria ter dado excecao de saldo insuficiente");
		} catch (ExcecaoSaldoInsuficiente e) {
			assertEquals(1, b.saldo(1));
		}
		System.out.println(b.extrato(1));
		assertEquals("\nConta: 1. Credito: 100.0. Saldo: 100.0\n" + 
				"Conta: 1. Debito: 99.0. Saldo: 1.0", b.extrato(1));
		
		try {
			b.deposito(3, 100);
			fail("Deveria ter dado excecao conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// comportamento esperado.
		}
		
		try {
			b.saldo(3);
			fail("Deveria ter dado excecao conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// comportamento esperado.
		}
		try {
			b.saque(3, 100);
			fail("Deveria ter dado excecao conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// comportamento esperado
		}
		
		try {
			b.extrato(3);
			fail("Deveria ter dado excecao conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// comportamento esperado
		}
	}
	
	@Test
	void testarCreditoDebitoDePoupancas() throws ExcecaoSaldoInsuficiente, ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new Poupanca(1, p1);		

		EstruturaDeDadosDeConta estr = new ListaDeContas();
		Banco b = new Banco(estr);
		
		b.inserir(c1);
		b.deposito(1, 100);
		assertEquals(100, b.saldo(1));
		b.saque(1, 99);
		assertEquals(1, b.saldo(1));
		try {
			b.saque(1, 2);
			fail("Deveria ter dado excecao de saldo insuficiente");
		} catch (ExcecaoSaldoInsuficiente e) {
			assertEquals(1, b.saldo(1));
		}
		System.out.println(b.extrato(1));
		assertEquals("\nConta: 1. Credito: 100.0. Saldo: 100.0\n" + 
				"Conta: 1. Debito: 99.0. Saldo: 1.0", b.extrato(1));
		
	}
	
	@Test
	void testarJurosPoupanca() throws ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new Poupanca(1, p1);	
		Pessoa p2 = new Pessoa(2, "Raimundo");
		Conta c2 = new ContaComum(2, p2);

		EstruturaDeDadosDeConta estr = new ListaDeContas();
		Banco b = new Banco(estr);
		
		b.inserir(c1);
		b.deposito(1, 100);
		assertEquals(100, b.saldo(1));
		b.juros(1, 0.01);
		assertEquals(101, b.saldo(1));
		
		b.inserir(c2);
		b.deposito(2, 100);
		assertEquals(100, b.saldo(2));
		b.juros(2, 0.01);
		assertEquals(100, b.saldo(2));
		
		
		try {
			b.deposito(3, 100);
			fail("Deveria ter dado excecao conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// comportamento esperado
		}
		try {
			b.juros(3, 0.01);
			fail("Deveria ter dado excecao conta inexistente");
		} catch (ExcecaoContaInexistente e) {
			// comportamento esperado
		}
	}

	@Test
	void testarContaImposto() throws ExcecaoSaldoInsuficiente, ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new ContaImposto(1, p1, 0.01);	

		EstruturaDeDadosDeConta estr = new ListaDeContas();
		Banco b = new Banco(estr);
		
		b.inserir(c1);
		b.deposito(1, 100);
		assertEquals(100, b.saldo(1));
		b.saque(1, 80);
		assertEquals(19.20, b.saldo(1), 0.0001);
	}
	

	@Test
	void testarContaEspecial() throws ExcecaoSaldoInsuficiente, ExcecaoContaInexistente, SQLException {
		Pessoa p1 = new Pessoa(1, "Pedro");
		Conta c1 = new ContaEspecial(1, p1, 200);	

		EstruturaDeDadosDeConta estr = new ListaDeContas();
		Banco b = new Banco(estr);
		
		b.inserir(c1);
		b.deposito(1, 100);
		assertEquals(100, b.saldo(1));
		b.saque(1, 200);
		assertEquals(-100, b.saldo(1), 0.0001);
		b.saque(1, 100);
		assertEquals(-200, b.saldo(1), 0.0001);
		try {
			b.saque(1, 0.01);
			fail("Deveria ter dado excecao de saldo insuficiente.");
		} catch (ExcecaoSaldoInsuficiente e) {
		}
		assertEquals(-200, b.saldo(1), 0.0001);
	}

}
