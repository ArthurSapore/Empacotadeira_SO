package trab_so;

import java.util.List;

public class Esteira extends Thread{
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
    private double tempoExecucao = 0;
    /**
     * Lista sincronizada de pedidos
     */
    private SyncList listaPedidos;
    /**
     * Quantidade de pacotes do pedido
     */
    private int qtdePacote;
    /**
     * Tempo em segundos para o pedido
     */
    private double tempoProdPacote;

    /**
     * Número de pedidos empacotados pela esteira
     */
    private int numOp;

    /**
     * Tempo total de retorno de pedidos da esteira
     */
    private double tempoTotalRetorno = 0;

    /**
     * Quantidade de pedidos empacotados
     */
    private int quantPedidosEmpacotados = 0;

    /**
     * Quantidade de pedidos que perderam o prazo
     */
    private int qtdePedidosQuePerderamPrazo = 0;
    /**
     * Id da Esteira
     */
    public int id = 0;
    
    /**
     * Construtor
     * @param pedidos - Lista sincronizada de pedidos
     * @param qtdPedidos - Número de pedidos que será empacotados pela esteira
     * @param id - Número identificador da esteira
     */
    public Esteira(SyncList pedidos, int qtdPedidos, int id){
        this.listaPedidos = pedidos;
        this.numOp = qtdPedidos;
        this.id = id;
    }

    /**
     * Método sobrescrito da classe Thread que inicia uma thread, realiza o empacotamento dos produtos dos pedidos
     */
    @Override
    public void run(){
        int count = 0;
        int posRemocao = 0;

        while(count < this.numOp){
            if((this.listaPedidos.sizeList() > 0) && (posRemocao < this.listaPedidos.sizeList())){
                if(this.tempoExecucao /60 >= this.listaPedidos.getPedido(posRemocao).getCliente().horaChegada){
                    Pedido pedido = this.listaPedidos.removePedido(posRemocao);
                    double pacote = (double) pedido.getCliente().getQtdeProduto()/20;
                    this.qtdePacote = (int) Math.ceil(pacote);
                    this.tempoProdPacote = (5 * this.qtdePacote) + (this.qtdePacote * 0.5);
                    this.tempoExecucao += this.tempoProdPacote; 
                    if(pedido.getCliente().getHoraChegada() != 0){
                        pedido.setTempoRetorno(this.tempoExecucao - (pedido.getCliente().getHoraChegada() * 60));
                        this.tempoTotalRetorno += pedido.getTempoRetorno();
                    } else {
                        this.tempoTotalRetorno += this.tempoExecucao;
                    }
                    if(pedido.getCliente().getPrazo() != 10000){
                        if(!(pedido.getTempoRetorno() < pedido.getCliente().getPrazo() * 60)){
                            this.setQtdePedidosQuePerderamPrazo(this.getQtdePedidosQuePerderamPrazo() + 1);
                        }
                    }
                    contadorPctAntesVan();
                    this.quantPedidosEmpacotados++;
                    count++;
                    posRemocao = 0;
                }
                else{
                    posRemocao++;
                }
            }
        }
        System.out.println("A quantidade de pedidos empacotados na esteira " + this.id + " foi de: " + count);
    }
    

    /**
     * Tempo que a esteira ficou ligada
     * @return Contador de tempo que a esteira ficou ligada
     */
    public double getTempoExecucao() {
        return tempoExecucao;
    }
    /**
     * Atribui a variavel tempoExecucao o tempo que a esteira ficou ligada
     * @param tempoExecucao Tempo que a esteira ficou ligada
     */
    public void setTempoExecucao(double tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }
    /**
     * Atualiza a quantidade de pacotes embalados antes da saída da van
     */
    private void contadorPctAntesVan () {
    	if(this.tempoExecucao <=tempoSaidaVan) {
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
     * Tempo de embalagem de produtos de um pedido
     * @return Tempo em segundos gastos para embalar os produtos de um pedido
     */
    public double getTempoProdPacote() {
        return tempoProdPacote;
    }
    /**
     * Atribui a variavel tempoProdPacote o tempo em segundos gastos para embalar os produtos de um pedido
     * @param tempoSeg Tempo em segundos gastos para embalar os produtos de um pedido
     */
    public void setTempoSeg(int tempoSeg) {
        this.tempoProdPacote = tempoSeg;
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

    /**
     * Calcula o tempo de retorno médio dos pedidos da esteira
     * @return tempo de retorno médio dos pedidos da esteira
     */
    public double getTempoMedioRetornoEsteira(){
        double tempoMedio = this.tempoTotalRetorno / this.quantPedidosEmpacotados;
        return tempoMedio;
    }

	public int getQtdePedidosQuePerderamPrazo() {
		return qtdePedidosQuePerderamPrazo;
	}

	public void setQtdePedidosQuePerderamPrazo(int qtdePedidosQuePerderamPrazo) {
		this.qtdePedidosQuePerderamPrazo = qtdePedidosQuePerderamPrazo;
	}
}
