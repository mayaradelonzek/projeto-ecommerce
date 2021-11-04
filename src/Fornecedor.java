public class Fornecedor extends Pessoa {
    private String nomeFantasia;
    private String cnpj;

    public Fornecedor(Contato contato, Endereco endereco, String nomeFantasia, String cnpj) {
        super(contato, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
}
