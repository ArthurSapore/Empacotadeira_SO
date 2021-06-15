package trab_so;

public class Pedido{
    /**
    * Variável do tipo Cliente, que armazena informações relativas a ele, como nome
    */
    private Cliente cliente;
    /**
     * Armazena o tempo de retorno de cada pedido
     */
    private double tempoRetorno;
    /*
     * Construtor da classe Pedido; vincula um cliente ao pedido
     * @param cliente Cliente vinculado ao pedido
     */
    public Pedido(Cliente cliente){
        this.cliente = cliente;
        this.tempoRetorno = 0;
    }
    /**
     * Atribui o tempo de retorno em segundos a variavel tempoRetorno
     * @param tempoRetorno Tempo de retorno em segundos
     */
    public void setTempoRetorno(double tempoRetorno) {
        this.tempoRetorno = tempoRetorno;
    }
    /**
     * Retorna o tempo de retorno do pedido
     * @return Trás o tempo de retorno
     */
    public double getTempoRetorno() {
        return tempoRetorno;
    }
    /**
     * Retorna o cliente do pedido
     * @return Trás o cliente vincuçado ao pedido
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Atribui um cliente ao pedido
     * @param cliente Variavel do tipo cliente, relacionado ao pedido
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}