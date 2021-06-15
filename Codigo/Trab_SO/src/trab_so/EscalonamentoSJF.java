package trab_so;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscalonamentoSJF extends Thread{
    /**
     * Quantidade maxima de pedidos realizados
     */
    private int quantPedidos = 319;

    /**
     * Tempo total de retorno dos pedidos
     */
    private double tempoTotalRetorno = 0;

    /**
     * Lista sincronizada de pedidos
     */
    private SyncList pedidos;

    /**
     * @param listaPedidos - lista sincronizada
     */
    public EscalonamentoSJF(SyncList listaPedidos){
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
     * Cria a 2 vetores de pedidos com prazo e sem prazo, ordena pela menor quantidade de pacotes e adiciona os pedidos
     * na lista sincronizada
     * @throws FileNotFoundException - Exceção de arquivo não encontrado
     */
    private void criaFila() throws FileNotFoundException {
        Scanner leitor = new Scanner(new File("SO_20_DadosEmpacotadeira_2.txt"));
        String linha = leitor.nextLine();
        List<Pedido> pedidosComPrazo = new ArrayList<>();
        List<Pedido> pedidosSemPrazo = new ArrayList<>();
        while(leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] dados = linha.split(";");
            if(dados.length > 1) {
                if(Integer.parseInt(dados[2]) > 0 && Integer.parseInt(dados[2]) <= 250){
                    Pedido pedido = new Pedido(new Cliente(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3])));
                    pedidosComPrazo.add(pedido);
                    this.quantPedidos++;
                }else{
                    Pedido pedido = new Pedido(new Cliente(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3])));
                    pedidosSemPrazo.add(pedido);
                    this.quantPedidos++;
                }
            }
        }
        Pedido[] vetPedidoPrazo = pedidosComPrazo.toArray(new Pedido[pedidosComPrazo.size()]);
        Pedido[] vetPedidoSemPrazo = pedidosSemPrazo.toArray(new Pedido[pedidosComPrazo.size()]);

        insertionSort(vetPedidoPrazo);
        insertionSort(vetPedidoSemPrazo);

        for(int i =0; i<vetPedidoPrazo.length; i++){
            this.pedidos.addPosicao(i, vetPedidoPrazo[i]);
        }
        for(int i =0; i<vetPedidoSemPrazo.length; i++){
            this.pedidos.add(vetPedidoSemPrazo[i]);
        }

        leitor.close();
    }

    /**
     * Ordena os pedidos pela quantidade de produtos
     * @param dados 
     */
    static void insertionSort(Pedido [] dados){
        for(int posRef = 1; posRef < dados.length; posRef++){  
            int posComp = posRef - 1;                           
            Pedido dadoRef = dados[posRef];
            while (posComp >= 0 && dadoRef.getCliente().getQtdeProduto() < dados[posComp].getCliente().getQtdeProduto())
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
    public int getQuantPedidos() {
        return this.quantPedidos;
    }

}
