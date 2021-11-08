import org.junit.Assert;
import org.junit.Test;

public class FornecedorTest {

    @Test
    public void deveCriarUmFornecedorComSucesso() {
        Contato contato = new Contato("fornecedor@dor.com", "555555555");
        Endereco endereco = new Endereco("Rua Forne", "555", "Testeira", "Testing", "90600000", "Testando", "TS");
        Fornecedor fornecedor = new Fornecedor(contato, endereco, "Fornecedor SA", "3333000150");

        Assert.assertNotNull(contato);
        Assert.assertNotNull(endereco);
        Assert.assertEquals("Fornecedor SA", fornecedor.getNomeFantasia());
        Assert.assertEquals("3333000150", fornecedor.getCnpj());
    }

    @Test
    public void deveValidarUmFornecedorComCamposNulos() {
        try {
            Fornecedor fornecedor = new Fornecedor(null, null, "", "");
        } catch (Exception e) {
            String mensagem = "[O nomeFantasia deve ser informado., O cnpj deve ser informado., O contato deve ser contato informado., O endereco deve ser informado.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }

    @Test
    public void deveValidarFornecedorComTamanhoDeCamposInvalidos() {
        try {
            Helper helper = new Helper();
            String tamanhoInvalido = helper.gerarString(101);
            Contato contato = new Contato("fornecedor@dor.com", "555555555");
            Endereco endereco = new Endereco("Rua Forne", "555", "Testeira", "Testing", "90600000", "Testando", "TS");
            Fornecedor fornecedor = new Fornecedor(contato, endereco, tamanhoInvalido, tamanhoInvalido);

        } catch (Exception e) {
            String mensagemTamanhoInvalido = "[Tamanho do campo nomeFantasia invalido., Tamanho do campo cnpj invalido.]";
            Assert.assertEquals(mensagemTamanhoInvalido, e.getMessage());
        }
    }
}
