public class Fornecedor extends Pessoa {
    private String nomeFantasia;
    private String cnpj;

    public Fornecedor(Contato contato, Endereco endereco, String nomeFantasia, String cnpj) {
        super(contato, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        validar();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void validar() {
        if (this.nomeFantasia == null || this.nomeFantasia.isBlank()) {
            mensagem.add("O nomeFantasia deve ser informado.");
        }

        if (this.cnpj == null || this.cnpj.isBlank()) {
            mensagem.add("O cnpj deve ser informado.");
        }

        if (this.contato == null) {
            mensagem.add("O contato deve ser informado.");
        }

        if (this.endereco == null) {
            mensagem.add("O endereco deve ser informado.");
        }
    }
}
