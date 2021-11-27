import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private String descricao;
    private Double valorUnitario;
    private int id;

    public Produto(String nome, String descricao, Double valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        validar();
    }

    public Produto(String nome, String descricao, Double valorUnitario, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.id = id;
        validar();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public int getId() {
        return id;
    }

    public void validar() {
        List<String> mensagem = new ArrayList<>();
        if (this.nome == null || this.nome.isBlank()) {
            mensagem.add("O nome deve ser informado.");
        } else if (this.nome != null && this.nome.length() > 100) {
            mensagem.add("Tamanho do campo nome invalido.");
        }

        if (this.descricao.length() > 500) {
            mensagem.add("Tamanho do campo descricao invalido.");
        }

        if (!mensagem.isEmpty()) {
            throw new IllegalArgumentException(mensagem.toString());
        }
    }
}
