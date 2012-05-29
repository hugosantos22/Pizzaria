/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;

/**
 *
 * @author Hugo Santos
 */
public class Mesas {
    
    private int numero;
    private String tipo;
    private int numero_cadeiras;
    
    //construtor da classe
    public Mesas(){
        
    }
    public Mesas(int m,String t,int n){   //construtor da classe com parametos
        
        numero = m;
        tipo = t;
        numero_cadeiras = n;
    }
    //encpsulamento
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param codigo the nuero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * @return the tipo
     */
    public String getTipo(){
        return tipo;
    }
    
    /**
     * @param tipo the nuero to set
     */
    public void setTipo(String t){
        this.tipo = t;
    }
    
    /**
     * @return the numero_cadeiras
     */
    public int getNumero_cadeiras() {
        return numero_cadeiras;
    }

    /**
     * @param numero_cadeiras the numero_cadeiras to set
     */
    public void setNumero_cadeiras(int nu) {
        this.numero_cadeiras = nu;
    }
    
    
}
