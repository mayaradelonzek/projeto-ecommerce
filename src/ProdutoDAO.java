import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO() {
        this.conexao = ConexaoBanco.getConnection();
    }

    public void adicionar(Produto produto) {

        try {
            String sql = "INSERT INTO produto (nome, descricao, valorUnitario) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setDouble(3, produto.getValorUnitario());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
