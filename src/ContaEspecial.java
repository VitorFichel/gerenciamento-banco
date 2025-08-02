package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class ContaEspecial extends Conta {

	private double limite;

	public ContaEspecial(int n, Pessoa p, double l) {
		super(n, p);
		limite = l;
	}

	public void debito(double valor) throws ExcecaoSaldoInsuficiente {
		if (valor > 0 && valor <= saldo + limite) {
		   saldo = saldo - valor;
		   extrato.adicionarOperacao(null, getNumero(), valor, saldo, "Debito");
		} else {
			System.out.println("Valor debitado invalido.");
			throw new ExcecaoSaldoInsuficiente(numero, saldo, valor);
		}
	}

	public double getLimite(){
		return limite;
	}
}
