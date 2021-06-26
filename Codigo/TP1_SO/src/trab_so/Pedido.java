package trab_so;

public class Pedido {

    private int TempoDeRetorno; 

    private int qtdeProduto;

    private int prazo;

    public Pedido(int qtd, int prazo){
        this.setQtdeProduto(qtd);
        this.setPrazo(prazo);
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        if(prazo == 0){
            this.prazo = 1000*60;
        }else{
            this.prazo = prazo*60;
        }
    }

    public int getQtdeProduto() {
        return qtdeProduto; 
    }

    public void setQtdeProduto(int qtdeProduto) { 
        this.qtdeProduto = qtdeProduto; 
    }

    public int getTempoDeRetorno() {
        return TempoDeRetorno;
    }
    
    public void setTempoDeRetorno(int tempoDeRetorno) {
        this.TempoDeRetorno = tempoDeRetorno;
    }
}
