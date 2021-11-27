import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FornecedorDAO implements GenericDAO<Fornecedor, Integer>{
    private Connection conexao;

    public FornecedorDAO() {
        this.conexao = ConexaoBanco.getConnection();
    }

    @Override
    public void adicionar(Fornecedor model) {
        try {
            boolean existeFornecedor = this.existeFornecedor(model.getCnpj(), model.getNomeFantasia());
            if (existeFornecedor) {
                throw new IllegalArgumentException("Fornecedor ja cadastrado");
            }

            String sql = "insert into fornecedor (nomeFantasia, cnpj, email, telefone, rua, numero, bairro, complemento, cep, cidade, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, model.getNomeFantasia());
            preparedStatement.setString(2, model.getCnpj());
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
    public List<Fornecedor> buscarTodos() {
        return null;
    }

    @Override
    public Fornecedor buscarPorId(Integer id) {
        return null;
    }

    private boolean existeFornecedor(String cnpj, String nomeFantasia) {
        try {
            String sql = "select * from fornecedor f where f.cnpj = ? and f.nomeFantasia = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cnpj);
            preparedStatement.setString(2, nomeFantasia);
            ResultSet results = preparedStatement.executeQuery();
            return results.next();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarTodos() {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM fornecedor");
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
