import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDateTime dateCompra;
    private Fornecedor fornecedor;
    private Cliente cliente;
    private Double valorFrete;
    private List<Item> itens = new ArrayList<>();

    public Pedido(LocalDateTime dateCompra, Fornecedor fornecedor, Cliente cliente, Double valorFrete, Item item) {
        this.dateCompra = dateCompra;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
        this.valorFrete = valorFrete;
        adicionarItem(item);
        validar();
    }

    public LocalDateTime getDateCompra() {
        return dateCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public Double getValorTotal() {
        return getValorTotalItens() + getValorFrete();
    }

    public Double getValorTotalItens() {
        double valorTotal = 0;
        for (Item item : itens) {
            valorTotal += item.getValorTotalItem();
        }
        return valorTotal;
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            return;
        }
        this.itens.add(item);
    }

    public void validar() {
        List<String> mensagem = new ArrayList<>();
        if (this.dateCompra == null) {
            mensagem.add("A data deve ser informada.");
        }

        if (this.fornecedor == null) {
            mensagem.add("O fornecedor deve ser informado");
        }

        if (this.cliente == null) {
            mensagem.add("O cliente deve ser informado.");
        }

        if (this.valorFrete == null) {
            mensagem.add("O valor do frete deve ser informado.");
        } else if (this.valorFrete != null && this.valorFrete < 0) {
            mensagem.add("O valor do frete nao pode ser negativo.");
        }

        if (itens.isEmpty()) {
            mensagem.add("Adicione pelo menos um item.");
        }

        if (!mensagem.isEmpty()) {
            throw new IllegalArgumentException(mensagem.toString());
        }
    }
}
