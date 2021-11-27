import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente, Integer>{

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = ConexaoBanco.getConnection();
    }

    @Override
    public void adicionar(Cliente model) {
        try {
            boolean existeCliente = this.existeCliente(model.getCpf(), model.getNome());
            if (existeCliente) {
                throw new IllegalArgumentException("Cliente ja cadastrado");
            }

            String sql = "insert into cliente (nome, cpf, email, telefone, rua, numero, bairro, complemento, cep, cidade, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, model.getNome());
            preparedStatement.setString(2, model.getCpf());
            preparedStatement.setString(3, model.getContato().getEmail());
            preparedStatement.setString(4, model.getContato().getTelefone());
            preparedStatement.setString(5, model.getEndereco().getRua());
            preparedStatement.setString(6, model.getEndereco().getNumero());
            preparedStatement.setString(7, model.getEndereco().getBairro());
            preparedStatement.setString(8, model.getEndereco().getComplemento());
            preparedStatement.setString(9, model.getEndereco().getCep());
            preparedStatement.setString(10, model.getEndereco().getCidade());
            preparedStatement.setString(11, model.getEndereco().getEstado());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> clientesCadastrados = new ArrayList<Cliente>();

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from cliente");
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                String nome = results.getString("nome");
                String cpf = results.getString("cpf");
                String email = results.getString("email");
                String telefone = results.getString("telefone");
                String rua = results.getString("rua");;
                String numero = results.getString("numero");;
                String bairro = results.getString("bairro");
                String complemento = results.getString("complemento");
                String cep = results.getString("cep");
                String cidade = results.getString("cidade");
                String estado = results.getString("estado");

                Contato contato = new Contato(email, telefone);
                Endereco endereco = new Endereco(rua, numero, bairro, complemento, cep, cidade, estado);
                Cliente cliente = new Cliente(contato, endereco, nome, cpf);
                clientesCadastrados.add(cliente);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientesCadastrados;
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return null;
    }

    private boolean existeCliente(String cpf, String nome) {
        try {
            String sql = "select * from cliente c where c.cpf = ? and c.nome = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, nome);
            ResultSet results = preparedStatement.executeQuery();
            return results.next();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarTodos() {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM cliente");
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
