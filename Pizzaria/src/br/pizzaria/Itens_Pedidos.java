/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;

/**
 *
 * @author Hugo Santos
 */
public class Itens_Pedidos {

    private int codigo;
    private int pedido;
    private int itens_cardapio;
    private int quantdade;

    
    public Itens_Pedidos(){//construtor vazio
        
    }
    public Itens_Pedidos(int c,int p,int i,int q){  //construtor com parametos
        this.codigo = c;
        this.pedido = p;
        this.itens_cardapio = i;
        this.quantdade = q;
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
     * @return the itens_cardapio
     */
    public int getItens_cardapio() {
        return itens_cardapio;
    }

    /**
     * @param itens_cardapio the itens_cardapio to set
     */
    public void setItens_cardapio(int itens_cardapio) {
        this.itens_cardapio = itens_cardapio;
    }

    /**
     * @return the quantdade
     */
    public int getQuantdade() {
        return quantdade;
    }

    /**
     * @param quantdade the quantdade to set
     */
    public void setQuantdade(int quantdade) {
        this.quantdade = quantdade;
    }
    
    
    
}
