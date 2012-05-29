/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Hugo Santos
 */
public class PedidosDao  implements DaoInterface<Pedidos> {
    
    @Override
    public int criar(Pedidos p)
    {
        int ucodigo = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("insert into pedidos"
                    + "(descricao,data,hora,cliente,mesa) "
                    + "values(?, ?, ?, ?,?);");
            
            pstmt.setString(1, p.getDescricao());
            pstmt.setString(2, p.getData());
            pstmt.setString(3, p.getHora());
            pstmt.setInt(4, p.getCliente());
            pstmt.setInt(5, p.getMesa());
//            
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
    public ArrayList<Pedidos> buscar(Pedidos c)
    {
        ArrayList<Pedidos> cl = new ArrayList<Pedidos>();

        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (c == null)
            {
                // Seleciona todos os clientes se nenhum exemplo passado
                pstmt = con.prepareStatement("select descricao , datahora "
                        + "from pedidos ;");
            } else
            {
                // Seleciona clientes a partir do exemplo
                pstmt = con.prepareStatement("select descricao , datahora "
                        + "from pedidos " +
                        " where codigo = ?;");
                pstmt.setInt(1, c.getCodigo());
            }

            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next())
//            {
//                cl.add(new Pedidos(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getDate(3)));
//            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return cl;
    }

    @Override
    public int atualizar(Pedidos p)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("update Pedidos "
                    + "decricao = ? , datahora = ? "
                    + "where codigo = ?;");
            
            pstmt.setString(1, p.getDescricao());
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
    public int apagar(Pedidos c)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from Pedidos "
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
