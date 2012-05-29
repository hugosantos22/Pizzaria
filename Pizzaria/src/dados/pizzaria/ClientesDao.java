/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hugo Santos
 */
public class ClientesDao implements DaoInterface<Clientes> {
    
    
    @Override
    public int criar(Clientes c)
    {
        int ucodigo = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();  //fazendo a conecxao com o banco
            PreparedStatement pstmt;
                //fazendo a inserção no banco
            pstmt = con.prepareStatement("insert into clientes"
                    + "(nome, cpf, rg, telefone,end_rua, end_bairro, end_numero, end_cep) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?);");
            //pegando o os valores das variaveis e iserindo no banco
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getCpf());
            pstmt.setString(3, c.getRg());
            pstmt.setString(4, c.getTelefone());
            pstmt.setString(5, c.getRua());
            pstmt.setString(6, c.getBairro());
            pstmt.setInt(7, c.getNumero());
            pstmt.setString(8, c.getCep());
            
            // Reuso da variavel ucodigo
            ucodigo = pstmt.executeUpdate();
            ucodigo = getucodigo();
                //fechando a conecxão
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
    public ArrayList<Clientes> buscar(Clientes c)
    {
        ArrayList<Clientes> cl = new ArrayList<Clientes>();

        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (c == null)
            {
                // Seleciona todos os clientes se nenhum exemplo passado
                pstmt = con.prepareStatement("select nome, cpf," +
                        " rg, telefone, end_rua, end_bairro ,end_numero ,end_cep "
                        + "from clientes ;");
            } else
            {
                // Seleciona clientes a partir do exemplo
                pstmt = con.prepareStatement("select nome, cpf," +
                        " rg, telefone, end_rua, end_bairro ,end_numero ,end_cep "
                        + "from clientes " +
                        " where codigo = ?;");
                pstmt.setInt(1, c.getCodigo());
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                cl.add(new Clientes(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9)));
            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return cl;
    }

    @Override
    public int atualizar(Clientes c)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("update clientes "
                    + "nome = ?, "
                    + "cpf = ?, rg = ?, telefone = ? end_rua = ?, "
                    + "end_bairro = ?, end_numero = ?, end_cep = ? "
                    + "where codigo = ?;");
            
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getCpf());
            pstmt.setString(3, c.getRg());
            pstmt.setString(4, c.getTelefone());
            pstmt.setString(5, c.getRua());
            pstmt.setString(6, c.getBairro());
            pstmt.setInt(7, c.getNumero());
            pstmt.setString(8, c.getCep());
            pstmt.setInt(9, c.getCodigo());

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
    public int apagar(Clientes c)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from clientes"
                    + " "
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
        //metodo para pegar o ultimo codigo
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
