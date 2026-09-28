/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oficinamecanica;

/**
 *
 * @author 1640295
 */
public class Servico {
    private String nome, categoria;
    private int tempo;
    private double valor;
    
    public Servico(String n, int t, double v, String c) { 
        nome=n; 
        tempo=t; 
        valor=v; 
        categoria=c; 
    }
    
    public String getCategoria() { 
        return categoria; 
    }
}
