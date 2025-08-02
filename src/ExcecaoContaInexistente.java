package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class ExcecaoContaInexistente extends Exception {

	public ExcecaoContaInexistente(int n) {
		super("Conta não encontrada. Número: " + n);
	}
}
