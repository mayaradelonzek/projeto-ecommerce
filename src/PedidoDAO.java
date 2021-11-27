import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private Connection conexao;

    public PedidoDAO() {
        this.conexao = ConexaoBanco.getConnection();
    }

    public void adicionar(Pedido pedido) {
        try {
            String sql = "INSERT INTO pedido (dataCompra, id_fornecedor, id_cliente, valorTotalItens, valorFrete) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(pedido.getDateCompra()));
            preparedStatement.setInt(2, pedido.getFornecedor().getId());
            preparedStatement.setInt(3, pedido.getCliente().getId());
            preparedStatement.setDouble(4, pedido.getValorTotalItens());
            preparedStatement.setDouble(5, pedido.getValorFrete());
            preparedStatement.execute();

            long idPedido = 0;
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idPedido = generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Falha ao criar usuário. Nao foi possivel encontrar um id.");
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

            for (Item item : pedido.getItens()) {

                try {

                    String sql2 = "INSERT INTO item (id_produto, id_pedido, quantidade) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement2 = conexao.prepareStatement(sql2);
                    preparedStatement2.setInt(1, item.getProduto().getId());
                    preparedStatement2.setLong(2, idPedido);
                    preparedStatement2.setInt(3, item.getQuantidade());
                    preparedStatement2.execute();

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Pedido> buscarTodos() {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            String sql = "select * from pedido p " +
                    "inner join fornecedor f on f.id_fornecedor = p.id_fornecedor " +
                    "inner join cliente c on c.id_cliente = p.id_cliente " +
                    "inner join item i on i.id_pedido = p.id_pedido " +
                    "inner join produto pr on pr.id_produto = i.id_produto";

            Statement preparedStatement = conexao.createStatement();
            ResultSet result = preparedStatement.executeQuery(sql);

            List<Item> itens = new ArrayList<>();
            LocalDateTime dateCompra = null;
            double valorFrete = 0;
            double valorTotalItens = 0;
            Cliente cliente = null;
            Fornecedor fornecedor = null;

            while (result.next()) {
                dateCompra = result.getObject("dataCompra", LocalDateTime.class);
                valorFrete = result.getDouble("valorFrete");
                valorTotalItens = result.getDouble("valorTotalItens");

                var nomeFantasia = result.getString("nomeFantasia");
                var cnpj = result.getString("cnpj");
                var emailFornecedor = result.getString("email");
                var telefoneFornecedor = result.getString("telefone");
                var ruaFornecedor = result.getString("rua");
                var numeroFornecedor = result.getString("numero");
                var bairroFornecedor = result.getString("bairro");
                var complementoFornecedor = result.getString("complemento");
                var cepFornecedor = result.getString("cep");
                var cidadeFornecedor = result.getString("cidade");
                var estadoFornecedor = result.getString("estado");

                var nomeCliente = result.getString("nome");
                var cpf = result.getString("cpf");
                var emailCliente = result.getString("email");
                var telefoneCliente = result.getString("telefone");
                var ruaCliente = result.getString("rua");
                var numeroCliente = result.getString("numero");
                var bairroCliente = result.getString("bairro");
                var complementoCliente = result.getString("complemento");
                var cepCliente = result.getString("cep");
                var cidadeCliente = result.getString("cidade");
                var estadoCliente = result.getString("estado");

                Contato contatoFornecedor = new Contato(emailFornecedor, telefoneFornecedor);
                Endereco enderecoFornecedor = new Endereco(ruaFornecedor, numeroFornecedor, bairroFornecedor, complementoFornecedor, cepFornecedor, cidadeFornecedor, estadoFornecedor);
                fornecedor = new Fornecedor(contatoFornecedor, enderecoFornecedor, nomeFantasia, cnpj);

                Contato contatoCliente = new Contato(emailCliente, telefoneCliente);
                Endereco enderecoCliente = new Endereco(ruaCliente, numeroCliente, bairroCliente, complementoCliente, cepCliente, cidadeCliente, estadoCliente);
                cliente = new Cliente(contatoCliente, enderecoCliente, nomeCliente, cpf);

                var nomeProduto = result.getString("nome");
                var descricaoProduto = result.getString("descricao");
                var valorUnitario = result.getDouble("valorUnitario");
                Produto produto = new Produto(nomeProduto, descricaoProduto, valorUnitario);

                var quantidade = result.getInt("quantidade");
                Item item = new Item(produto, quantidade);
                itens.add(item);

                pedidos.add(new Pedido(dateCompra, fornecedor, cliente, valorFrete, itens));
            }


        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
        }

        if (pedidos.isEmpty()) {

            throw new IllegalArgumentException("Nenhum pedido foi encontrado");
        }
        return pedidos;
    }

    public Pedido buscarPorId(int id) {
        try {
            String sql = "select * from pedido p " +
                    "inner join fornecedor f on f.id_fornecedor = p.id_fornecedor " +
                    "inner join cliente c on c.id_cliente = p.id_cliente " +
                    "inner join item i on i.id_pedido = p.id_pedido " +
                    "inner join produto pr on pr.id_produto = i.id_produto where p.id_pedido=" + id;

            Statement preparedStatement = conexao.createStatement();
            ResultSet result = preparedStatement.executeQuery(sql);

            List<Item> itens = new ArrayList<>();
            LocalDateTime dateCompra = null;
            double valorFrete = 0;
            double valorTotalItens = 0;
            Cliente cliente = null;
            Fornecedor fornecedor = null;

            while (result.next()) {
                dateCompra = result.getObject("dataCompra", LocalDateTime.class);
                valorFrete = result.getDouble("valorFrete");
                valorTotalItens = result.getDouble("valorTotalItens");

                var nomeFantasia = result.getString("nomeFantasia");
                var cnpj = result.getString("cnpj");
                var emailFornecedor = result.getString("email");
                var telefoneFornecedor = result.getString("telefone");
                var ruaFornecedor = result.getString("rua");
                var numeroFornecedor = result.getString("numero");
                var bairroFornecedor = result.getString("bairro");
                var complementoFornecedor = result.getString("complemento");
                var cepFornecedor = result.getString("cep");
                var cidadeFornecedor = result.getString("cidade");
                var estadoFornecedor = result.getString("estado");

                var nomeCliente = result.getString("nome");
                var cpf = result.getString("cpf");
                var emailCliente = result.getString("email");
                var telefoneCliente = result.getString("telefone");
                var ruaCliente = result.getString("rua");
                var numeroCliente = result.getString("numero");
                var bairroCliente = result.getString("bairro");
                var complementoCliente = result.getString("complemento");
                var cepCliente = result.getString("cep");
                var cidadeCliente = result.getString("cidade");
                var estadoCliente = result.getString("estado");

                Contato contatoFornecedor = new Contato(emailFornecedor, telefoneFornecedor);
                Endereco enderecoFornecedor = new Endereco(ruaFornecedor, numeroFornecedor, bairroFornecedor, complementoFornecedor, cepFornecedor, cidadeFornecedor, estadoFornecedor);
                fornecedor = new Fornecedor(contatoFornecedor, enderecoFornecedor, nomeFantasia, cnpj);

                Contato contatoCliente = new Contato(emailCliente, telefoneCliente);
                Endereco enderecoCliente = new Endereco(ruaCliente, numeroCliente, bairroCliente, complementoCliente, cepCliente, cidadeCliente, estadoCliente);
                cliente = new Cliente(contatoCliente, enderecoCliente, nomeCliente, cpf);

                var nomeProduto = result.getString("pr.nome");
                var descricaoProduto = result.getString("descricao");
                var valorUnitario = result.getDouble("valorUnitario");
                Produto produto = new Produto(nomeProduto, descricaoProduto, valorUnitario);

                var quantidade = result.getInt("quantidade");
                Item item = new Item(produto, quantidade);
                itens.add(item);

            }
            return new Pedido(dateCompra, fornecedor, cliente, valorFrete, itens);

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
        }
        throw  new IllegalArgumentException("Pedido nao encontrado");
    }

    public void deletar() {
        try {
            List<String> sqlStrings = new ArrayList<>();
            sqlStrings.add("truncate cliente");
            sqlStrings.add("truncate fornecedor");
            sqlStrings.add("truncate produto");
            sqlStrings.add("truncate item");
            sqlStrings.add("truncate pedido");

            for (String sql : sqlStrings) {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
