package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import java.sql.SQLException;
import java.sql.*;

public class BancoDeDadosDeConta implements EstruturaDeDadosDeConta {

    public boolean inserir(Conta c) throws SQLException {
        try {
            Connection con = Conexao.getConexao();
            Statement stmt = con.createStatement();
            String tipo = "Comum";
            double limite = 0, imposto = 0;
            if (c instanceof ContaEspecial) {
                tipo = "Especial";
                limite = ((ContaEspecial) c).getLimite();
            }
            else if (c instanceof ContaImposto) {
                tipo = "Imposto";
                imposto = ((ContaImposto) c).getImposto();
            }
            else if (c instanceof Poupanca){
                tipo = "Poupança";
            }

            String cmd = "INSERT INTO conta (numero, nome, cpf, tipo, saldo, extrato, limite, imposto) VALUES (" +
                    c.getNumero() + ", '" +
                    c.getDono().getNome() + "', '" +
                    c.getDono().getCpf() + "', '" +
                    tipo + "', " +
                    c.getSaldo() + ", '" +
                    c.getExtrato() + "', " +
                    limite + ", " +
                    imposto + ")";

            System.out.println(cmd);
            stmt.execute(cmd);
            stmt.close();
            con.close();
            return true;
        }
        catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Conta pesquisar(int n) throws ExcecaoContaInexistente, SQLException {
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from conta where numero = " + n);
        Conta c = null;
        if (rs.next()){
            int numero = rs.getInt("numero");
            String nome = rs.getString("nome");
            int cpf = rs.getInt("cpf");
            String tipo = rs.getString("tipo");
            double saldo = rs.getDouble("saldo");
            String extrato = rs.getString("extrato");
            double limite = rs.getDouble("limite");
            double imposto = rs.getDouble("imposto");

            Pessoa p = new Pessoa(cpf, nome);
            if (tipo.equals("Especial")){
                c = new ContaEspecial(numero, p, limite);
            }
            if (tipo.equals("Imposto")){
                c = new ContaImposto(numero, p, imposto);
            }
            if (tipo.equals("Comum")){
                c = new ContaComum(numero, p);
            }
            if (tipo.equals("Poupança")){
                c = new Poupanca(numero, p);
            }
            c.credito(saldo);
        }
        stmt.close();
        return c;
    }

    public void apagar() throws Exception {
        Connection con = Conexao.getConexao();
        Statement stmt = con.createStatement();
        String cmd = "delete from conta";
        stmt.execute(cmd);
        stmt.close();
        con.close();
    }

}
