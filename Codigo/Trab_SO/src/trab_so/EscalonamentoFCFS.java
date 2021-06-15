package trab_so;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscalonamentoFCFS extends Thread {
    /**
     * Quantidade maxima de pedidos realizados
     */
    private int quantPedidos = 0;
    /**
     * Tempo total de retorno dos pedidos
     */
    private double tempoTotalRetorno = 0;

    /**
     * Lista sincronizada de pedidos
     */
    private SyncList pedidos;

    /**
     * Contrutor da classe EscalonamentoFCFS
     * Lê o arquivo.txt e monta uma Lista de pedidos
     * @param listaPedidos lista de pedidos
     */
    public EscalonamentoFCFS(SyncList listaPedidos){
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
     * Cria uma fila de Pedidos de acordo com o algoritmo: FCFS
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
        leitor.close();
    }


    /**
     * Contém a quantidade de Pedidos
     * @return Quantidade pedidos
     */
    public int getQuanPedidos() {
        return this.quantPedidos;
    }
}

