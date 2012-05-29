package dados.pizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBanco
{

    public static final int MYSQL = 0;
    public static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";
    private static final String MYSQLURL =
            "jdbc:mysql://127.0.0.1:3306/pizzaria";
    
    public static final int POSTGRESQL = 1;
    private static final String POSTGRESQLDRIVER = "org.postgresql.Driver";
    private static final String POSTGRESQLURL =
            "jdbc:postgresql://127.0.0.1:5432/pizzaria";
    
    public static final int SQLSERVEREXPRESS = 2;
    private static final String SQLSERVEREXPRESSDRIVER 
            = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            //= "net.sourceforge.jtds.jdbc.Driver";
    private static final String SQLSERVEREXPRESSURL
            //= "jdbc:sqlserver://127.0.0.1:1433;databaseName=empresa";
            = "jdbc:jtds:sqlserver://127.0.0.1:1433/pizzaria";
    
    private static Connection conexao;
    private static String url;
    private static String usuario;
    private static String senha;
    private static int banco;

    public static String getUrl()
    {
        return url;
    }

    public static void setUrl(String aUrl)
    {
        url = aUrl;
    }

    public static String getUsuario()
    {
        return usuario;
    }

    public static void setUsuario(String aUsuario)
    {
        usuario = aUsuario;
    }

    public static String getSenha()
    {
        return senha;
    }

    public static void setSenha(String aSenha)
    {
        senha = aSenha;
    }

    public static int getBanco()
    {
        return banco;
    }

    public static void setBanco(int aBanco)
    {
        banco = aBanco;
    }

    private ConectaBanco()
    {
    }

    public static void ajustaParametros(String url, String usuario,
            String senha, int banco)
    {
        ConectaBanco.setUrl(url);
        ConectaBanco.setUsuario(usuario);
        ConectaBanco.setSenha(senha);
        ConectaBanco.setBanco(banco);
    }

    public static Connection getConexao()
    {
        if (conexao == null)
        {
            try
            {
                switch (getBanco())
                { 
                    case MYSQL:
                        setUrl(getUrl() == null || getUrl().equals("") ? MYSQLURL : getUrl());
                        setUsuario(getUsuario() == null || getUsuario().equals("") ? "root" : getUsuario());
                        setSenha(getSenha() == null || getSenha().equals("") ? "220990" : getSenha());
                        Class.forName(MYSQLDRIVER);
                        break;

                    case POSTGRESQL:
                        setUrl(getUrl() == null || getUrl().equals("") ? POSTGRESQLURL : getUrl());
                        setUsuario(getUsuario() == null || getUsuario().equals("") ? "postgres" : getUsuario());
                        setSenha(getSenha() == null || getSenha().equals("") ? "123456" : getSenha());
                        Class.forName(POSTGRESQLDRIVER);
                        break;

                    case SQLSERVEREXPRESS:
                        setUrl(getUrl() == null || getUrl().equals("") ? SQLSERVEREXPRESSURL : getUrl());
                        setUsuario(getUsuario() == null || getUsuario().equals("") ? " " : getUsuario());
                        setSenha(getSenha() == null || getSenha().equals("") ? " " : getSenha());
                        Class.forName(SQLSERVEREXPRESSDRIVER);
                        //Class.forName(SQLSERVEREXPRESSDRIVER);
                        break;
                }

                conexao = DriverManager.getConnection(getUrl(), getUsuario(), getSenha());

            } catch (ClassNotFoundException cnfex)
            {
                JOptionPane.showMessageDialog(null,
                        cnfex.getMessage(), "Classe nao encontrada",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException sqlex)
            {
                JOptionPane.showMessageDialog(null,
                        sqlex.getMessage(), "Erro na conexao com o banco de dados",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return conexao;
    }

    protected static void fechaConexao()
    {
        url = null;
        usuario = null;
        senha = null;
        
        try
        {
            if (conexao != null)
            {
                conexao.close();
                conexao = null;
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    protected void finalize()
    {
        System.out.println("ConectaBanco.finalize()");
        
        try
        {
            super.finalize();
        } catch (Throwable ex)
        {
            System.out.println(ex.getMessage());
        }
        
        fechaConexao();
    }
}
