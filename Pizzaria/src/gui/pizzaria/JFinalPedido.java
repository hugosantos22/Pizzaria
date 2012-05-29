/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFinalPedido.java
 *
 * Created on 23/11/2011, 14:40:43
 */
package gui.pizzaria;

import br.pizzaria.Contas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dados.pizzaria.ConectaBanco;
import dados.pizzaria.ContasDao;
import dados.pizzaria.PizzariaDao;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hugo Santos
 */
public class JFinalPedido extends javax.swing.JPanel {
    //variaveis de auxilio
    int numeropedido = 0;
    float valor = 0;
    /** Creates new form JFinalPedido */
    public JFinalPedido() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playout6 = new javax.swing.JPanel();
        ltitulo3 = new javax.swing.JLabel();
        tnomeclientefinal = new javax.swing.JTextField();
        lnomeclientefinal = new javax.swing.JLabel();
        tnumeromesafinal = new javax.swing.JTextField();
        lnumeromesafinal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaprodutosfinal = new javax.swing.JTable();
        lprodutosfinal = new javax.swing.JLabel();
        tdescricaofinal = new javax.swing.JTextField();
        ldescricaofinal = new javax.swing.JLabel();
        ldatafinal = new javax.swing.JLabel();
        tdatafinal = new javax.swing.JTextField();
        lhorafinal = new javax.swing.JLabel();
        thorafinal = new javax.swing.JTextField();
        Finalizar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        playout7 = new javax.swing.JPanel();

        playout6.setBackground(new java.awt.Color(102, 102, 255));

        ltitulo3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36));
        ltitulo3.setText("Finalizar Pedidos");

        javax.swing.GroupLayout playout6Layout = new javax.swing.GroupLayout(playout6);
        playout6.setLayout(playout6Layout);
        playout6Layout.setHorizontalGroup(
            playout6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playout6Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(ltitulo3)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        playout6Layout.setVerticalGroup(
            playout6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playout6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ltitulo3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tnomeclientefinal.setEditable(false);

        lnomeclientefinal.setText("Nome Cliente:");

        tnumeromesafinal.setEditable(false);

        lnumeromesafinal.setText("Numero Mesa:");

        tabelaprodutosfinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaprodutosfinal);

        lprodutosfinal.setText("Produtos:");

        tdescricaofinal.setEditable(false);

        ldescricaofinal.setText("Descricao:");

        ldatafinal.setText("Data:");

        tdatafinal.setEditable(false);

        lhorafinal.setText("Hora:");

        thorafinal.setEditable(false);

        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        playout7.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout playout7Layout = new javax.swing.GroupLayout(playout7);
        playout7.setLayout(playout7Layout);
        playout7Layout.setHorizontalGroup(
            playout7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        playout7Layout.setVerticalGroup(
            playout7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playout6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lnumeromesafinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tnumeromesafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lprodutosfinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lnomeclientefinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tnomeclientefinal, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ldescricaofinal)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ldatafinal)
                        .addGap(47, 47, 47)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tdatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lhorafinal)
                        .addGap(40, 40, 40)
                        .addComponent(thorafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tdescricaofinal, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(playout7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playout6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnomeclientefinal)
                    .addComponent(tnomeclientefinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnumeromesafinal)
                    .addComponent(tnumeromesafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(lprodutosfinal)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldescricaofinal)
                    .addComponent(tdescricaofinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldatafinal)
                    .addComponent(lhorafinal)
                    .addComponent(thorafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tdatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpar)
                    .addComponent(Finalizar)
                    .addComponent(fechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playout7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
   //salvando os dados das contas no banco de dados 
    //determinado por um pedido que contem a mesa e o cliente
    ContasDao cDao = PizzariaDao.novoContasDao();
    Contas c = new Contas();
    
    float a = valortotal();
    int b = pedido();
    
    c.setValor_total(a);
    c.setData(tdatafinal.getText());
    c.setHora(thorafinal.getText());
    c.setPedido(b);
    
    
     ConectaBanco.setBanco(ConectaBanco.MYSQL);
    int codigo = cDao.criar(c);
    c.setCodigo(codigo);
    
    FContas.getinstacia().setVisible(true);
    
    //enviando os resultados para um Formulario 
    JConta.tnomecliente.setText(tnomeclientefinal.getText());
    JConta.tnumeromesa.setText(tnumeromesafinal.getText());
    JConta.tdata.setText(tdatafinal.getText());
    JConta.thora.setText(thorafinal.getText());
    JConta.tvalortotal.setText(Float.toString(a));
    
    
    FFinalizarPedido.getinstacia().setVisible(false);
    FFinalPedido.getinstacia().setVisible(false);
    // TODO add your handling code here:
}//GEN-LAST:event_FinalizarActionPerformed

private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
//limpando campos
    tnomeclientefinal.setText(" ");
    tnumeromesafinal.setText(" ");
    tdescricaofinal.setText(" ");
    tdatafinal.setText(" ");
    thorafinal.setText(" ");
    
    // TODO add your handling code here:
}//GEN-LAST:event_limparActionPerformed

