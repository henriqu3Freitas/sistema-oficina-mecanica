/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oficinamecanica;

/**
 *
 * @author 1640295
 */
public class OrdemServico {
    private int codigo;
    private String cliente, modelo, placa, data;
    private String status = "ABERTA";
    private Servico servico;
    private Box box;

    public OrdemServico(int c, String cli, String mod, String pla, String d, Servico s) {
        codigo=c; cliente=cli; modelo=mod; placa=pla; data=d; servico=s;
    }
    public int getCodigo() { return codigo; }
    public String getStatus() { return status; }
    public void setStatus(String st) { status = st; }
    public Servico getServico() { return servico; }
    public Box getBox() { return box; }
    public void setBox(Box b) { box = b; }

    public void exibir() {
        System.out.println("OS " + codigo + "  Cliente: " + cliente + " Status: " + status + " Box: " + (box != null ? box.getNumero() : "Nenhum"));
    }
}

