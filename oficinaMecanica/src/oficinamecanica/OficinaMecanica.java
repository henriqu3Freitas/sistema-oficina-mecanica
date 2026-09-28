/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oficinamecanica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1640295
 */
public class OficinaMecanica {

    /**
     * @param args the command line arguments
     */
        static List<Mecanico> mecs = new ArrayList<>();
        static List<Box> boxes = new ArrayList<>();
        static List<OrdemServico> ordens = new ArrayList<>();
        static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarDados();
        int op = -1;

        while(op != 0) {
            System.out.println("\n1-Nova OS  \n2-Associar Mecânico a Box  \n3-Atribuir OS a Box \n4-Ordens do Box \n5-Total Finalizadas \n6-Buscar por Status \n7-Detalhes de OS \n8-Finalizar OS \n0-Sair");
            op = sc.nextInt();
            if(op == 1) cadastrarOS();
            if(op == 2) associarMecanico();
            if(op == 3) atribuirOS();
            if(op == 4) exibirOrdensBox();
            if(op == 5) paraCadaBox(b -> System.out.println("Box " + b.getNumero() + " finalizou: " + b.getFinalizadas()));
            if(op == 6) buscarPorStatus();
            if(op == 7) { System.out.print("ID da OS: "); buscarOS(sc.nextInt()).exibir(); }
            if(op == 8) finalizarOS();
        }
    }

    static void iniciarDados() {
        mecs.add(new Mecanico("João", 1, "Motor", 9));
        mecs.add(new Mecanico("Ana", 2, "Pneu", 8));
        mecs.add(new Mecanico("Rui", 3, "Óleo", 7));
        boxes.add(new Box(1, "Motor", 2, "Setor A"));
        boxes.add(new Box(2, "Pneu", 2, "Setor B"));
        boxes.add(new Box(3, "Óleo", 2, "Setor C"));
    }

    static void cadastrarOS() {
        System.out.print("Cliente, Modelo, Placa, Data, Categoria Serviço (Pressione ENTER após cada): \n");
        sc.nextLine();
        Servico s = new Servico("Geral", 60, 100.0, sc.nextLine());
        OrdemServico os = new OrdemServico(ordens.size()+1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), s);
        ordens.add(os);
        System.out.println("OS cadastrada! ID: " + os.getCodigo());
    }

    static void associarMecanico() {
        System.out.print("Digite o numero do Box (1, 2, 3) e o ID do Mecanico (0, 1, 2): ");
        Box b = buscarBox(sc.nextInt());
        Mecanico m = mecs.get(sc.nextInt());
        b.setMecanico(m);
        System.out.println("Mecânico " + m.getNome() + " associado ao Box " + b.getNumero());
    }

    static void atribuirOS() {
        System.out.print("ID da OS e Numero do Box: ");
        OrdemServico os = buscarOS(sc.nextInt());
        Box b = buscarBox(sc.nextInt());
        
        if(os.getStatus().equals("ABERTA") && b.receberOrdem(os)) {
            os.setBox(b);
            os.setStatus("EXECUCAO");
            System.out.println("OS atribuída!");
        } else {
            System.out.println("Erro.");
        }
    }

    static void exibirOrdensBox() {
        System.out.print("Numero do Box: ");
        Box b = buscarBox(sc.nextInt());
        for(OrdemServico os : b.getOrdens()) os.exibir();
        System.out.println("Total no Box: " + b.getOrdens().size());
    }

    static void buscarPorStatus() {
        System.out.print("Status (ABERTA, EXECUCAO, FINALIZADA): ");
        String st = sc.next();
        for(OrdemServico os : ordens) if(os.getStatus().equalsIgnoreCase(st)) os.exibir();
    }

    static void finalizarOS() {
        System.out.print("ID da OS para finalizar: ");
        OrdemServico os = buscarOS(sc.nextInt());
        if(os.getStatus().equals("EXECUCAO")) {
            os.setStatus("FINALIZADA");
            os.getBox().finalizarOrdem(os);
            System.out.println("OS Finalizada!");
        }
    }
    
    static OrdemServico buscarOS(int id) { 
        return ordens.stream().filter(o -> o.getCodigo() == id).findFirst().get(); 
    }
    
    static Box buscarBox(int num) { 
        return boxes.stream().filter(b -> b.getNumero() == num).findFirst().get(); 
    }
    
    static void paraCadaBox(java.util.function.Consumer<Box> acao) { 
        for(Box b : boxes) acao.accept(b); 
    }

}
    

