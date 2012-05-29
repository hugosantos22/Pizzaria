/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Contas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Hugo Santos
 */
public class ContasDao implements DaoInterface<Contas>{
    @Override
    public int criar(Contas c)
    {
        int ucodigo = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("insert into contas"
                    + "(valor_total, data,hora,pedidos) "
                    + "values(?, ?, ?,?);");
            
            pstmt.setFloat(1, c.getValor_total());
            pstmt.setString(2, c.getData());
            pstmt.setString(3, c.getHora());
            pstmt.setInt(4, c.getPedido());

            
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
    public ArrayList<Contas> buscar(Contas c)
    {
        ArrayList<Contas> cl = new ArrayList<Contas>();

        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (c == null)
            {
                // Seleciona todos as contas se nenhum exemplo passado
                pstmt = con.prepareStatement("select valor_total , datahora "
                        + "from contas ;");
            } else
            {
                // Seleciona contas a partir do exemplo
                pstmt = con.prepareStatement("select valor_total , datahora "
                        + "from contas " +
                        " where codigo = ?;");
                pstmt.setInt(1, c.getCodigo());
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
//           {
//                cl.add(new Contas(rs.getInt(1),
 //                       rs.getFloat(2),
 //                       rs.getDate(3)));
//            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return cl;
    }

    @Override
    public int atualizar(Contas c)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("update Contas "
                    + "decricao = ? , datahora = ? "
                    + "where codigo = ?;");
            
            pstmt.setFloat(1, c.getValor_total());
           // pstmt.setDate(2, p.getDatahora());

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
    public int apagar(Contas c)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from Contas "
                    + "where codigo = ?;");

            pstmt.setInt(1, c.getCodigo());

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
