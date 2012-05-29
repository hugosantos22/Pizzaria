/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;


import br.pizzaria.Reservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Saulo Francisco
 */
public class ReservasDao implements DaoInterface<Reservas>{
    

    @Override
    public int criar(Reservas r)//tenho que passar para criar um objeto do tipo reserva 
    {
        int ucodigo = 0;
        try// indicar o tente para ver se da erro
        {
            Connection con = ConectaBanco.getConexao();//getConexao = metodo statico que vai devolver conexão unica com banco de dados
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("insert into reservas"
                    + "(nome_cliente,numero_mesa,dia) "
                    + "values(?, ?, ?);");

            

            pstmt.setString(1, r.getNome_cliente());
            pstmt.setInt(2, r.getNumero_mesa());
            pstmt.setString(3, r.getDia());
            //pstmt.setObject(3, o.getNascimento());
            

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
    public ArrayList<Reservas> buscar(Reservas r)
    {
        ArrayList<Reservas> rl = new ArrayList<Reservas>();//instancio a classe reserva

        try// tente para ver se algo não da certo
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (r == null)
            {
                // Seleciona todas as reservas se nenhum exemplo o passado
                pstmt = con.prepareStatement("select codigo, nome_cliente,numero_mesa,dia "
                        + "from reservas;");
            } else
            {
                // Seleciona funcionario a partir do exemplo
                pstmt = con.prepareStatement("select c.codigo, identificacao_cliente "
                        + "from reservas as r join as identificacao_cliente as i on c.codigo= i.codigo "
                        + "where matricula = ?;");
                pstmt.setInt(1, r.getCodigo());
            }

            ResultSet rs = pstmt.executeQuery();//execução da consulta, o resultdo da consuLta vai parar em RS

            while (rs.next())
            {
                rl.add(new Reservas(
                        rs.getInt(1),// adiciona alguma coisa la dentro, ex= add reservas
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)));
                        
            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return rl;// devolve o arreylist qeu foi reconstruido com todos os dados
    }

    @Override
    public int atualizar(Reservas r)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("update reservas "
                    + "set nome_cliente = ?, numero_mesa = ?,dia = ? "
                    + "where codigo = ?;");

            pstmt.setString(1, r.getNome_cliente());
            pstmt.setDouble(2, r.getCodigo());

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
    public int apagar(Reservas r)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from reservas "
                    + "where codigo = ?;");

            pstmt.setInt(1, r.getCodigo());

            aux = pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            return 0;
        }
        return aux;
    }

    public static int getucodigo()// dependete da incrementação do banco de dados
    {
        int ucodigo = 0;


        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;
            
            switch (ConectaBanco.getBanco())
            {
               /* case ConectaBanco.POSTGRESQL:
                    pstmt = con.prepareStatement("select lastval();");
                    break;
                    
                case ConectaBanco.SQLSERVEREXPRESS:
                    pstmt = con.prepareStatement("select scope_identity();");
                    break;
                    */
                // case ConectaBanco.MYSQL:
                default:
                    pstmt = con.prepareStatement("select last_insert_id();");
                    break;
            }

            ResultSet rs = pstmt.executeQuery();//retornara valores

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