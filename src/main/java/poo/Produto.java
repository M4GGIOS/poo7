package poo;

public class Produto {

    private String id;
    private String nome;
    private double preco;
    private int estoque;
    private String descricao;

    public Produto(String id ,String nome,double preco, String descricao , int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarEstoque(int qtd) {
        this.estoque = qtd;
    }

}
