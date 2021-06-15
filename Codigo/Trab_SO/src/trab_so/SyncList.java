package trab_so;

import java.util.LinkedList;
import java.util.List;

public class SyncList {
    /**
     * Lista de Pedidos
     */
    private List<Pedido> listaPedidos;


    public SyncList (){
        this.listaPedidos = new LinkedList<Pedido>();
    }

    /**
     * Adiciona um novo pedido no final da lista de forma sincronizada
     * @param pedido - Pedido
     */
    public synchronized void add(Pedido pedido){
        this.listaPedidos.add(pedido);
    }

    /**
     * Remove um pedido do início da lista
     * @param pos - Posição do pedido para ser removido
     * @return - Retorna o pedido removido
     */
    public synchronized Pedido removePedido(int pos){
        Pedido pedido = this.listaPedidos.remove(pos);
        return pedido;
    }

    /**
     * Verifica o tamanho da lista
     * @return - tamanho da lista
     */
    public synchronized int sizeList(){
        return this.listaPedidos.size();
    }

    /**
     * Retorna um pedido de uma posição específica
     * @param pos - Posição do pedido para ser retornado
     * @return - Pedido
     */
    public synchronized Pedido getPedido(int pos){
        return this.listaPedidos.get(pos);
    }

    /**
     * Copia os dados da lista para um array
     * @return Array de pedidos
     */
    public synchronized Pedido[] toArray(){
        int tamListaPedidos = this.listaPedidos.size();
        Pedido [] arrayPedidos = new Pedido[tamListaPedidos];
        for (int i = 0; i<tamListaPedidos; i++){
            arrayPedidos[i] = this.listaPedidos.get(i);
        }
        return arrayPedidos;
    }

    /**
     * Adiciona um pedido em uma posição específica
     * @param i - Posição onde o pedido será adicionado
     * @param pedido - Pedido
     */
    public synchronized void addPosicao(int i, Pedido pedido){
        this.listaPedidos.add(i, pedido);
    }

}
