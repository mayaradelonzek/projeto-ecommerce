public class Cliente extends Pessoa {
    private String nome;
    private String cpf;

    public Cliente(Contato contato, Endereco endereco, String nome, String cpf) {
        super(contato, endereco);
        this.nome = nome;
        this.cpf = cpf;
        validar();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void validar() {
        if (this.nome == null || this.nome.isBlank()) {
            mensagem.add("O nome deve ser informado.");
        }

        if (this.cpf == null || this.cpf.isBlank()) {
            mensagem.add("O cpf deve ser informado.");
        }

        if (this.contato == null) {
            mensagem.add("O contato deve ser informado.");
        }

        if (this.endereco == null) {
            mensagem.add("O endereco deve ser informado.");
        }
    }
}
