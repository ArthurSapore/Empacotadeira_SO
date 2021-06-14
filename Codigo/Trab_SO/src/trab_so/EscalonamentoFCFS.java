package trab_so;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscalonamentoFCFS {
    /**
     * Quantidade maxima de pacotes embalados
     */
    private int maxQtdePacote = 0;
    /**
     * Quantidade maxima de pedidos realizados
     */
    private int quantPedidos = 0;
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
     * Contrutor da classe EscalonamentoFCFS
     * Lê o arquivo.txt e monta uma Lista de pedidos
     * @throws FileNotFoundException
     */
    public EscalonamentoFCFS() throws FileNotFoundException {
        Scanner leitor = new Scanner(new File("SO_20_DadosEmpacotadeira1.txt"));
        Lista listaPacotes = new Lista();
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] dados = linha.split(";");
            if(dados.length > 1) {
                ConteudoItemLista conteudo = new ConteudoItemLista(new Pedido(new Cliente(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]))));
                listaPacotes.inserirFinal(conteudo);
                this.quantPedidos++;
            }
        }
        leitor.close();
        ligaEsteira(listaPacotes);
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
     * Tempo médio de retorno dos pedidos da esteira
     * @return Tempo médio de retorno dos pedidos
     */
    public double getTempoMedioRetorno(){
        return (this.tempoTotalRetorno / this.quantPedidos);
    }
    /**
     * Contém a quantidade de pacotes embalados
     * @return Quantidade máxima de pacotes embalados
     */
    public int getMaxQtdePacote() {
        return maxQtdePacote;
    }
}

