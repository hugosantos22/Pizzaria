/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hugo Santos
 */
public class Pedidos {

    private int codigo;
    private String descricao;
    private int cliente;
    private int mesa;
    private String data;
    private String hora;

    Clientes cl=new Clientes();
    Mesas m = new Mesas();
    public Pedidos() { //construtor vazio
        
    }

    public Pedidos(int c, String de, String d,String h, int cl,int m) { //construtor com paramentos

        this.codigo = c;
        this.descricao = d;
        this.data = de;
        this.hora = h;
        this.cliente = cl;
        this.mesa = m;
    }

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        /**
     * @return the cliente
     */
    
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @return the mesa
     */
    public int getMesa() {
        return mesa;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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

