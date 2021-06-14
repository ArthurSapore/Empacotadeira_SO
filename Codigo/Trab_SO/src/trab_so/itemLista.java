package trab_so;
public class itemLista {
    /**
     * Essa classe é como uma "caixa" e o atributo do tipo ConteudoItemLista, armazena o valor a ser gravado no itemLista; a Lista é um conjunto de itemLista
     */
    /**
     * conteudo, do tipo ConteudoItemLista, armazena o que será de fato armazenado em um itemLista 
     */
    public ConteudoItemLista conteudo;
    /**
     * Faz referência ao próximo itemLista da Lista
     */
    public itemLista proximo;
    /**
     * Contrutor da classe itemLista, faz com que o proximo itemLista receba null e atribui o ConteudoItemLista
     * @param cont Conteudo que será armazenado no itemLista, formando a lista
     */
    public itemLista(ConteudoItemLista cont){
        conteudo = cont;
        proximo = null;
    }
}
