import org.junit.Assert;
import org.junit.Test;

public class EnderecoTest {

    @Test
    public void deveCriarUmEnderecoComSucesso() {
        Endereco endereco = new Endereco("Rua Teste", "100", "Testando", "Testing", "1234567891", "Testadinha", "TS");

        Assert.assertEquals("Rua Teste", endereco.getRua());
        Assert.assertEquals("100", endereco.getNumero());
        Assert.assertEquals("Testing", endereco.getComplemento());
        Assert.assertEquals("1234567891", endereco.getCep());
        Assert.assertEquals("Testadinha", endereco.getCidade());
        Assert.assertEquals("TS", endereco.getEstado());
    }

    @Test
    public void deveValidarEnderecoComCamposNulos() {
        try {
            Endereco endereco = new Endereco("", "", "", "Testing", "", "", "");
        } catch (Exception e) {
            String mensagem = "[A rua deve ser informada., O bairro deve ser informado., O cep deve ser informado., A cidade deve ser informada., O estado deve ser informado.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }

    @Test
    public void deveValidarEnderecoComTamanhoDeCamposInvalidos() {
        try {
            Helper helper = new Helper();
            String tamanhoInvalido = helper.gerarString(121);
            Endereco endereco = new Endereco(tamanhoInvalido, tamanhoInvalido, tamanhoInvalido, tamanhoInvalido, tamanhoInvalido, tamanhoInvalido, tamanhoInvalido);
        } catch (Exception e) {
            String mensagem = "[Tamanho do campo rua invalido., Tamanho do campo bairro invalido., Tamanho do campo cep invalido., Tamanho do campo cidade invalido., Tamanho do campo estado invalido., Tamanho do campo numero invalido., Tamanho do campo complemento invalido.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }
}
