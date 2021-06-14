package trab_so;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscalonamentoPrioridadePrazo {
    /**
     * Quantidade maxima de pacotes embalados
     */
    private int maxQtdePacote = 0;
    /**
     * Quantidade de pedidos do arquivo.txt
     */
    private final int tam = 169;
    /**
     * Vetor do tipo ConteudoItemLista (Pedido) de tamanho igual a quantidade de linhas do aquivo.txt
     */
    private ConteudoItemLista [] conteudoPedidos = new ConteudoItemLista [tam];
    /**
     * Tempo total de retorno dos pedidos
     */
    private double tempoTotalRetorno = 0;
    /**
     * Atributo do tipo Esteira com seus atributos e métodos
     */
    private Esteira esteira = new Esteira();
    /**
     * ArrayList do tipo Pedido com seus atributos e métodos
     */
    private List<Pedido> pedidos = new ArrayList<>();
    /**
     * Contrutor da classe EscalonamentoPrioridadePrazo
     * Lê o arquivo.txt e monta uma Lista de pedidos, ordenados crescentemente pelo Prazo do pedido, em minutos
     * @throws FileNotFoundException 
     */
    public EscalonamentoPrioridadePrazo() throws FileNotFoundException {
        Scanner leitor = new Scanner(new File("SO_20_DadosEmpacotadeira1.txt"));
        Lista listaPacotes = new Lista();
        String linha = leitor.nextLine();
        int i = 0;
        while(leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] dados = linha.split(";");
            if(dados.length > 1) {
                ConteudoItemLista conteudo = new ConteudoItemLista(new Pedido(new Cliente(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]))));
                conteudoPedidos[i] = conteudo;
            }
            i++;
        }
        leitor.close();
        insertionSort(conteudoPedidos);
        for(int cont = 0; cont < conteudoPedidos.length; cont++) {
            listaPacotes.inserirFinal(conteudoPedidos[cont]);
        }
        ligaEsteira(listaPacotes);
    }
    /**
     * Ordena os pedidos pelo prazo
     * @param dados 
     */
    static void insertionSort(ConteudoItemLista [] dados){
        for(int posRef = 1; posRef < dados.length; posRef++){  
            int posComp = posRef - 1;                           
            ConteudoItemLista dadoRef = dados[posRef];
            while (posComp >= 0 && dadoRef.pedido.getCliente().getPrazo() < dados[posComp].pedido.getCliente().getPrazo())
                posComp--;
            for (int posCopia = posRef; posCopia > (posComp+1); posCopia--) {
                dados[posCopia] = dados[posCopia - 1];
            }
            dados[posComp + 1] = dadoRef;
        }
    }
    /**
     * Realiza uma ordenação e inseri no ArrayList de pedidos, além de atualizar a quantidade de pacotes embalados
     * @param listaPacotes 
     */
    public void ligaEsteira(Lista listaPacotes){
        while(listaPacotes.primeiro.proximo != null){
            this.esteira.Empacotar(listaPacotes.primeiro.proximo.conteudo.pedido);
            this.tempoTotalRetorno += listaPacotes.primeiro.proximo.conteudo.pedido.getTempoRetorno();

            if(listaPacotes.primeiro.proximo.conteudo.pedido.getTempoRetorno() > (listaPacotes.primeiro.proximo.conteudo.pedido.getCliente().getPrazo()*60))
                pedidos.add(listaPacotes.primeiro.proximo.conteudo.pedido);
            listaPacotes.primeiro = listaPacotes.primeiro.proximo;
        }
        this.maxQtdePacote = this.esteira.getQtdPacoteEmbaladoAntesVan();
    }
    /**
     * Retorna mensagens com os pedidos atrasados, contendo nome do cliente, tempo de retorno do pedido, em segundos
     */
    public void getAtrasados(){
        for(Pedido pedido: this.pedidos){
            System.out.println("Pedido atrasado do cliente "+ pedido.getCliente().getNome()+" Tempo retorno: "+pedido.getTempoRetorno()+" Prazo: "+pedido.getCliente().getPrazo()*60);
        }
    }
    /**
     * Tempo que a esteira permanece ligada
     * @return Tempo de atividade da esteira
     */
    public double getTempoDeAtividadeEsteira(){
        return this.esteira.getContadorTempo();
    }
    /**
     * Tempo total de retorno dos pedidos
     * @return Tempo médio de retorno dos pedidos
     */
    public double getTempoTotalRetorno() {
        return tempoTotalRetorno;
    }
    /**
     * Tempo médio de retorno dos pedidos da esteira
     * @return Tempo médio de retorno dos pedidos, dividindo o tempo total de retorno pelo numero de pedidos
     */
    public double getTempoMedioRetorno(){
        return (this.tempoTotalRetorno / this.tam);
    }
    /**
     * Contém a quantidade de pacotes embalados
     * @return Quantidade máxima de pacotes embalados
     */
    public int getMaxQtdePacote() {
            return maxQtdePacote;
    }
    /**
     * Atribui a variavel maxQtdePacote o numero de pacotes embalados
     * @param maxQtdePacote de pacotes embalados 
     */
    public void setMaxQtdePacote(int maxQtdePacote) {
        this.maxQtdePacote = maxQtdePacote;
    }
}
