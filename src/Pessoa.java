import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    protected Contato contato;
    protected Endereco endereco;
    protected List<String> mensagem = new ArrayList<>();
    protected List<String> validacaoTamanho = new ArrayList<>();

    public Pessoa(Contato contato, Endereco endereco) {
        this.contato = contato;
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    protected abstract void validar();
}
