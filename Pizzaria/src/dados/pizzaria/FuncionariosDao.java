/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

import br.pizzaria.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Saulo Francisco
 */
public class FuncionariosDao implements DaoInterface<Funcionarios> {
    
    
    @Override
    
    public int criar(Funcionarios f){
        int ucodigo = 0;
        String senha;
        try
        {
            Connection con = ConectaBanco.getConexao();//getConexao = metodo statico que vai devolver conexão unica com banco de dados
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("insert into funcionario"
                    + "(nome, funcao, salario,usuario,senha) "
                    + "values(?, ?, ?,?,?);");
            
            

            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getFuncao());
            pstmt.setFloat(3, f.getSalario());
            pstmt.setString(4, f.getUsuario());
            senha = criptografa(f.getSenha());
            pstmt.setString(5,senha);
            
            
            
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
    public ArrayList<Funcionarios> buscar(Funcionarios f){
        
        ArrayList<Funcionarios> fl = new ArrayList<Funcionarios>();//instancio a classe mesa

        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            if (f == null)
            {
                // Seleciona todos os funcionarios se nenhum exemplo passado
                pstmt = con.prepareStatement("select codigo,nome, funcao, salario,usuario,senha " +
                         "from funcionario ");
            } else
            {
                // Seleciona a mesa a partir do exemplo
                pstmt = con.prepareStatement("select codigo,nome, funcao, salario,usuario,senha " +
                         "from funcionario " +
                        " where usuario = ? and senha = ?;");
                pstmt.setString(1, f.getUsuario());
                pstmt.setString(2,f.getSenha());
            }

            ResultSet rs = pstmt.executeQuery();//execução da consulta, o resultdo da consuta vai parar em RS

            while (rs.next())
            {
                fl.add(new Funcionarios(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6)));
                
            }

            pstmt.close();

        } catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }

        return fl;// devolve o arreylist qeu foi reconstruido com todos os dados
    }

    @Override
    public int atualizar(Funcionarios f)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("select senha from funcionarios "
                    + "where codigo = ?;");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                if(!rs.getString(1).equals(f.getSenha())){
                    f.setSenha(criptografa(f.getSenha()));
                }
            }
            pstmt = con.prepareStatement("update funcionarios "
                    + "nome = ?, "
                    + "funcao = ?,salario = ?"
                    + "where codigo = ?;");           
            
            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getFuncao());
            pstmt.setFloat(3, f.getSalario());
            pstmt.setInt(4, f.getCodigo());

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
    public int apagar(Funcionarios f)
    {
        int aux = 0;
        try
        {
            Connection con = ConectaBanco.getConexao();
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("delete from funcionario "
                    + "where codigo = ?;");

            pstmt.setInt(1, f.getCodigo());

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
   public static final String criptografa(String senha)
    {
        // Aumenta a complexidade da senha digitada pelo usuário
        // ser descoberta se o banco de dados for analisado
        senha = "5tR1n6_d171C1l" + senha;

        // Converte a senha em um vetor de bytes
        byte[] defBytes = senha.getBytes();
        byte msgDigest[];
        StringBuilder buf = null;

        try {
            MessageDigest algoritmo = MessageDigest.getInstance("MD5");
            algoritmo.reset();
            algoritmo.update(defBytes);
            msgDigest = algoritmo.digest();

            buf = new StringBuilder();
            for (int i = 0; i < msgDigest.length; i++) {
                buf.append(Integer.toHexString(0xFF & msgDigest[i]));
            }

        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }

        return buf.toString();
    }   
}
