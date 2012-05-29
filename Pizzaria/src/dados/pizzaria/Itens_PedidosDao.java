/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Itens_Pedidos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hugo Santos
 */
public class Itens_PedidosDao implements DaoInterface<Itens_Pedidos> {
   
     @Override
    public int criar(Itens_Pedidos ip)
    {
        int ucodigo = 0;
        try
        {
            Connection con = (Connection) ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) con.prepareStatement("insert into iten_pedidos"
                    + "(quantidade,pedido,item_cardapio) "
                    + "values(?, ?, ?);");
            
            pstmt.setInt(1, ip.getQuantdade());
            pstmt.setInt(2, ip.getPedido());
            pstmt.setInt(3, ip.getItens_cardapio());
            
            
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
    public ArrayList<Itens_Pedidos> buscar(Itens_Pedidos ip)
    {
        ArrayList<Itens_Pedidos> cl = new ArrayList<Itens_Pedidos>();

        try
        {
            Connection con = (Connection) ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (ip == null)
            {
                // Seleciona todos os clientes se nenhum exemplo passado
                pstmt = (PreparedStatement) con.prepareStatement("select pedido , item_cardapio,quantidade "
                        + "from pedidos ;");
            } else
            {
                // Seleciona clientes a partir do exemplo
                pstmt = (PreparedStatement) con.prepareStatement("select descricao , datahora "
                        + "from pedidos " +
                        " where codigo = ?;");
                pstmt.setInt(1, ip.getCodigo());
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
    public int atualizar(Itens_Pedidos ip)
    {
        int aux = 0;
        try
        {
            Connection con = (Connection) ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) con.prepareStatement("update iten_Pedidos "
                    + "pedido = ? , item_cardapio = ?, quantidade "
                    + "where codigo = ?;");
            
            pstmt.setInt(1,ip.getPedido());
            pstmt.setInt(1,ip.getItens_cardapio());
            pstmt.setInt(1,ip.getQuantdade());
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
    public int apagar(Itens_Pedidos ip)
    {
        int aux = 0;
        try
        {
            Connection con = (Connection) ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) con.prepareStatement("delete from itens_pedidos "
                    + "where codigo = ?;");

            pstmt.setInt(1, ip.getCodigo());

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
            Connection con = (Connection) ConectaBanco.getConexao();
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
                    pstmt = (PreparedStatement) con.prepareStatement("select last_insert_id();");
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
