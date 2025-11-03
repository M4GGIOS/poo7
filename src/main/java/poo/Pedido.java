package poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate data;
    private StatusPedidos status;
    private List<ItemPedido> itens = new ArrayList<>();
    private Cliente cliente;
    private IPagamento metodoPagamento;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.status = StatusPedidos.PENDENTE;
    }

    private StatusPedidos statusPedido = StatusPedidos.PENDENTE;

    public StatusPedidos getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedidos statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public IPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    } 

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.subtotal();
        }
        return total;
    }
   
    public boolean processarPagamento() {
        double valor = calcularTotal();
        if (metodoPagamento != null) {
            boolean sucesso = metodoPagamento.processarPagamento(valor);

            if (sucesso) {
                statusPedido = StatusPedidos.PROCESSANDO;
            } else {
                statusPedido = StatusPedidos.PENDENTE;
            }
            return sucesso;
        }
        return false;
    }

    public void exibiritens() {
        System.out.println("Cliente: " + this.cliente.getNome() + "\n");
        for (ItemPedido item : itens) {
            System.out.println("Nome: " + item.getProduto().getNome());
            System.out.println("Preço: R$ " + item.getProduto().getPreco());
            System.out.println("Quantidade: " + item.getquantidade());
            System.out.println("");
        }
    }
}
