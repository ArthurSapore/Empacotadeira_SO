package trab_so;
public class Esteira {
    /**
     * Armazena o tempo de saida da van, a loja abre as 08:00 e a van sai 12:00, 4 horas em segundos é igual a 14400
     */
    private final int tempoSaidaVan = 14400;
    /**
     * Quantidade de pacotes embalados antes da saída da van
     */
    private int qtdPacoteEmbaladoAntesVan = 0;
    /**
     * Tempo que a esteira permanece ligada
     */
    private double contadorTempo = 0;
    /**
     * Atributo do tipo Pedido, com informações da classe, como nome do cliente, quantidade de produtos e prazo
     */
    private Pedido pedido;
    /**
     * Quantidade de pacotes do pedido
     */
    private int qtdePacote;
    /**
     * Tempo em segundos para o pedido
     */
    private double tempoSeg;
    /**
     * Empacota o pedido, ou seja, os produtos contidos no pacote, atualizando os tempos de retorno e tempo que a esteira fica ligada
     * @param pedido Pedido que virá a ser empacotado
     */
    public void Empacotar(Pedido pedido){
        this.pedido = pedido;
        double totalPacote = (double) this.pedido.getCliente().getQtdeProduto()/20;
        this.qtdePacote = (int) Math.ceil(totalPacote);
        int tempoPacote = 5 * this.qtdePacote;
        double tempoTransicao = this.qtdePacote * 0.5;
        this.tempoSeg = tempoPacote + tempoTransicao;
        this.contadorTempo += this.tempoSeg; // soma o tempo transcorrido com o tempo do pacote atual e atribui ao contador
        pedido.setTempoRetorno(this.contadorTempo);// seta no pedido o tempo de retorno
        contadorPctAntesVan();
    }
    /**
     * Tempo que a esteira ficou ligada
     * @return Contador de tempo que a esteira ficou ligada
     */
    public double getContadorTempo() {
        return contadorTempo;
    }
    /**
     * Atribui a variavel contadorTempo o tempo que a esteira ficou ligada
     * @param contadorTempo Tempo que a esteira ficou ligada
     */
    public void setContadorTempo(double contadorTempo) {
        this.contadorTempo = contadorTempo;
    }
    /**
     * Atualiza a quantidade de pacotes embalados antes da saída da van
     */
    private void contadorPctAntesVan () {
    	if(this.contadorTempo <=tempoSaidaVan) {
            this.setQtdPacoteEmbaladoAntesVan(this.getQtdPacoteEmbaladoAntesVan() + qtdePacote);
    	}
    }
    /**
     * Quantidade de pacotes do pedido
     * @return Quantidade de pacotes
     */
    public int getQtdePacote() {
        return qtdePacote;
    }
    /**
     * Atribui a quantidade de pacotes do pedido a variavel qtdePacote
     * @param qtdePacote Quantidade de pacotes do pedido
     */
    public void setQtdePacote(int qtdePacote) {
        this.qtdePacote = qtdePacote;
    }
    /**
     * Retorna o pedido
     * @return Pedido, trás o pedido
     */
    public Pedido getPedido() {
        return this.pedido;
    }
    /**
     * Atribui um pedido a variavel pedido, contendo informações como o cliente e tempo de retorno
     * @param pedido Pedido que contém os produos a serem empacotados
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    /**
     * Tempo de embalagem de produtos de um pedido
     * @return Tempo em segundos gastos para embalar os produtos de um pedido
     */
    public double getTempoSeg() {
        return tempoSeg;
    }
    /**
     * Atribui a variavel tempoSeg o tempo em segundos gastos para embalar os produtos de um pedido
     * @param tempoSeg Tempo em segundos gastos para embalar os produtos de um pedido
     */
    public void setTempoSeg(int tempoSeg) {
        this.tempoSeg = tempoSeg;
    }
    /**
     * Retorna a quantidade de pacotes embalados antes da saída da van
     * @return Quantidade de pacotes embalados antes da saída da van
     */
    public int getQtdPacoteEmbaladoAntesVan() {
        return qtdPacoteEmbaladoAntesVan;
    }
    /**
     * Atribui a variavel qtdPacoteEmbaladoAntesVan a quantidade de pacotes embalados antes da saída da van
     * @param qtdPacoteEmbaladoAntesVan  Quantidade de pacotes embalados antes da saída da van
     */
    public void setQtdPacoteEmbaladoAntesVan(int qtdPacoteEmbaladoAntesVan) {
            this.qtdPacoteEmbaladoAntesVan = qtdPacoteEmbaladoAntesVan;
    }
}
