package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TesteMYSQL {

    @Test
    public void TesteInsere() throws Exception {

        BancoDeDadosDeConta estrutura = new BancoDeDadosDeConta();

        estrutura.apagar();

        Pessoa p1 = new Pessoa(1, "Pedro");
        Conta c1 = new ContaComum(1, p1);

        Pessoa p2 = new Pessoa(2, "Joao");
        Conta c2 = new ContaEspecial(2, p2, 500);

        Pessoa p3 = new Pessoa(3, "Maria");
        Conta c3 = new ContaImposto(3, p3, 1000);

        Pessoa p4 = new Pessoa(4, "Jorge");
        Conta c4 = new Poupanca(4, p4 );

        c1.credito(932.53);
        c2.credito(250.32);
        c3.credito(500);
        c4.credito(102432);

        assertTrue(estrutura.inserir(c4));
        assertTrue(estrutura.inserir(c1));
        assertTrue(estrutura.inserir(c2));
        assertTrue(estrutura.inserir(c3));

        Conta contaencontrada = estrutura.pesquisar(1);
        assertEquals("Pedro", contaencontrada.getDono().getNome());

        Conta poupancaenc = estrutura.pesquisar(4);
        assertEquals("Jorge", poupancaenc.getDono().getNome());

        assertNotNull(contaencontrada);
        assertNotNull(estrutura.pesquisar(2));
        assertNotNull(estrutura.pesquisar(3));
        assertNotNull(poupancaenc);
    }
    @Test
    public void TestePoupanca() throws Exception {

        BancoDeDadosDeConta estrutura = new BancoDeDadosDeConta();

        estrutura.apagar();

        Pessoa p4 = new Pessoa(4, "Jorge");
        Conta c4 = new Poupanca(4, p4 );

        c4.credito(102432);

        assertTrue(estrutura.inserir(c4));

        Conta poupancaenc = estrutura.pesquisar(4);
        assertEquals("Jorge", poupancaenc.getDono().getNome());

        assertNotNull(poupancaenc);
    }



}



