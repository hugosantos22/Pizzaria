/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JCadCliente.java
 *
 * Created on 08/10/2011, 17:52:20
 */
package gui.pizzaria;


import br.pizzaria.Clientes;
import dados.pizzaria.ClientesDao;
import dados.pizzaria.PizzariaDao;
import dados.pizzaria.ConectaBanco;

/**
 *
 * @author Hugo Santos
 */
public class JCadCliente extends javax.swing.JPanel {

    /** Creates new form JCadCliente */
    public JCadCliente() {
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

        playout = new javax.swing.JPanel();
        ltitulo = new javax.swing.JLabel();
        playout2 = new javax.swing.JPanel();
        pdadospessoais = new javax.swing.JPanel();
        cpf = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        ltelefone = new javax.swing.JLabel();
        lcpf = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        lrg = new javax.swing.JLabel();
        lnome = new javax.swing.JLabel();
        pendereco = new javax.swing.JPanel();
        cep = new javax.swing.JTextField();
        lcep = new javax.swing.JLabel();
        lrua = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        lbairro = new javax.swing.JLabel();
        lnumero = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        bfechar = new javax.swing.JButton();
        bsalvar = new javax.swing.JButton();
        blimpar = new javax.swing.JButton();

        playout.setBackground(new java.awt.Color(102, 102, 255));

        ltitulo.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36));
        ltitulo.setText("Cadastro de Clientes");

        javax.swing.GroupLayout playoutLayout = new javax.swing.GroupLayout(playout);
        playout.setLayout(playoutLayout);
        playoutLayout.setHorizontalGroup(
            playoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playoutLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(ltitulo)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        playoutLayout.setVerticalGroup(
            playoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playoutLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(ltitulo)
                .addGap(23, 23, 23))
        );

        playout2.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout playout2Layout = new javax.swing.GroupLayout(playout2);
        playout2.setLayout(playout2Layout);
        playout2Layout.setHorizontalGroup(
            playout2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        playout2Layout.setVerticalGroup(
            playout2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        pdadospessoais.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        pdadospessoais.setToolTipText("Dados Pessoais");

        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });

        nome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        ltelefone.setText("Telefone:");

        lcpf.setText("CPF:");

        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });

        lrg.setText("RG:");

        lnome.setText("Nome:");

        javax.swing.GroupLayout pdadospessoaisLayout = new javax.swing.GroupLayout(pdadospessoais);
        pdadospessoais.setLayout(pdadospessoaisLayout);
        pdadospessoaisLayout.setHorizontalGroup(
            pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdadospessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pdadospessoaisLayout.createSequentialGroup()
                        .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lnome)
                            .addComponent(lcpf))
                        .addGap(33, 33, 33)
                        .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdadospessoaisLayout.createSequentialGroup()
                                .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(telefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                    .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addComponent(lrg)
                                .addGap(18, 18, 18)
                                .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(ltelefone))
                .addContainerGap())
        );
        pdadospessoaisLayout.setVerticalGroup(
            pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdadospessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnome)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcpf)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lrg))
                .addGap(18, 18, 18)
                .addGroup(pdadospessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ltelefone))
                .addGap(28, 28, 28))
        );

        pendereco.setName("Endereço"); // NOI18N

        lcep.setText("CEP:");

        lrua.setText("Rua:");

        lbairro.setText("Bairro:");

        lnumero.setText("Numero:");

        javax.swing.GroupLayout penderecoLayout = new javax.swing.GroupLayout(pendereco);
        pendereco.setLayout(penderecoLayout);
        penderecoLayout.setHorizontalGroup(
            penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penderecoLayout.createSequentialGroup()
                        .addGroup(penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbairro)
                            .addComponent(lrua))
                        .addGap(32, 32, 32)
                        .addGroup(penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bairro, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                            .addComponent(rua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)))
                    .addGroup(penderecoLayout.createSequentialGroup()
                        .addComponent(lnumero)
                        .addGap(23, 23, 23)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(lcep)
                        .addGap(18, 18, 18)
                        .addComponent(cep, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );
        penderecoLayout.setVerticalGroup(
            penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(penderecoLayout.createSequentialGroup()
                        .addComponent(lrua)
                        .addGap(18, 18, 18)
                        .addGroup(penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbairro)
                            .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(penderecoLayout.createSequentialGroup()
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGap(18, 18, 18)
                .addGroup(penderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnumero)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lcep))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        bfechar.setText("Fechar");
        bfechar.setActionCommand("bfechar");
        bfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfecharActionPerformed(evt);
            }
        });

        bsalvar.setText("Salvar");
        bsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalvarActionPerformed(evt);
            }
        });

        blimpar.setText("Limpar");
        blimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pendereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bfechar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(bsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(blimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pdadospessoais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(playout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(playout2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdadospessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bfechar)
                    .addComponent(blimpar)
                    .addComponent(bsalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(playout2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cpfActionPerformed

private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_telefoneActionPerformed

private void bfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfecharActionPerformed
FCadCliente.getinstacia().setVisible(false);
}//GEN-LAST:event_bfecharActionPerformed

private void blimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimparActionPerformed
//limpando os campos
    nome.setText(" ");
cpf.setText(" ");
rg.setText(" ");
telefone.setText(" ");
rua.setText(" ");
bairro.setText(" ");
numero.setText(" ");
cep.setText(" ");

}//GEN-LAST:event_blimparActionPerformed

private void bsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalvarActionPerformed
        
    ClientesDao cDao = PizzariaDao.novoClientesDao();
    Clientes c = new Clientes();
   //salvando os dados dos clientes
    c.setNome(nome.getText());
    c.setCpf(cpf.getText());
    c.setRg(rg.getText());
    c.setTelefone(telefone.getText());
    c.setRua(rua.getText());
    c.setBairro(bairro.getText());
    c.setNumero(Integer.parseInt(numero.getText()));
    c.setCep(cep.getText());
    
    ConectaBanco.setBanco(ConectaBanco.MYSQL);
    int codigo = cDao.criar(c);
    c.setCodigo(codigo);
    
}//GEN-LAST:event_bsalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JButton bfechar;
    private javax.swing.JButton blimpar;
    private javax.swing.JButton bsalvar;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel lbairro;
    private javax.swing.JLabel lcep;
    private javax.swing.JLabel lcpf;
    private javax.swing.JLabel lnome;
    private javax.swing.JLabel lnumero;
    private javax.swing.JLabel lrg;
    private javax.swing.JLabel lrua;
    private javax.swing.JLabel ltelefone;
    private javax.swing.JLabel ltitulo;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField numero;
    private javax.swing.JPanel pdadospessoais;
    private javax.swing.JPanel pendereco;
    private javax.swing.JPanel playout;
    private javax.swing.JPanel playout2;
    private javax.swing.JTextField rg;
    private javax.swing.JTextField rua;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}