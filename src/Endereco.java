import java.util.ArrayList;
import java.util.List;

public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(String rua, String numero, String bairro, String complemento, String cep, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        validar();
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    protected List<String> validar() {
        List<String> mensagem = new ArrayList<>();

        if (this.rua == null || this.rua.isBlank()) {
            mensagem.add("A rua deve ser informada.");
        } else if (this.rua != null && this.rua.length() > 100) {
            mensagem.add("Tamanho do campo rua invalido.");
        }

        if (this.bairro == null || this.bairro.isBlank()) {
            mensagem.add("O bairro deve ser informado.");
        } else if (this.bairro != null && this.bairro.length() > 50) {
            mensagem.add("Tamanho do campo bairro invalido.");
        }

        if (this.cep == null || this.cep.isBlank()) {
            mensagem.add("O cep deve ser informado.");
        } else if (this.cep != null && this.cep.length() > 10) {
            mensagem.add("Tamanho do campo cep invalido.");
        }

        if (this.cidade == null || this.cidade.isBlank()) {
            mensagem.add("A cidade deve ser informada.");
        } else if (this.cidade != null && this.cidade.length() > 50) {
            mensagem.add("Tamanho do campo cidade invalido.");
        }

        if (this.estado == null || this.estado.isBlank()) {
            mensagem.add("O estado deve ser informado.");
        } else if (this.estado != null && this.estado.length() > 2) {
            mensagem.add("Tamanho do campo estado invalido.");
        }

        if (this.numero.length() > 6) {
            mensagem.add("Tamanho do campo numero invalido.");
        }

        if (this.complemento.length() > 120) {
            mensagem.add("Tamanho do campo complemento invalido.");
        }
        return mensagem;
    }
}
