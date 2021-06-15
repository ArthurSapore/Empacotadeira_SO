package trab_so;

import java.io.FileNotFoundException;

public class Trab_SO {
	/**
     * Calcula o tempo de retorno médio das duas esteiras
     * @param esteira1 - Primeira esteira
     * @param  esteira2 - Segunda esteira
     * @return tempo de retorno médio dos pedidos das duas esteiras
     */
	public static double tempoMedioRetorno (Esteira esteira1, Esteira esteira2) {
    	double tempoMedioRetorno = (esteira1.getTempoMedioRetornoEsteira()+esteira2.getTempoMedioRetornoEsteira())/2;
    	return tempoMedioRetorno;
    }
	
    /**
     * Método que instancia uma Lista de Pedidos, o algoritmo de escalonamento FCFS e duas Esteiras
     * e os executa em diferentes threads.
     */
    public static void executaFCFS(){
        SyncList listaPedidosFCFS = new SyncList();

        EscalonamentoFCFS fcfs = new EscalonamentoFCFS(listaPedidosFCFS);

        Esteira esteira1 = new Esteira(listaPedidosFCFS, 319/2, 1);
        Esteira esteira2 = new Esteira(listaPedidosFCFS, (319/2)+1, 2);

        try{
            fcfs.start();
            fcfs.join();

            esteira1.start();
            esteira2.start();
            esteira1.join();
            esteira2.join();

        } catch(InterruptedException ie){
            System.out.println("Erro causado por interrupcao de sistema.");
        };

        double tempoMedioRetFCFS = tempoMedioRetorno(esteira1, esteira2);
        System.out.println("O tempo médio de retorno das duas esteiras utilizando o algoritmo FCFS foi de " + tempoMedioRetFCFS + " segundos");
        System.out.println("A quantidade de pedidos que perderam o prazo na esteira 1 foi "+esteira1.getQtdePedidosQuePerderamPrazo()+" e na esteira 2 foi "+esteira2.getQtdePedidosQuePerderamPrazo());
        System.out.println("Quantidade de pacotes embalados pela esteira 1 antes da saida da van: " +esteira1.getQtdPacoteEmbaladoAntesVan());
        System.out.println("Quantidade de pacotes embalados pela esteira 2 antes da saida da van: " +esteira2.getQtdPacoteEmbaladoAntesVan()+"\n");
    }

    /**
     * Método que instancia uma Lista de Pedidos, o algoritmo de escalonamento de Prioridade de Prazo e duas Esteiras
     * e os executa em diferentes threads.
     */
    public static void executaPrioridadePrazo(){
        SyncList listaPedidosPP = new SyncList();

        EscalonamentoPrioridadePrazo prioridadePrazo = new EscalonamentoPrioridadePrazo(listaPedidosPP);

        Esteira esteira1 = new Esteira(listaPedidosPP, 319/2, 1);
        Esteira esteira2 = new Esteira(listaPedidosPP, (319/2)+1, 2);

        try{
            prioridadePrazo.start();
            prioridadePrazo.join();

            esteira1.start();
            esteira2.start();
            esteira1.join();
            esteira2.join();

        } catch(InterruptedException ie){
            System.out.println("Erro causado por interrupcao de sistema.");
        };

        double tempoMedioRetPP = tempoMedioRetorno(esteira1, esteira2);
        System.out.println("O tempo médio de retorno das duas esteiras utilizando o algoritmo de Prioridade de Prazo foi de " + tempoMedioRetPP + " segundos");
        System.out.println("A quantidade de pedidos que perderam o prazo na esteira 1 foi "+esteira1.getQtdePedidosQuePerderamPrazo()+" e na esteira 2 foi "+esteira2.getQtdePedidosQuePerderamPrazo());
        System.out.println("Quantidade de pacotes embalados pela esteira 1 antes da saida da van: " +esteira1.getQtdPacoteEmbaladoAntesVan());
        System.out.println("Quantidade de pacotes embalados pela esteira 2 antes da saida da van: " + esteira2.getQtdPacoteEmbaladoAntesVan()+"\n");
    }

    /**
     * Método que instancia uma Lista de Pedidos, o algoritmo de escalonamento SJF e duas Esteiras
     * e os executa em diferentes threads.
     */
    public static void executaSJF(){
        SyncList listaPedidosSJF = new SyncList();

        EscalonamentoSJF SJF = new EscalonamentoSJF(listaPedidosSJF);

        Esteira esteira1 = new Esteira(listaPedidosSJF, 319/2, 1);
        Esteira esteira2 = new Esteira(listaPedidosSJF, (319/2)+1, 2);

        try{
            SJF.start();
            SJF.join();

            esteira1.start();
            esteira2.start();
            esteira1.join();
            esteira2.join();

        } catch(InterruptedException ie){
            System.out.println("Erro causado por interrupcao de sistema.");
        };

        double tempoMedioRetSJF = tempoMedioRetorno(esteira1, esteira2);
        System.out.println("O tempo médio de retorno das duas esteiras utilizando o algoritmo SJF foi de " + tempoMedioRetSJF + " segundos");
        System.out.println("A quantidade de pedidos que perderam o prazo na esteira 1 foi: "+esteira1.getQtdePedidosQuePerderamPrazo()+" e na esteira 2 foi "+esteira2.getQtdePedidosQuePerderamPrazo());
        System.out.println("Quantidade de pacotes embalados pela esteira 1 antes da saida da van: " + esteira1.getQtdPacoteEmbaladoAntesVan());
        System.out.println("Quantidade de pacotes embalados pela esteira 2 antes da saida da van: " +esteira2.getQtdPacoteEmbaladoAntesVan()+"\n");
    }

    
    
    public static void main(String[] args) throws FileNotFoundException {
        executaFCFS();
        //executaPrioridadePrazo();
        //executaSJF();

    }
}
