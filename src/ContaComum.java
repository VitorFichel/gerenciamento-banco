package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class ContaComum extends Conta {
	
	public ContaComum(int n, Pessoa p) {
		super(n, p);
	}

	public void debito(double valor) throws ExcecaoSaldoInsuficiente {
		if (valor > 0 && valor <= saldo) {
		   saldo = saldo - valor;
		   extrato.adicionarOperacao(null, getNumero(), valor, saldo, "Debito");
		} else {
			System.out.println("Valor debitado invalido.");
			throw new ExcecaoSaldoInsuficiente(numero, saldo, valor);
		}
	}	
}
