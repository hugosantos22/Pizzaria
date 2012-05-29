/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;

import java.util.Date;


/**
 *
 * @author Hugo Santos
 */
public class Contas {
    
   private int codigo;
   private float valor_total;
   private String data;
   private String hora;
   private int pedido;
   private Itens_Cardapios item_cardapio = new Itens_Cardapios();  //instacia de um objeto
   

      
   public Contas() {  //construtor vazio
        
    }
    

   public Contas(int c, float vt, String d,String h, int p) {  //construtor com parametros

        this.codigo = c;
        this.valor_total = vt;
        this.data = d;
        this.hora = h;
        this.pedido = p;
            }
    //encapsulamento
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the valor_total
     */
    public float getValor_total() {
        
        //valor_total + = item_cardapio.getValor();
        
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the datahora
     */
    public String getData() {
        return data;
    }

    /**
     * @param datahora the datahora to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the pedido
     */
    public int getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    

    
    
    
    
    
    
}
