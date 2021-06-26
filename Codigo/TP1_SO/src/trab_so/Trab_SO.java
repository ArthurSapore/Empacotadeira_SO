package trab_so;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Trab_SO {
    public static List<Cliente> clientes = new ArrayList<>();

    public static void lerDados () throws FileNotFoundException{
        Scanner leitor = new Scanner(new File("SO_20_DadosEmpacotadeira1.txt"));
        while(leitor.hasNextLine()){
            String linha = leitor.nextLine();
            String dados [] = linha.split(";");
            if(dados.length>1){
                Cliente cliente = new Cliente(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]));
                clientes.add(cliente);
            }
        }
        leitor.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        lerDados();
         
        EscalonamentoFCFS escalonamentoFCFS = new EscalonamentoFCFS(clientes);
        System.out.println("Tempo médio de retorno FCFS "+escalonamentoFCFS.getTempoMedioRetorno()+" segundos");
        System.out.println(escalonamentoFCFS.getEsteira().toString());

        EscalonamentoPrioridadePrazo escalonamento = new EscalonamentoPrioridadePrazo(clientes);
        System.out.println("\nTempo médio de Prioridade Prazo "+escalonamento.getTempoMedioRetorno()+" segundos");
        System.out.println(escalonamento.getEsteira().toString());

        EscalonamentoSJF escalonamentoSJF = new EscalonamentoSJF(clientes);
        System.out.println("\nTempo médio do Escalonamento SJF "+escalonamentoSJF.getTempoMedioRetorno()+" segundos");
        System.out.println(escalonamentoSJF.getEsteira().toString());
        
    }
}

