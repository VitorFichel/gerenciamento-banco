package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import java.sql.SQLException;

public class Banco {
	
	private EstruturaDeDadosDeConta contas;
	
	public Banco(EstruturaDeDadosDeConta estrutura) {
		contas = estrutura;		
	}
	
	public boolean inserir(Conta c) throws SQLException {
		return contas.inserir(c);
	}
	
	public void juros(int n, double t) throws ExcecaoContaInexistente, SQLException {
		Conta c = contas.pesquisar(n);
		if (c instanceof Poupanca) {
			((Poupanca) c).rendeJuros(t);
		}
	}

	public void deposito(int n, double v) throws ExcecaoContaInexistente, SQLException {
		Conta c = contas.pesquisar(n);
		c.credito(v);
	}
		
	public void saque(int n, double v) throws ExcecaoSaldoInsuficiente, ExcecaoContaInexistente, SQLException {
		Conta c = contas.pesquisar(n);
		c.debito(v);
	}
	
	public double saldo(int n) throws ExcecaoContaInexistente, SQLException {
		Conta c = contas.pesquisar(n);
		return c.getSaldo();
	}
	
	public String extrato(int n) throws ExcecaoContaInexistente, SQLException {
		Conta c = contas.pesquisar(n);
		return c.getExtrato();
	}
	
	public void transferencia() {	
	}
}
