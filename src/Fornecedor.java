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
        } else if (this.nomeFantasia != null && this.nomeFantasia.length() > 100) {
            mensagem.add("Tamanho do campo nomeFantasia invalido.");
        }

        if (this.cnpj == null || this.cnpj.isBlank()) {
            mensagem.add("O cnpj deve ser informado.");
        } else if (this.cnpj != null && this.cnpj.length() > 20) {
            mensagem.add("Tamanho do campo cnpj invalido.");
        }

        if (this.contato == null) {
            mensagem.add("O contato deve ser contato informado.");
        }

        if (this.endereco == null) {
            mensagem.add("O endereco deve ser endereco informado.");
        }

        if (!mensagem.isEmpty()) {
            throw new IllegalArgumentException(mensagem.toString());
        }
    }
}
