import java.util.ArrayList;
import java.util.List;

public class Contato {
    private String email;
    private String telefone;

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

    protected List<String> validar() {
        List<String> mensagem = new ArrayList<>();

        if (this.email == null || this.email.isBlank()) {
            mensagem.add("O email deve ser informado.");
        } else if (this.email != null && this.email.length() > 100) {
            mensagem.add("Tamanho do campo email invalido.");
        }

        if (this.telefone == null || this.telefone.isBlank()) {
            mensagem.add("O telefone deve ser informado.");
        } else if (this.telefone != null && this.telefone.length() > 20) {
            mensagem.add("Tamanho do campo telefone invalido.");
        }

        return mensagem;
    }
}