private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed

    FFinalPedido.getinstacia().setVisible(false);
    // TODO add your handling code here:
}//GEN-LAST:event_fecharActionPerformed
public  int pedido() {   //Função para busca o pedido relacinado a um cliente e a uma mesa
        try{
            Connection con = (Connection) ConectaBanco.getConexao();
            
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) con.prepareStatement("select pedidos.codigo as codigo "+
                "from pedidos "+
                "inner join mesas on mesas.numero = pedidos.mesa "+
                "inner join clientes on clientes.codigo = pedidos.cliente "+
                "where clientes.nome like ? and mesas.numero like ?;" );
                //enviando do campo texto os nome do clientes e o numero da mesa
            pstmt.setString(1, "%" + tnomeclientefinal.getText() + "%");
            pstmt.setString(2, "%" + tnumeromesafinal.getText() + "%");
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                numeropedido=rs.getInt(1);
            }
            //numeropedido = rs.getInt("codigo");
            
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("ERRO " + e);
        }
        
        return numeropedido;  //retornando um resulado do pedido do cliente e mesa
}
public float valortotal() {  //Função para busca o valor final da conta de determinado pedido
        try{
            Connection con = (Connection) ConectaBanco.getConexao();
            
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) con.prepareStatement("select sum(item_cardapio.valor) as valor "+
            "from pedidos "+
               "inner join iten_pedidos on iten_pedidos.pedido = pedidos.codigo "+
             "inner join item_cardapio on iten_pedidos.item_cardapio = item_cardapio.codigo "+	
             "where pedidos.codigo like ? "+
             "group by pedidos.codigo; " );
            //Mandando o codigo do pedido pra encontrar o valor da conta
            pstmt.setString(1, "%" + pedido() + "%" );
                       
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                valor = rs.getFloat(1);
            }
            //valor = rs.getFloat("valor");
            
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("ERRO " + e);
        }
        
        return valor;  // valor da conta
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Finalizar;
    private javax.swing.JButton fechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ldatafinal;
    private javax.swing.JLabel ldescricaofinal;
    private javax.swing.JLabel lhorafinal;
    private javax.swing.JButton limpar;
    private javax.swing.JLabel lnomeclientefinal;
    private javax.swing.JLabel lnumeromesafinal;
    private javax.swing.JLabel lprodutosfinal;
    private javax.swing.JLabel ltitulo3;
    private javax.swing.JPanel playout6;
    private javax.swing.JPanel playout7;
    public static javax.swing.JTable tabelaprodutosfinal;
    public static javax.swing.JTextField tdatafinal;
    public static javax.swing.JTextField tdescricaofinal;
    public static javax.swing.JTextField thorafinal;
    public static javax.swing.JTextField tnomeclientefinal;
    public static javax.swing.JTextField tnumeromesafinal;
    // End of variables declaration//GEN-END:variables
}