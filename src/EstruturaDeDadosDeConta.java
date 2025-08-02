package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import java.sql.SQLException;

public interface EstruturaDeDadosDeConta {

	public boolean inserir(Conta c) throws SQLException;
	public Conta pesquisar(int n) throws ExcecaoContaInexistente, SQLException;

}
