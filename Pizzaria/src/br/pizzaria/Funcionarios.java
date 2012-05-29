/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pizzaria;



/**
 *
 * @author Hugo Santos
 */
public class Funcionarios {
    private int codigo;
    private String nome;
    private String funcao;
    private float salario;
    private String usuario;
    private String senha;
    
    //construtor da classe
    public Funcionarios(){
        
    }
    public Funcionarios(int c, String n, String f, float s,String u,String se){ //construtor da classe com parametros
        
        codigo = c;
        nome = n;
        funcao = f;
        salario = s;
        usuario = u;
        senha = se;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public float getSalario() {
        return salario;
    }

    /**
     * @param nome to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
