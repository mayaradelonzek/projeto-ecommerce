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

    protected void validar() {
        if (this.nome == null || this.nome.isBlank()) {
            mensagem.add("O nome deve ser informado.");
        } else if (this.nome != null && this.nome.length() > 100) {
            mensagem.add("Tamanho do campo nome invalido.");
        }

        if (this.cpf == null || this.cpf.isBlank()) {
            mensagem.add("O cpf deve ser informado.");
        } else if (this.cpf != null && this.cpf.length() > 20) {
            mensagem.add("Tamanho do campo cpf invalido.");
        }

        mensagem.addAll(getEndereco().validar());
        mensagem.addAll(getContato().validar());


//        if (this.contato == null) {
//            mensagem.add("O contato deve ser informado.");
//        }
//
//        if (this.endereco == null) {
//            mensagem.add("O endereco deve ser informado.");
//        }

        if (!mensagem.isEmpty()) {
            throw new IllegalArgumentException(mensagem.toString());
        }
    }
}
