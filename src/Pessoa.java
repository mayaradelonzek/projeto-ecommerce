import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    protected Contato contato;
    protected Endereco endereco;
    protected int id;
    protected List<String> mensagem = new ArrayList<>();

    public Pessoa(Contato contato, Endereco endereco) {
        this.contato = contato;
        this.endereco = endereco;
    }

    public Pessoa(Contato contato, Endereco endereco, int id) {
        this(contato, endereco);
        this.id = id;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getId() {
        return id;
    }

    protected abstract void validar();
}
