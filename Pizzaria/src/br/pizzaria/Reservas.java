/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;

/**
 *
 * @author Hugo Santos
 */
public class Reservas {
   
    private int codigo;
    private String nome_cliente;
    private int numero_mesa;
    private String dia;
   
    
    
    
    public Reservas(){ //construtor vazio
        
    }
    
    public Reservas(int c, String i,int n,String d){  //construtor com parametos
        
        codigo = c;
        nome_cliente = i;
        numero_mesa = n;
        dia = d;
    }
    
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the nuero to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nuero to set
     */
    public void setNome_cliente(String identificacao_cliente) {
        this.nome_cliente = identificacao_cliente;
    }
    
    public void setDia(String d){
        this.dia = d;
    }
    
    public String getDia(){
        return dia;
    }
    
    public void setNumero_mesa(int n){
        this.numero_mesa = n;
    }
    
    public int getNumero_mesa(){
        return numero_mesa;
    }
    
    
}
