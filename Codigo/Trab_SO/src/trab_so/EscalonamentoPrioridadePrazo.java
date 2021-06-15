package trab_so;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscalonamentoPrioridadePrazo extends Thread {
    /**
     * Quantidade maxima de pedidos realizados
     */
    private int quantPedidos = 319;

    /**
     * Lista de pedidos sincronizada
     */
    private SyncList pedidos;

    public EscalonamentoPrioridadePrazo(SyncList listaPedidos){
        this.pedidos = listaPedidos;

    }

    /**
     * Método sobrescrito da classe Thread que inicia uma thread
     */
    @Override
    public void run() {
        try {
            criaFila();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adiciona os pedidos em um array, depois ordena pelo menor prazo e adiciona na lista sincronizada de pedidos
     * @throws FileNotFoundException
     */
    private void criaFila() throws FileNotFoundException {
        Scanner leitor = new Scanner(new File("SO_20_DadosEmpacotadeira_2.txt"));
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] dados = linha.split(";");
            if(dados.length > 1) {
                Pedido pedido = new Pedido(new Cliente(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3])));
                this.pedidos.add(pedido);
                this.quantPedidos++;
            }
        }
        Pedido[] vetPedidos = this.pedidos.toArray();
        insertionSort(vetPedidos);

        for(int i =0; i<vetPedidos.length; i++){
            this.pedidos.addPosicao(i, vetPedidos[i]);
        }

        leitor.close();
    }

    /**
     * Ordena os pedidos pelo prazo
     * @param dados 
     */
    static void insertionSort(Pedido[] dados){
        for(int posRef = 1; posRef < dados.length; posRef++){  
            int posComp = posRef - 1;                           
            Pedido dadoRef = dados[posRef];
            while (posComp >= 0 && dadoRef.getCliente().getPrazo() < dados[posComp].getCliente().getPrazo())
                posComp--;
            for (int posCopia = posRef; posCopia > (posComp+1); posCopia--) {
                dados[posCopia] = dados[posCopia - 1];
            }
            dados[posComp + 1] = dadoRef;
        }
    }
    /**
     * Contém a quantidade de Pedidos
     * @return Quantidade pedidos
     */
    public int getQuanPedidos() {
        return this.quantPedidos;
    }


}
