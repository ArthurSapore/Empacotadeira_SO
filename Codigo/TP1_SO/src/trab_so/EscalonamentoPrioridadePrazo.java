package trab_so;

import java.util.List;

public class EscalonamentoPrioridadePrazo {
 
    private Esteira esteira = new Esteira();
 
    public EscalonamentoPrioridadePrazo(List<Cliente> clientes) {
        quickSort(clientes, 0, clientes.size()-1);
        for(Cliente cliente : clientes){
            this.esteira.Empacotar(cliente);
        }
    }

    public double getTempoDeAtividadeEsteira(){
        return this.esteira.getTempoEsteiraLigada();
    }

    public Esteira getEsteira(){
        return this.esteira;
    }
  
    public double getTempoMedioRetorno(){
        return (this.esteira.getTempoEsteiraLigada() / this.esteira.getQtdPedidos());
    }

    public static void quickSort(List<Cliente> clientes, int inicio, int fim){
        if (inicio < fim){                                      
            int particao = particionar(clientes, inicio, fim);
            quickSort(clientes, inicio, particao - 1);  
            quickSort(clientes, particao + 1, fim);               
        }
    }

    public static int particionar(List<Cliente> clientes, int inicio, int fim){
        Cliente pivot = clientes.get(fim);         
        int particao = inicio - 1;      
        for(int i=inicio ; i<fim; i++){ 
            if (clientes.get(i).getPedido().getPrazo() < pivot.getPedido().getPrazo()){          
                particao++;
                trocar(clientes, i, particao);
            }
        }
        particao++;     
        trocar(clientes, fim, particao);
        return particao;
    }

    public static void trocar(List<Cliente> clientes, int pos1, int pos2){
        Cliente aux = clientes.get(pos1);
        clientes.set(pos1, clientes.get(pos2));
        clientes.set(pos2, aux);
    }

}
