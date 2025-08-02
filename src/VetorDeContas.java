package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class VetorDeContas implements EstruturaDeDadosDeConta{

	private Conta[] contas = new Conta[50];
	private int pos = 0;
	
	public boolean inserir(Conta c) {
		Conta outra;
		try {
			outra = pesquisar(c.getNumero());
		} catch (ExcecaoContaInexistente e) {
			contas[pos++] = c;
			return true;
		}
		return false;
	}

	public Conta pesquisar(int n)  throws ExcecaoContaInexistente {
		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == n) {
				return contas[i];
			}
		}
		throw new ExcecaoContaInexistente(n);
	}
}
