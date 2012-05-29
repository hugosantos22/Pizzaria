/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Mesas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Saulo Francisco
 */
public class MesasDao implements DaoInterface<Mesas> {
    
    
    @Override
    
    public int criar(Mesas m){
        int unumero = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();//getConexao = metodo statico que vai devolver conexão unica com banco de dados
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("insert into mesas"
                    + "(tipo ,numero_cadeiras) "
                    + "values(?, ?);");
            
            
            pstmt.setString(1, m.getTipo());
            pstmt.setInt(2, m.getNumero_cadeiras());
            
            
            // Reuso da variavel unumero
            unumero = pstmt.executeUpdate();
            unumero = getunumero();

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
            return 0;
        }
        return unumero;
    
    }
    
    @Override
    public ArrayList<Mesas> buscar(Mesas m)
    {
        ArrayList<Mesas> ml = new ArrayList<Mesas>();//instancio a classe mesa

        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (m == null)
            {
                // Seleciona todos as mesas se nenhum exemplo passado
                pstmt = con.prepareStatement("select numero, tipo, numero_cadeiras" +
                         "from mesas;");
            } else
            {
                // Seleciona a mesa a partir do exemplo
                pstmt = con.prepareStatement("select numero,tipo ,numero_cadeiras" +
                  
                         "from mesas " +
                        " where numero = ?;");
                pstmt.setInt(1, m.getNumero());
            }

            ResultSet rs = pstmt.executeQuery();//execução da consulta, o resultdo da consuta vai parar em RS

            while (rs.next())
            {
                ml.add(new Mesas(
                        rs.getInt(1),// adiciona alguma coisa la dentro, ex= add empregado
                        rs.getString(2),
                        rs.getInt(3)));
            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return ml;// devolve o arreylist qeu foi reconstruido com todos os dados
    }

    @Override
    public int atualizar(Mesas m)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("update mesas "
                    + "tipo = ?, numero_cadeiras = ?, "
                    + "where numero = ?;");
            
            
            pstmt.setString(1, m.getTipo());
            pstmt.setInt(2, m.getNumero_cadeiras());
            pstmt.setInt(3, m.getNumero());

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
    public int apagar(Mesas m)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from mesas "
                    + "where numero = ?;");

            pstmt.setInt(1, m.getNumero());

            aux = pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            return 0;
        }
        return aux;
    }

    public static int getunumero()
    {
        int unumero = 0;


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
                unumero = rs.getInt(1);
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return unumero;
    }
    
}
