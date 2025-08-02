package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class ExcecaoSaldoInsuficiente extends Exception {

	public ExcecaoSaldoInsuficiente(int n, double s, double v) {
		super("Saldo insuficiente. Conta: " + n + ". Saldo: " + s +
				". Valor a debitar: " + v + ".");
	}
}
