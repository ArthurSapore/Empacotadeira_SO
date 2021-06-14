package trab_so;
public class Lista {
    /**
     * itemLista são como "caixas" que interligadas formam a lista em si; um itemLista contem conteudo do tipo ConteudoItemLista, a classe que fará parte da lista
     */
    /**
     * ItemLista primeiro (null) - elemento sentinela, do tipo itemLista
     */
    public itemLista primeiro;
    /**
     * ItemLista ultimo - referencia o ultimo itemLista da lista, do tipo itemLista
     */
    public itemLista ultimo;
    /**
     * Construtor da classe Lista, cria o elemento sentinela igual a null e atribui o primeiro ao ultimo elemento itemLista
     */
    public Lista() {
        primeiro = new itemLista(null);
        ultimo = primeiro;
    }
    /**
     * Verifica se a lista está vazia
     * @return boolean - Se a lista está vazia ou não 
     */
    public boolean listaVazia(){
        return (ultimo == primeiro);
    }
    /**
     * Inseri um elemento no final da lista
     * @param conteudo Valor do tipo ConteudoItemLista, que será inserido no final da lista
     */
    public void inserirFinal(ConteudoItemLista conteudo){
        itemLista novo = new itemLista(conteudo);
        ultimo.proximo = novo;
        ultimo = novo;
    }
    /**
     * 
     * @param cont Conteudo procurado dentre os existentes na lista, para ser removido
     * @return Conteudo inserido na lista 
     */
    public ConteudoItemLista retirarConteudo(ConteudoItemLista cont){
        itemLista aux = primeiro;
        while(aux.proximo != null){
            if(aux.proximo.conteudo.equals(cont.pedido.getCliente().getNome()) && aux.proximo.conteudo.equals(cont.pedido.getCliente().getPrazo())){
                itemLista retirado = aux.proximo;
                aux.proximo = retirado.proximo;
                if(retirado != ultimo){
                    retirado.proximo = null;
                } else {
                    ultimo = aux;
                }
                return retirado.conteudo;
            } else {
                aux = aux.proximo;
            }
        }
        return null;
    }
    /**
     * Retira e retorna o primeiro elemento da lista
     * @return Conteudo inserido na lista 
     */
    public ConteudoItemLista retiraPrimeiro(){
        if(!listaVazia()){
            itemLista aux = primeiro;
            if(aux.proximo == ultimo){
                ultimo = aux;
                return aux.proximo.conteudo;
            } else {
                itemLista temp = aux.proximo;
                aux.proximo = temp.proximo;
                temp.proximo = null;
                return temp.conteudo;
            }
        }
        return null;
    }
    /**
     * Imprime a lista, com todos os seus elementos
     * @param lista Lista a ser impressa
     */
    public void imprimirLista(Lista lista){
        if(!listaVazia()) {
            itemLista aux = primeiro.proximo;
            String elementos = "";
            while(aux != null){
                elementos += aux.conteudo;
                if(aux != ultimo)
                    elementos += "\n";
                aux = aux.proximo;
            }
            System.out.println("Elementos Lista: \n" + elementos);
        } else 
            System.out.println("Lista Vazia!");
    }
    /**
     * Concatena 2 listas recebidas como parametro, na ordem recebida
     * @param l1 Lista1 a ser concatenada
     * @param l2 Lista2 a ser concatenada
     * @return Retorna uma lista que é a concatenação das duas pasadas como parâmetros
     */
    public Lista concatenaListas(Lista l1, Lista l2){
        if(!l1.listaVazia() && !l2.listaVazia()){
            l1.ultimo.proximo = l2.primeiro.proximo;
            l1.ultimo = l2.ultimo;
            return l1;
        } else
            return null;
    }
}