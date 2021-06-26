package trab_so;

import java.util.List;

public class EscalonamentoFCFS {

    private Esteira esteira = new Esteira();

    public EscalonamentoFCFS(List<Cliente> clientes) {
        for(Cliente cliente : clientes ){
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
}

