import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void deveCriarClienteComSucesso() {
        Contato contato = new Contato("testerson@teste.com", "555555555");
        Endereco endereco = new Endereco("Rua teste", "444", "Testeira", "Testing", "90600000", "Testando", "TS");
        Cliente testerson = new Cliente(contato, endereco, "Testerson", "12345678910");

        Assert.assertNotNull(contato);
        Assert.assertNotNull(endereco);
        Assert.assertEquals("Testerson", testerson.getNome());
        Assert.assertEquals("12345678910", testerson.getCpf());
    }

    @Test
    public void deveValidarClienteComCamposNulos() {
        try {
            Cliente testerson = new Cliente(null, null, "", "");

        } catch (Exception e) {
            String mensagem = "[O nome deve ser informado., O cpf deve ser informado., O contato deve ser informado., O endereco deve ser informado.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }

    @Test
    public void deveValidarClienteComTamanhoDeCamposInvalidos() {
        try {
            Helper helper = new Helper();
            String tamanhoInvalido = helper.gerarString(101);
            Contato contato = new Contato("testerson@teste.com", "555555555");
            Endereco endereco = new Endereco("Rua teste", "444", "Testeira", "Testing", "90600000", "Testando", "TS");
            Cliente testerson = new Cliente(contato, endereco, tamanhoInvalido, tamanhoInvalido);

        } catch (Exception e) {
            String mensagemTamanhoInvalido = "[Tamanho do campo nome invalido., Tamanho do campo cpf invalido.]";
            Assert.assertEquals(mensagemTamanhoInvalido, e.getMessage());
        }
    }
}
