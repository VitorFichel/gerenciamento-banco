package pedroSantosNeto.vitorEmanuelFichelSousa.banco;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EstruturaDeDadosDeContaTest {

    BancoDeDadosDeConta estrutura;

    @BeforeEach
    void setUp() throws Exception {
        estrutura = new BancoDeDadosDeConta();
    }

    @Test
    void testInserirEPesquisarContaComum() throws Exception {

        Pessoa p = new Pessoa(111111111, "João");
        Conta contaOriginal = new ContaComum(101, p);
        contaOriginal.credito(100.0);
        estrutura.apagar();
        boolean inserido = estrutura.inserir(contaOriginal);
        assertTrue(inserido);

        Conta contaRecuperada = estrutura.pesquisar(101);
        assertNotNull(contaRecuperada);
        assertEquals(101, contaRecuperada.getNumero());
        assertEquals("João", contaRecuperada.getDono().getNome());
        assertEquals(111111111, contaRecuperada.getDono().getCpf());
        assertEquals(100.0, contaRecuperada.getSaldo(), 0.001);
        assertTrue(contaRecuperada instanceof ContaComum);
    }

    @Test
    void testInserirEPesquisarContaEspecial() throws Exception {

        Pessoa p = new Pessoa(222222222, "Maria");
        Conta contaOriginal = new ContaEspecial(102, p, 500.0);
        contaOriginal.credito(250.0);
        estrutura.apagar();
        assertTrue(estrutura.inserir(contaOriginal));

        Conta contaRecuperada = estrutura.pesquisar(102);
        assertNotNull(contaRecuperada);
        assertEquals(102, contaRecuperada.getNumero());
        assertEquals(250.0, contaRecuperada.getSaldo(), 0.001);
        assertTrue(contaRecuperada instanceof ContaEspecial);
        assertEquals(500.0, ((ContaEspecial) contaRecuperada).getLimite(), 0.001);
    }

    @Test
    void testInserirEPesquisarContaImposto() throws Exception {

        Pessoa p = new Pessoa(333333333, "Carlos");
        Conta contaOriginal = new ContaImposto(103, p, 0.1);
        contaOriginal.credito(300.0);
        estrutura.apagar();

        assertTrue(estrutura.inserir(contaOriginal));

        Conta contaRecuperada = estrutura.pesquisar(103);
        assertNotNull(contaRecuperada);
        assertEquals(103, contaRecuperada.getNumero());
        assertTrue(contaRecuperada instanceof ContaImposto);
        assertEquals(0.1, ((ContaImposto) contaRecuperada).getImposto(), 0.001);
    }

    @Test
    void testInserirEPesquisarPoupanca() throws Exception {
        Pessoa p = new Pessoa(444444444, "Ana");
        Conta contaOriginal = new Poupanca(104, p);
        contaOriginal.credito(50.0);
        estrutura.apagar();

        assertTrue(estrutura.inserir(contaOriginal));

        Conta contaRecuperada = estrutura.pesquisar(104);
        assertNotNull(contaRecuperada);
        assertTrue(contaRecuperada instanceof Poupanca);
        assertEquals(50.0, contaRecuperada.getSaldo(), 0.001);
    }



}