import java.util.ArrayList;
import java.util.List;

public class Item {
    private Produto produto;
    private int quantidade;
    private Double valorTotalItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        getValorTotalItem();
        validar();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getValorTotalItem() {
        return valorTotalItem = produto.getValorUnitario() * quantidade;
    }

    public void validar() {
        List<String> mensagem = new ArrayList<>();
        if (this.produto == null) {
            mensagem.add("O produto deve ser informado.");
        }

        if (this.quantidade == 0) {
            mensagem.add("A quantidade deve ser informada");
        }
    }
}
