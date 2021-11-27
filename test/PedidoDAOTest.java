import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.time.LocalDateTime;

public class PedidoDAOTest {

    private Cliente clientest;
    private Fornecedor fornetest;
    private Produto produtest;
    private Produto produtest2;
    private PedidoDAO pedidoDAO;

    @Before
    public void init() {
        pedidoDAO = new PedidoDAO();
        pedidoDAO.deletar();

        Endereco enderecoFor = new Endereco("Velha", "156", "Novo", "Comp", "85905040", "Cascavel", "PR");
        Contato contatoFor = new Contato("test@gmail.com", "555555555");
        fornetest = new Fornecedor(contatoFor, enderecoFor, 1,"Fantasia", "99999999999");
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.adicionar(fornetest);

        Endereco enderecoCli = new Endereco("Velha", "156", "Novo", "Comp", "85905040", "Cascavel", "PR");
        Contato contatoCli = new Contato("test@gmail.com", "555555555");
        clientest = new Cliente(contatoCli, enderecoCli, 1,"ClienteNome", "555555555");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.adicionar(clientest);

        produtest = new Produto("Produto", "Produto de teste", 55.99, 1);
        produtest2 = new Produto("Produto2", "Produto de teste segundo", 127.30, 2);
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.adicionar(produtest);
        produtoDao.adicionar(produtest2);

    }

    @After
    public void limparBanco() {
        pedidoDAO.deletar();
    }

    @Test
    public void deveAdicionarPedidoNoBanco() {
        Item item1 = new Item(produtest, 4);
        Item item2 = new Item(produtest2, 1);
        Pedido pedido = new Pedido(LocalDateTime.now(), fornetest, clientest, 50.30, item1);
        pedido.adicionarItem(item2);
        pedidoDAO.adicionar(pedido);
        var pedidoBuscado = pedidoDAO.buscarPorId(1);

        //cliente
        Assert.assertEquals(pedido.getCliente().getNome(), pedidoBuscado.getCliente().getNome());
        Assert.assertEquals(pedido.getCliente().getCpf(), pedidoBuscado.getCliente().getCpf());
        Assert.assertEquals(pedido.getCliente().getContato().getEmail(), pedidoBuscado.getCliente().getContato().getEmail());
        Assert.assertEquals(pedido.getCliente().getContato().getTelefone(), pedidoBuscado.getCliente().getContato().getTelefone());
        Assert.assertEquals(pedido.getCliente().getEndereco().getRua(), pedidoBuscado.getCliente().getEndereco().getRua());
        Assert.assertEquals(pedido.getCliente().getEndereco().getNumero(), pedidoBuscado.getCliente().getEndereco().getNumero());
        Assert.assertEquals(pedido.getCliente().getEndereco().getBairro(), pedidoBuscado.getCliente().getEndereco().getBairro());
        Assert.assertEquals(pedido.getCliente().getEndereco().getComplemento(), pedidoBuscado.getCliente().getEndereco().getComplemento());
        Assert.assertEquals(pedido.getCliente().getEndereco().getCep(), pedidoBuscado.getCliente().getEndereco().getCep());
        Assert.assertEquals(pedido.getCliente().getEndereco().getCidade(), pedidoBuscado.getCliente().getEndereco().getCidade());
        Assert.assertEquals(pedido.getCliente().getEndereco().getEstado(), pedidoBuscado.getCliente().getEndereco().getEstado());
        //fornecedor
        Assert.assertEquals(pedido.getFornecedor().getNomeFantasia(), pedidoBuscado.getFornecedor().getNomeFantasia());
        Assert.assertEquals(pedido.getFornecedor().getCnpj(), pedidoBuscado.getFornecedor().getCnpj());
        Assert.assertEquals(pedido.getFornecedor().getContato().getEmail(), pedidoBuscado.getFornecedor().getContato().getEmail());
        Assert.assertEquals(pedido.getFornecedor().getContato().getTelefone(), pedidoBuscado.getFornecedor().getContato().getTelefone());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getRua(), pedidoBuscado.getFornecedor().getEndereco().getRua());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getNumero(), pedidoBuscado.getFornecedor().getEndereco().getNumero());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getBairro(), pedidoBuscado.getFornecedor().getEndereco().getBairro());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getComplemento(), pedidoBuscado.getFornecedor().getEndereco().getComplemento());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getCep(), pedidoBuscado.getFornecedor().getEndereco().getCep());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getCidade(), pedidoBuscado.getFornecedor().getEndereco().getCidade());
        Assert.assertEquals(pedido.getFornecedor().getEndereco().getEstado(), pedidoBuscado.getFornecedor().getEndereco().getEstado());
        //item
        for (int i = 0; i < pedido.getItens().size(); i++) {
            Assert.assertEquals(pedido.getItens().get(i).getProduto().getNome(), pedidoBuscado.getItens().get(i).getProduto().getNome());
            Assert.assertEquals(pedido.getItens().get(i).getProduto().getDescricao(), pedidoBuscado.getItens().get(i).getProduto().getDescricao());
            Assert.assertEquals(pedido.getItens().get(i).getProduto().getValorUnitario(), pedidoBuscado.getItens().get(i).getProduto().getValorUnitario());
        }
        //pedido
        Assert.assertEquals(pedido.getValorFrete(), pedidoBuscado.getValorFrete());
    }
    @Test
    public void deveBuscarTodosOsPedidos() {
        Item item1 = new Item(produtest, 4);
        Pedido pedido = new Pedido(LocalDateTime.now(), fornetest, clientest, 50.30, item1);
        pedido.adicionarItem(item1);
        pedidoDAO.adicionar(pedido);
        var pedidosBuscados = pedidoDAO.buscarTodos();
        Assert.assertEquals(2, pedidosBuscados.size());
    }
}

