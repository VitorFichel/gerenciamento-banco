package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import java.util.ArrayList;

public class ArrayListDeContas implements EstruturaDeDadosDeConta {
	
	private ArrayList<Conta> lista = new ArrayList<Conta>();

	public boolean inserir(Conta c) {
		Conta outra;
		try {
			outra = pesquisar(c.getNumero());
		} catch (ExcecaoContaInexistente e) {
			lista.add(c);
			return true;
		}
		return false;
	}

	public Conta pesquisar(int n) throws ExcecaoContaInexistente {
		for (Conta conta : lista) {
			if (conta.getNumero() == n) {
				return conta;
			}
		}
		throw new ExcecaoContaInexistente(n);
	}
}
