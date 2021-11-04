import java.util.ArrayList;
import java.util.List;

public class Contato {
    private String email;
    private String telefone;
    private List<String> mensagem = new ArrayList<>();

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
        validar();
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void validar() {
        if (this.email == null || this.email.isBlank()) {
            mensagem.add("O email deve ser informado.");
        }

        if (this.telefone == null || this.telefone.isBlank()) {
            mensagem.add("O telefone deve ser informado.");
        }
    }
}
