import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FornecedorDAOTest {

    private FornecedorDAO fornecedorDAO;

    @Before
    public void init() {
        fornecedorDAO = new FornecedorDAO();
    }

//    @After
//    public void limpar() {
//        fornecedorDAO.deletarTodos();
//    }

    @Test
    public void deveSalvarUmFornecedor() {
        Contato contato = new Contato("fornecedor@dor.com", "555555555");
        Endereco endereco = new Endereco("Rua Forne", "555", "Testeira", "Testing", "90600000", "Testando", "TS");
        Fornecedor fornecedor = new Fornecedor(contato, endereco, "Fornecedor SA", "3333000150");
        fornecedorDAO.adicionar(fornecedor);
    }
}
