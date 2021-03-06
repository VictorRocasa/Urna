/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.View;

import ifsudestemg.Controller.EleicaoController;
import ifsudestemg.Controller.EleitorController;
import ifsudestemg.Controller.PartidarioController;
import ifsudestemg.Controller.PartidoController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victorPC
 */
public class ViewAreaInternaFiscal extends javax.swing.JFrame {
    EleitorController eleitorController = new EleitorController();
    private int idEleitor;

    ViewAreaInternaFiscal(String cpf) throws ClassNotFoundException, SQLException {
        initComponents();
        idEleitor = eleitorController.consultarID(cpf);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTextoBoasVindas = new javax.swing.JLabel();
        btnVotarEleicao = new javax.swing.JButton();
        btnAlterarCadastro = new javax.swing.JButton();
        btnCRUDEleicao = new javax.swing.JButton();
        btnCadastrarPartido = new javax.swing.JButton();
        btnCadastrarCandidato = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urna Online");

        lblTextoBoasVindas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTextoBoasVindas.setText("Bem vindo!");

        btnVotarEleicao.setText("Votar em eleição");
        btnVotarEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarEleicaoActionPerformed(evt);
            }
        });

        btnAlterarCadastro.setText("Alterar dados cadastrais");
        btnAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCadastroActionPerformed(evt);
            }
        });

        btnCRUDEleicao.setText("CRUD Eleição");
        btnCRUDEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRUDEleicaoActionPerformed(evt);
            }
        });

        btnCadastrarPartido.setText("CRUD Partido");
        btnCadastrarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPartidoActionPerformed(evt);
            }
        });

        btnCadastrarCandidato.setText("CRUD Partidario");
        btnCadastrarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCandidatoActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTextoBoasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCadastrarCandidato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrarPartido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCRUDEleicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVotarEleicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTextoBoasVindas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVotarEleicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterarCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCRUDEleicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarPartido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarCandidato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnVotarEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarEleicaoActionPerformed
        this.setVisible(false);
        new ViewVotar(this,idEleitor).setVisible(true);
    }//GEN-LAST:event_btnVotarEleicaoActionPerformed

    private void btnCRUDEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRUDEleicaoActionPerformed
        this.setVisible(false);
        EleicaoController eleicaoController = new EleicaoController();
        ViewCRUDEleicao viewCRUDEleicao = new ViewCRUDEleicao(this,eleicaoController);
        viewCRUDEleicao.setVisible(true);
    }//GEN-LAST:event_btnCRUDEleicaoActionPerformed

    private void btnCadastrarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPartidoActionPerformed
        this.setVisible(false);
        PartidoController partidoController = new PartidoController();
        ViewCRUDPartido viewCRUDPartido = new ViewCRUDPartido(this,partidoController);
        viewCRUDPartido.setVisible(true);
    }//GEN-LAST:event_btnCadastrarPartidoActionPerformed

    private void btnCadastrarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCandidatoActionPerformed
        this.setVisible(false);
        PartidarioController partidarioController = new PartidarioController();
        ViewCRUDPartidario viewCRUDPartidario = new ViewCRUDPartidario(this,partidarioController);
        viewCRUDPartidario.setVisible(true);
    }//GEN-LAST:event_btnCadastrarCandidatoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        ViewRealizarLogin viewRealizarLogin = new ViewRealizarLogin();
        viewRealizarLogin.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCadastroActionPerformed
        this.setVisible(false);        
        try {
            new ViewCadastroEleitor(this,eleitorController,idEleitor).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAreaInternaFiscal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAreaInternaFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarCadastroActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarCadastro;
    private javax.swing.JButton btnCRUDEleicao;
    private javax.swing.JButton btnCadastrarCandidato;
    private javax.swing.JButton btnCadastrarPartido;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVotarEleicao;
    private javax.swing.JLabel lblTextoBoasVindas;
    // End of variables declaration//GEN-END:variables

}
