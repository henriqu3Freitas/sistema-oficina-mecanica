/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oficinamecanica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1640295
 */
public class Box {
    private int numero, capacidade, finalizadas = 0;
    private String tipo, localizacao;
    private Mecanico mecanico;
    private List<OrdemServico> ordensAtuais = new ArrayList<>();

    public Box(int n, String t, int c, String l) { 
        numero=n;
        tipo=t;
        capacidade=c;
        localizacao=l; 
    }
    
    public int getNumero() { 
        return numero; 
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public Mecanico getMecanico() { 
        return mecanico; 
    }
    
    public void setMecanico(Mecanico m) { 
        mecanico = m; 
    }
    
    public List<OrdemServico> getOrdens() { 
        return ordensAtuais; 
    }
    
    public int getFinalizadas() { 
        return finalizadas; 
    }

    public boolean receberOrdem(OrdemServico os) {
        if(ordensAtuais.size() < capacidade && os.getServico().getCategoria().equals(tipo)) {
            ordensAtuais.add(os);
            return true;
        }
        return false;
    }

    public void finalizarOrdem(OrdemServico os) {
        ordensAtuais.remove(os);
        finalizadas++;
    }
}

