package trab_so;
public class Esteira {

    private static final int TEMPO_SAIDA_VAN = 14400;

    private int qtdPedidos;

    private int qtdPacoteEmbaladoAntesVan;

    private int qtdPacoteProduzidos;

    private double tempoEsteiraLigada;

    private int qtdPedidosQuePerderamPrazo;

    private Pedido pedido;

    public void Empacotar(Cliente cliente){
        this.pedido = cliente.getPedido();
        setQtdPedidos();
        Pacote pacote = new Pacote(this.pedido);
        setQtdPacoteProduzidos( pacote.inserir(this.pedido));
        setQtdPacoteEmbaladoAntesVan();
        setTempoEsteiraLigada(pacote.getTEMPOPRODUCAO());
        setQtdPedidosQuePerderamPrazo(this.pedido.getPrazo());
    }

    public int getQtdPedidosQuePerderamPrazo() {
        return qtdPedidosQuePerderamPrazo;
    }

    public void setQtdPedidosQuePerderamPrazo(int prazo) {
        if(prazo<this.tempoEsteiraLigada){
            this.qtdPedidosQuePerderamPrazo +=1;
        }
    }

    public int getQtdPedidos() {
        return qtdPedidos;
    }

    public void setQtdPedidos() {
        this.qtdPedidos +=1;
    }

    public int getQtdPacoteProduzidos() {
        return qtdPacoteProduzidos;
    }

    public void setQtdPacoteProduzidos(int qtdPacoteProduzidos) {
        this.qtdPacoteProduzidos = (this.getQtdPacoteProduzidos() + qtdPacoteProduzidos);
    }

    public double getTempoEsteiraLigada() {
        return tempoEsteiraLigada;
    }

    public void setTempoEsteiraLigada(double tempo) {
        this.tempoEsteiraLigada = this.getQtdPacoteProduzidos()*tempo;
    }

    public int getQtdPacoteEmbaladoAntesVan() {
        return qtdPacoteEmbaladoAntesVan;
    }

    public void setQtdPacoteEmbaladoAntesVan() {
        if(this.tempoEsteiraLigada <=TEMPO_SAIDA_VAN) {
            this.qtdPacoteEmbaladoAntesVan =  this.getQtdPacoteProduzidos();
        }
    }

    public String toString(){
        String aux = "Quantidade de pedidos produzidos ";
        StringBuilder desc = new StringBuilder(aux);
        
        desc.append(+qtdPedidos+"\nPacotes produzidos antes da saída da van "+qtdPacoteEmbaladoAntesVan+"\nPacotes produzidos no total "+qtdPacoteProduzidos+"\nPacotes que perderam o prazo "+qtdPedidosQuePerderamPrazo+"\nEsteira ligada "+tempoEsteiraLigada+" segundos");
        aux = desc.toString();
        return aux;
    }
}
