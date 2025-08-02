package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class Poupanca extends ContaComum {

	public Poupanca(int n, Pessoa p) {
		super(n, p);
	}
	
	public void rendeJuros(double tx) {
		double rendimento = getSaldo() * tx;
		credito(rendimento);
	}
}
