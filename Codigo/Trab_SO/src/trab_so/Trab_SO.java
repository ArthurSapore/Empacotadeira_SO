package trab_so;

import java.io.FileNotFoundException;

public class Trab_SO {
    public static void main(String[] args) throws FileNotFoundException {
        /**
        * Liga a esteira, praticando o algoritmo FCFS
        */
        EscalonamentoFCFS FCFS = new EscalonamentoFCFS();
        /**
        * Liga a esteira, com o algoritmo levando em consideração o prazo do pedido como prioridade
        */
        EscalonamentoPrioridadePrazo prioridade = new EscalonamentoPrioridadePrazo();
        /**
        * Liga a esteira, dessa vez com o algoritmo SJF, executando primeiro os pedidos com prioridade, ordenados pela quantidade de produtos de cada pedido, seguido dos pedidos sem prioridade, com menores quantidades de produtos
        */
    	EscalonamentoSJF SJF = new EscalonamentoSJF();
        System.out.println();
        /**
        * Retorna o tempo de atividade, em segundos, que a esteira permaneceu ligada, para o algoritmo FCFS
        */
        System.out.println("O tempo de atividade da esteira utilizando o algoritmo FCFS é "+ FCFS.getTempoDeAtividadeEsteira() + " segundos.");
        /**
        * Retorna o tempo de atividade, em segundos, que a esteira permaneceu ligada, para o algoritmo de prioridade de prazo
        */
        System.out.println("O tempo de atividade da esteira utilizando o alforitmo Prioridade de prazo é "+ prioridade.getTempoDeAtividadeEsteira() + " segundos.");
        /**
        * Retorna o tempo de atividade, em segundos, que a esteira permaneceu ligada, para o algoritmo SJF, ordenados pela quantidade de produtos de cada pedido, seguido dos pedidos sem prioridade, com menores quantidades de produtos
        */
        System.out.println("O tempo de atividade da esteira utilizando o algoritmo SJF é "+ SJF.getTempoDeAtividadeEsteira() + " segundos.\n");
        /**
        * Exibe o tempo médio de retorno para o algoritmo FCFS
        */
        System.out.println("O tempo médio de retorno do algoritmo de escalonamento FCFS é "+ FCFS.getTempoMedioRetorno() + " segundos.");
        /**
        *  Exibe o tempo médio de retorno para o algoritmo de prioridade no prazo do pedido
        */
        System.out.println("O tempo médio de retorno do algoritmo de escalonamento de prioridade de prazo é "+ prioridade.getTempoMedioRetorno() + " segundos.");
        /**
        * Exibe o tempo médio de retorno para o algoritmo SJF
        */
        System.out.println("O tempo médio de retorno do algoritmo de escalonamento SJF é "+ SJF.getTempoMedioRetorno() + " segundos.\n");
        /**
        * Trás o número de pacotes embalados com o algoritmo FCFS
        */
        System.out.println("Foram  produzidos "+ FCFS.getMaxQtdePacote() +" pacotes antes da saida da van utilizando o algoritmo FCFS ");
        /**
        * Trás o número de pacotes embalados com o algoritmo de prioridade por prazo
        */
        System.out.println("Foram  produzidos "+ prioridade.getMaxQtdePacote() +" pacotes antes da saida da van utilizando o algoritmo Prioridade de pazo ");
        /**
        * Trás o número de pacotes embalados com o algoritmo SJF
        */
        System.out.println("Foram  produzidos "+ SJF.getMaxQtdePacote() +" pacotes antes da saida da van utilizando o algoritmo SJF \n");
        /**
        * Pedidos atrasados para o algoritmo FCFS
        */
        System.out.println("Atrasados FCFS");
        FCFS.getAtrasados();
        /**
        * Pedidos atrasados para o algoritmo de prioridade por prazo
        */
        System.out.println("");
        System.out.println("Atrasados Prioridade por prazo");
        prioridade.getAtrasados();
        /**
        * Pedidos atrasados para o algoritmo SJF
        */
        System.out.println("");
        System.out.println("Atrasados SJF");
        SJF.getAtrasados();
    }
}
