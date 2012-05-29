/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.pizzaria;

/**
 *
 * @author Hugo Santos
 */
public class PizzariaDao {
    
    public static ClientesDao novoClientesDao()
    {
        return new ClientesDao();
    }
     public static FuncionariosDao novoFuncionariosDao()
    {
        return new FuncionariosDao();
    }
      public static MesasDao novoMesasDao()
    {
        return new MesasDao();
    }
     public static Itens_CardapiosDao novoItens_CardapiosDao()
    {
        return new Itens_CardapiosDao();
    }
     
     public static ReservasDao novoReservasDao()
    {
        return new ReservasDao();
    }
      public static PedidosDao novoPedidosDao()
    {
        return new PedidosDao();
    }
       public static Itens_PedidosDao novoItens_PedidosDao()
    {
        return new Itens_PedidosDao();
    }
      public static ContasDao novoContasDao()
    {
        return new ContasDao();
    }
}
