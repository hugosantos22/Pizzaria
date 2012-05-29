/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Itens_Cardapios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Saulo Francisco
 */
public class Itens_CardapiosDao implements DaoInterface<Itens_Cardapios>{
    
    
    @Override
    
    public int criar(Itens_Cardapios ic){
        int ucodigo = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();//getConexao = metodo statico que vai devolver conexão unica com banco de dados
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("insert into item_cardapio"
                    + "(nome, descricao, valor) "
                    + "values(?, ?, ?);");
            
            

            pstmt.setString(1, ic.getNome());
            pstmt.setString(2, ic.getDescricao());
            pstmt.setFloat(3, ic.getValor());
            
            
            
            
            // Reuso da variavel ucodigo
            ucodigo = pstmt.executeUpdate();
            ucodigo = getucodigo();

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        return ucodigo;
    
    }
    
    @Override
    public ArrayList<Itens_Cardapios> buscar(Itens_Cardapios ic){
        
        ArrayList<Itens_Cardapios> icl = new ArrayList<Itens_Cardapios>();//instancio a classe Itens_Cardapios

        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (ic == null)
            {
                // Seleciona todos as mesas se nenhum exemplo passado
                pstmt = con.prepareStatement("select ic.codigo, ic.nome, ic.descricao, ic.valor" +
                         "from itens_cardapios as ic join nome as n on ic.codigo = n.codigo");
            } else
            {
                // Seleciona a mesa a partir do exemplo
                pstmt = con.prepareStatement("select ic.codigo, ic.nome, ic.descricao, ic.valor" +
                         "from itens_cardapios as ic join nome as n on ic.codigo = n.codigo" +
                         " where codigo = ?;");
                pstmt.setInt(1, ic.getCodigo());
            }

            ResultSet rs = pstmt.executeQuery();//execução da consulta, o resultdo da consuta vai parar em RS

            while (rs.next())
            {
                icl.add(new Itens_Cardapios(
                        rs.getInt(1),
                        rs.getString(2),// adiciona alguma coisa la dentro, ex= add Item_Cardapio
                        rs.getString(3),
                        rs.getFloat(4)));
                
            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return icl;// devolve o arreylist qeu foi reconstruido com todos os dados
    }

    @Override
    public int atualizar(Itens_Cardapios ic)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("update Itens_Cardapios "
                    + "nome = ?, "
                    + "descricao = ?,valor = ?"
                    + "where codigo = ?;");           
            
            pstmt.setString(1, ic.getNome());
            pstmt.setString(2, ic.getDescricao());
            pstmt.setFloat(3, ic.getValor());

            aux = pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            return 0;
        }
        return aux;
    }

    @Override
    public int apagar(Itens_Cardapios ic)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from Item_Cardapio "
                    + "where codigo = ?;");

            pstmt.setInt(1, ic.getCodigo());

            aux = pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            return 0;
        }
        return aux;
    }

    public static int getucodigo()
    {
        int ucodigo = 0;


        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt = null;
            
            switch (ConectaBanco.getBanco())
            {
               /* case ConectaBanco.POSTGRESQL:
                    pstmt = con.prepareStatement("select lastval();");
                    break;
                */    
                /*case ConectaBanco.SQLSERVEREXPRESS:
                    pstmt = con.prepareStatement("select scope_identity();");
                    break;
                */    
                 case ConectaBanco.MYSQL:
                default:
                    pstmt = con.prepareStatement("select last_insert_id();");
                    break;
            }

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                ucodigo = rs.getInt(1);
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return ucodigo;
    }
    
}
