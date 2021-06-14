package trab_so;
public class Cliente {
    /**
     * Nome do cliente
     */
    public String nome;
    /**
     * Quantidade de produtos do pedido
     */
    public int qtdeProduto;
    /**
     * Prazo (em minutos) do pedido
     */
    public int prazo;
    /**
     * Construtor da classe Cliente
     * @param nome Nome do cliente
     * @param qtdeProduto Quantidade de produtos do pedido
     * @param prazoMin Prazo em minutos para o pedido (0 se não houver prazo)
     */
    public Cliente(String nome, int qtdeProduto, int prazoMin){
        this.nome = nome;
        this.qtdeProduto = qtdeProduto;
        if(prazoMin == 0){
            this.prazo = 1000;
        }else{
            this.prazo = prazoMin;
        }
    }
    /**
     * Retorna o nome do cliente
     * @return Nome do cliente 
     */
    public String getNome() { return nome; }
    /**
     * Atribui a variavel nome ao cliente
     * @param nome Nome do cliente
     */
    public void setNome(String nome) { this.nome = nome; }
    /**
     * Retorna a quantidade de produtos do pedido realizado
     * @return Quantidade de produtos do pedido
     */
    public int getQtdeProduto() { return qtdeProduto; }
    /**
     * Atribui a variavel qtdeProduto o numero de produtos do pedido
     * @param qtdeProduto Quantidade de produtos do pedido
     */
    public void setQtdeProduto(int qtdeProduto) { this.qtdeProduto = qtdeProduto; }
    /**
     * Retorna o prazo em minutos do pedido (0 se não houver prazo)
     * @return Prazo do pedido em minutos (0 se não houver prazo)
     */
    public int getPrazo() { return prazo; }
    /**
     * Atribui a variavel prazo o tempo em minutos para o pedido
     * @param prazo Prazo em minutos do pedido (0 se não houver)
     */
    public void setPrazo(int prazo) { this.prazo = prazo; }
    /**
     * Retorna informações do Cliente
     * @return Texto contendo o nome, quantide de produtos e prazo do pedido
     */
    @Override
    public String toString(){ return "Cliente: " + this.nome + " quantide de produtos do pedido: " + this.qtdeProduto + " prazo do pedido: " + this.prazo; }
}
