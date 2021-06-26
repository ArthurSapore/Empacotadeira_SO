package trab_so;

public class Pacote {

    private static final double TEMPOPRODUCAO = 5.5;

    private static final int MAXQTDEPRODUTO = 20;

    private Pedido pedido;

    public Pacote(Pedido pedido){
        this.pedido = pedido;
    }

    public double getTEMPOPRODUCAO() {
        return TEMPOPRODUCAO;
    }

    public int inserir(Pedido pedido){
        double qtdPacotes = pedido.getQtdeProduto()/MAXQTDEPRODUTO;
        return (int) Math.ceil(qtdPacotes);
    }
}