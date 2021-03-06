package app;

import DAO.Connect;
import EDA.Empresa;
import EDA.Item;
import EDA.Movimentacao;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author UDESC
 */
public class VisualizarEmpresas extends javax.swing.JFrame {

    private javax.swing.JButton jButton2;
    private Object JButton2;

    /**
     * Creates new form VisualizarPacientes
     */
    public VisualizarEmpresas() {
        initComponents();
        carregarEmpresas();
        carregarNomes();
        
    }
    
    public void tratarSalvar()
    {
        int qtd_acao = 0, tipo = 0, empresa_id = 0;
        double valor_acao = 0.00;
        try
        {
        qtd_acao = Integer.parseInt( salvar.getText());
        Empresa selected =(Empresa)combobox.getSelectedItem();
        empresa_id = selected.id;
        valor_acao = (double)selected.capitalSocial;
        valor_acao = valor_acao/1000;
        if(comprar.isSelected())
        {
        tipo = 1;
        }
        else
        {
        tipo = 2;
        }
        }catch(NumberFormatException e)
                {
                    
                }
        Movimentacao movimentacao = new Movimentacao(tipo, empresa_id, valor_acao, qtd_acao);
        
        boolean resultado = false;
        try {
            resultado = Main.getBD().cadastrarMovimentacao(movimentacao);
        } catch (SQLException sQLException) {
        }
        if(resultado == false)
        {
            showErroBD();
        }
    }
    
    private void showErroBD(){
        JOptionPane.showMessageDialog(this, "Ocorreu algum erro ao registrar dados no BD!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaosair = new javax.swing.JButton();
        combobox = new javax.swing.JComboBox<>();
        comprar = new javax.swing.JRadioButton();
        vender = new javax.swing.JRadioButton();
        salvar = new javax.swing.JButton();
        grafico = new javax.swing.JButton();
        qtd = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(close());
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bolsa de Valores");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Visualizar Empresas e compra de ações");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                null
            },
            new String [] {
                "Nome", "Capital", "Ramo"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        botaosair.setText("< Sair");
        botaosair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaosairActionPerformed(evt);
            }
        });

        buttonGroup1.add(comprar);
        comprar.setText("Comprar");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        buttonGroup1.add(vender);
        vender.setText("Vender");
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });

        salvar.setText("Salvar >");
        salvar.setToolTipText("");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        grafico.setText("grafico");
        grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoActionPerformed(evt);
            }
        });

        qtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comprar)
                    .addComponent(vender))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaosair, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(grafico, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comprar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vender))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grafico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(botaosair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void botaosairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaosairActionPerformed
        close();
        this.dispose();
    }//GEN-LAST:event_botaosairActionPerformed
    
    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprarActionPerformed

    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed
        
    }//GEN-LAST:event_venderActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvarActionPerformed

    private void graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoActionPerformed
        close2();
        this.dispose();
    }//GEN-LAST:event_graficoActionPerformed

    private void qtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtdActionPerformed
    
    private int close2()
    {
        try{
           Main.showGrafico(); 
        }
        catch(Exception e){
            System.out.println("erro.");
        }
        return DISPOSE_ON_CLOSE; 
    }
    
    int close(){
        Main.showBDV();
        return DISPOSE_ON_CLOSE; 
    }
    
    private void carregarNomes()
    {                             
        Connect bd = Main.getBD();
        ArrayList<Empresa> empresas = bd.getEmpresas();
        for( Empresa e : empresas ){
            Empresa empresa = new Empresa(e.id,e.nome, e.capitalSocial, e.ramo_id, e.ramo_desc);
            combobox.addItem(empresa.toString());
        }
    }
    
    
     private void carregarEmpresas(){
        Connect bd = Main.getBD();
        ArrayList<Empresa> empresas = bd.getEmpresas();
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        while( modelo.getRowCount() > 0 )
            modelo.removeRow( 0 );
                ArrayList<String> buttonList = new ArrayList<>();
    
        for( Empresa e : empresas ){
            JButton button2 = new JButton();
            modelo.addRow( new Object[]{e.nome, e.capitalSocial, e.ramo_desc });
            
        }
//      jButton2.setText("Ver");
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt, 1);
//            }
//            
//        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, int id)
//        {                                        
//        } 
//        });
    }
//       private void quantidadeActionPerformed(java.awt.event.ActionEvent evt) {                                           
//        int i = 0;
//        Integer[] numeros = new Integer[i];
//        for(i=0; i<10; i++)
//        {
//            
//            numeros[i] = i;
//            quantidade.addItem(numeros[i]);
//        }
//        
//        JComboBox qtd = new JComboBox(numeros);
//        
//        qtd.setLayout(new FlowLayout());
//        qtd.setSize(400,300);
//        setTitle("Quantidade");
//        
//        qtd.setSelectedIndex(1);
//        qtd.addActionListener(quantidadeActionPerformed);
//        add.
//    }  
     
     
       
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaosair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JRadioButton comprar;
    private javax.swing.JButton grafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField qtd;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabela;
    private javax.swing.JRadioButton vender;
    // End of variables declaration//GEN-END:variables
   private javax.swing.JComboBox<Integer> quantidade;
   
   
}
