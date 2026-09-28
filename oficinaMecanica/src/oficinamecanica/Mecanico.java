/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oficinamecanica;

/**
 *
 * @author 1640295
 */
public class Mecanico {
    private String nome, especialidade;
    private int cpf, telefone;

    public Mecanico(String n, int c, String e, int t) { 
        nome=n;
        cpf=c; 
        especialidade=e; 
        telefone=t; 
    }
    
    public String getNome() { 
        return nome; 
    }
}
