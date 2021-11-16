import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ClienteDAOTest {
    private ClienteDAO clienteDAO;

    @Before
    public void init() {
        clienteDAO = new ClienteDAO();
    }

    @After
    public void limpar() {
        clienteDAO.deletarTodos();
    }

    @Test
    public void deveSalvarUmCliente() {
        Contato contato = new Contato("testerson@teste.com", "555555555");
        Endereco endereco = new Endereco("Rua teste", "444", "Testeira", "Testing", "90600000", "Testando", "TS");
        Cliente cliente = new Cliente(contato, endereco, "Testerson", "12345678910");
        clienteDAO.adicionar(cliente);
    }

    @Test
    public void deveListarTodosOsClientes() {
        Contato contato = new Contato("testerson@teste.com", "555555555");
        Endereco endereco = new Endereco("Rua teste", "444", "Testeira", "Testing", "90600000", "Testando", "TS");

        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente(contato, endereco, "Testerson"+i, "1234567891"+i);
            clienteDAO.adicionar(cliente);
        }

        List<Cliente> clientesSalvos = clienteDAO.buscarTodos();
        Assert.assertEquals(10, clientesSalvos.size());
    }

    @Test
    public void deveValidarClienteJaCadastrado() {
        Contato contato = new Contato("testerson@teste.com", "555555555");
        Endereco endereco = new Endereco("Rua teste", "444", "Testeira", "Testing", "90600000", "Testando", "TS");
        Cliente cliente = new Cliente(contato, endereco, "Testerson", "1234567891");
        clienteDAO.adicionar(cliente);

        try {
            clienteDAO.adicionar(cliente);
        } catch (Exception e) {
            Assert.assertEquals("Cliente ja cadastrado", e.getMessage());
        }
    }
}
