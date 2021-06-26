package trab_so;

import java.util.ArrayList;
import java.util.List;

public class Cliente{
 
    public String nome;

    private Pedido pedido;

    public Cliente(String nome, int qtdeProduto, int prazo) {
        this.nome = nome;
        this.pedido = new Pedido(qtdeProduto, prazo);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    @Override
    public String toString(){
        return "Cliente: " + this.nome + " quantide de produtos do pedido: " + this.pedido.getQtdeProduto() + " prazo do pedido: " + this.pedido.getPrazo()+"\n"; 
    }
}
