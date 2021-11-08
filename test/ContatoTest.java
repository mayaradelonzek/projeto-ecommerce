import org.junit.Assert;
import org.junit.Test;

public class ContatoTest {

    @Test
    public void deveCriarUmContatoComSucesso() {
        Contato contato = new Contato("contato@contato.com", "51999999999");

        Assert.assertEquals("contato@contato.com", contato.getEmail());
        Assert.assertEquals("51999999999", contato.getTelefone());
    }

    @Test
    public void deveValidarContatoComCamposNulos() {
        try {
            Contato contato = new Contato("", "");
        } catch (Exception e) {
            String mensagem = "[O email deve ser informado., O telefone deve ser informado.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }

    @Test
    public void deveValidarContatoComTamanhoDeCamposInvalidos() {
        try {
            Helper helper = new Helper();
            String tamanhoInvalido = helper.gerarString(101);
            Contato contato = new Contato(tamanhoInvalido, tamanhoInvalido);
        } catch (Exception e) {
            String mensagem = "[Tamanho do campo email invalido., Tamanho do campo telefone invalido.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }
}
