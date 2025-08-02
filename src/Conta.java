package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

public abstract class Conta {

	protected int numero;
	protected double saldo;
	private Pessoa dono;
	protected Extrato extrato = new Extrato();

	
	public Conta(int n, Pessoa p) {
		if (n > 0) { 
		  numero = n;	
		  dono = p;
		}
	}
	
	public Pessoa getDono() {
		return dono;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getExtrato() {
		return extrato.toString();
	}
	
	public double totalDeLancamentos(String tp) {
		return extrato.totalDeLancamentos(tp);
	}
		
	public void credito(double valor) {
		if (valor > 0) {
		   saldo = saldo + valor;
		   extrato.adicionarOperacao(null, numero, valor, saldo, "Credito");
		}
	}
	
	public abstract void debito(double valor) throws ExcecaoSaldoInsuficiente;
	
}
