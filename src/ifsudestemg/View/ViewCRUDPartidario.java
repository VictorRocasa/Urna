/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.View;

import ifsudestemg.Controller.PartidarioController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorPC
 */
public class ViewCRUDPartidario extends javax.swing.JFrame {
    private PartidarioController partidarioController;
    private DefaultTableModel model;
    private javax.swing.JFrame origem;
    
    @Override
    public void setVisible(boolean bln){
        super.setVisible(bln);
        preencheTabela();
    }

    /**
     * Creates new form ViewCRUDEleitor
     */
    public ViewCRUDPartidario(javax.swing.JFrame origem, PartidarioController partidarioController) {
        this.origem = origem;
        this.partidarioController = partidarioController;
        initComponents();
    }
    
    public void preencheTabela(){
        String[] colunas = {"ID","CPF","Numero do Partido","Cargo no Partido"};
        model = new DefaultTableModel(colunas,0);
        Object[][] dados;
        try {
            dados = partidarioController.retornaDados();
            for (Object[] dado : dados) {
                Object[] linha = {dado[0], dado[1], dado[2], dado[3]};
                model.addRow(linha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erro ao consultar os registros, tente novamente mais tarde!","Erro!", 0);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"A primeira e a segunda senha não conferem!","Erro!", 0);
        }
        this.tblPartidarios.setModel(model);
        this.tblPartidarios.removeColumn(this.tblPartidarios.getColumnModel().getColumn(0));
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidarios = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urna Online");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setText("Lista de partidarios existentes:");

        tblPartidarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPartidarios);

        btnNovo.setText("Novo partidario");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar partidario selecionado");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Ecluir partidario selecionado");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnVoltar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.setVisible(false);
        ViewCadastroPartidario viewCadastroPartidario = new ViewCadastroPartidario(this, partidarioController);
        viewCadastroPartidario.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int indice = this.tblPartidarios.getSelectedRow();
        if(indice !=-1){
            ViewCadastroPartidario viewCadastroPartidario = new ViewCadastroPartidario(this, partidarioController,(int) model.getValueAt(indice, 0),(""+model.getValueAt(indice, 1)),(""+model.getValueAt(indice, 2)),(""+model.getValueAt(indice, 3)));
            this.setVisible(false);
            viewCadastroPartidario.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this,"Aviso, selecione uma eleição para ser editada!","Aviso!", 2);    
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int indice = this.tblPartidarios.getSelectedRow();
        if(indice !=-1){
            Object[] options = {"Confirmar", "Cancelar"};
            if(JOptionPane.showOptionDialog(null, "Deseja mesmo excluir o partidario de CPF "+(""+model.getValueAt(indice, 1)).toLowerCase()+", afiliado ao partido de número "+(""+model.getValueAt(indice, 2)).toLowerCase()+" e com cargo equivalente à "
            +(""+model.getValueAt(indice, 3)).toLowerCase()+"?","Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]) == 0)
            {
                try{
                    partidarioController.excluirPorId((int) model.getValueAt(indice, 0));
                    JOptionPane.showMessageDialog(this,"Deletado com sucesso!","Sucesso!", 1);
                    preencheTabela();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,"Erro ao excluir o registro, tente novamente mais tarde!","Erro!", 0);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this,"A primeira e a segunda senha não conferem!","Erro!", 0);
                }  
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Aviso, selecione um partidario para ser excluida!","Aviso!", 2);    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        origem.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblPartidarios;
    // End of variables declaration//GEN-END:variables
}
