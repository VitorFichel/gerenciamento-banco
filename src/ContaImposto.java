package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public class ContaImposto extends Conta {

	private double imposto;
	
	public ContaImposto(int n, Pessoa p, double i) {
		super(n, p);
		imposto = i;
	}
	
	public void debito(double valor) throws ExcecaoSaldoInsuficiente {
		valor = valor + valor * imposto;			
		if (valor > 0 && valor <= saldo) {
			   saldo = saldo - valor;
			   extrato.adicionarOperacao(null, numero, valor, saldo, "Debito");
		} else {
			System.out.println("Valor debitado invalido.");
			throw new ExcecaoSaldoInsuficiente(numero, saldo, valor);		}
		}
		public double getImposto(){
			return imposto;
		}
}
