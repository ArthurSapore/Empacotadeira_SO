package trab_so;

public class Pedido {
    /**
    * Constante que armazena o volume máximo permitido em um único pacote
    */
    private final int MAXVOLUMEPACOTE = 5000;
    /**
    * Constante que armazena o tempo de produção de um pacote, em segundos
    */
    private final int TEMPOPRODUCAO = 5;
    /**
    * Constante que armazena a quantidade máxima de produtos permitidos em um único pacote
    */
    private final int MAXQTDEPRODUTO = 20;
    /**
    * Variável do tipo Cliente, que armazena informações relativas a ele, como nome
    */
    private Cliente cliente;
    /**
     * Armazena o tempo de retorno de cada pedido
     */
    private double tempoRetorno;
    /**
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