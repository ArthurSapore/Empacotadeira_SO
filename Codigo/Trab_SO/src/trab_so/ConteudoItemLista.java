package trab_so;
public class ConteudoItemLista {
    /**
     * ConteudoItemLista é uma classe com o que está contido dentro de um ItemLista, que é um item da classe Lista
     */
    /**
     * Atributo do tipo Pedido, com informações da classe, como nome do cliente, quantidade de produtos e prazo
     */
    public Pedido pedido;
    /**
     * Construtor da classe ConteudoItemLista
     * @param pedido Pedido contendo o nome do cliente, quantidade de produtos e prazo
     */
    public ConteudoItemLista(Pedido pedido){
        this.pedido = pedido;
    }
    /**
     * Retorna informações do Pedido
     * @return Nome do cliente, quantide de produtos do pedido realizado e prazo (0 se não houver)
     */
    @Override
    public String toString(){
        return pedido.getCliente().getNome() + ";" + pedido.getCliente().getQtdeProduto()+ ";" + pedido.getCliente().getPrazo();
    }
}
