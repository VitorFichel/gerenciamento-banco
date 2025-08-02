package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class ListaDeContas implements EstruturaDeDadosDeConta {

	private Conta conta = null;
	private ListaDeContas prox = null;
	
	public boolean inserir(Conta c) {

		Conta outra;
		try {
			outra = pesquisar(c.getNumero());
			return false;
		} catch (ExcecaoContaInexistente e) {
	 		if (prox == null) {
				ListaDeContas novo = new ListaDeContas();
				conta = c;
				novo.conta = null;
				novo.prox = null;
				prox = novo;
				return true;
			} else {
				return prox.inserir(c);
			}
		}
	}
	
	public Conta pesquisar(int n) throws ExcecaoContaInexistente {
		if (conta == null) {
			throw new ExcecaoContaInexistente(n);
		}
		if (conta.getNumero() == n) {
			return conta;
		} else {
			return prox.pesquisar(n);
		}
	}
}
