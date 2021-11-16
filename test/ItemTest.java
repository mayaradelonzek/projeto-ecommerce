import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void deveCriarUmItemComSucesso() {
        Produto produto = new Produto("Calculadora", "cientifica casio", 119.90);
        Item item = new Item(produto, 2);

        Assert.assertEquals(produto, item.getProduto());
        Assert.assertEquals(2, item.getQuantidade());
    }

    @Test
    public void deveValidarItemComCamposNulos() {
        try {
            Item item = new Item(null, 0);
        } catch (Exception e) {
            String mensagem = "[O produto deve ser informado., Necessario adicionar pelo menos um item.]";
            Assert.assertEquals(mensagem, e.getMessage());
        }
    }

    @Test
    public void deveValidarValorTotalDeItens() {
        Produto produto = new Produto("Calculadora", "cientifica casio", 119.90);
        Item item = new Item(produto, 2);

        Assert.assertEquals(239.8, item.getValorTotalItem(), 1);
    }
}
