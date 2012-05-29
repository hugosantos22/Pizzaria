/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;

/**
 *
 * @author Hugo Santos
 */
public class Itens_Cardapios {
    
    private int codigo;
    private String nome;
    private String descricao;
    private float valor;
    
    
    
    public Itens_Cardapios(){ //metodo constutor
        
    }
    
    public Itens_Cardapios(int c, String n, String d, float v){ //metodo constutor com parametos
        
        codigo = c;
        nome = n;
        descricao = d;
        valor = v;
    }
    //encapsulamento
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
}
