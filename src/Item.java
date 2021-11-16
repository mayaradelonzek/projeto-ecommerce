import java.util.ArrayList;
import java.util.List;

public class Item {
    private Produto produto;
    private int quantidade;
    private Double valorTotalItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        validar();
        this.valorTotalItem = getValorTotalItem();
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

        if (this.quantidade <= 0) {
            mensagem.add("Necessario adicionar pelo menos um item.");
        }

        if (!mensagem.isEmpty()) {
            throw new IllegalArgumentException(mensagem.toString());
        }
    }
}
