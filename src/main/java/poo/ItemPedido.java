package poo;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoUni;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setProduto() {
        this.produto = produto;
    }

    public void setQuantidade() {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public int getquantidade() {
        return this.quantidade;
    }

    public void setPrecoUni() {
        this.precoUni = precoUni;
    }

    public double getPrecoUni() {
        return this.precoUni;
    }

    public double subtotal() {
        return produto.getPreco() * quantidade;
    }

}
