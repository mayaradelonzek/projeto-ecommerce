import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void deveCriarClienteComSucesso() {
        Contato contato = new Contato("testerson@teste.com", "555555555");
        Endereco endereco = new Endereco("Rua teste", "666", "Testeira", "Testing", "90600000", "Testando", "TS");
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
            String mensagem = "[O email deve ser informado., O telefone deve ser informado., A rua deve ser informada., O bairro deve ser informado., O cep deve ser informado., A cidade deve ser informada., O estado deve ser informado., O nome deve ser informado., O cpf deve ser informado.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }
}
