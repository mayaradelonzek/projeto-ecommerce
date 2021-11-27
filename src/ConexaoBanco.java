import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static Connection conexao = null;

    static {
        String url = "jdbc:mysql://localhost:3306/projeto_final_lp1";
        String user = "root";
        String pass = "Makw05608!";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private ConexaoBanco() {
    }

    public static Connection getConnection() {
        return conexao;
    }
}
