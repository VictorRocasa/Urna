/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author victorPC
 */
public class frDebug extends javax.swing.JFrame {

    /**
     * Creates new form frPrincipal
     */
    public frDebug() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrarEleitor = new javax.swing.JButton();
        btnCadastrarPartido = new javax.swing.JButton();
        btnCadastrarEleicao = new javax.swing.JButton();
        btnCadastrarCandidato = new javax.swing.JButton();
        lblTestes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Debug Urna");

        btnCadastrarEleitor.setText("Testar Cadastrar Eleitor");
        btnCadastrarEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEleitorActionPerformed(evt);
            }
        });

        btnCadastrarPartido.setText("Testar Cadastrar Partido");
        btnCadastrarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPartidoActionPerformed(evt);
            }
        });

        btnCadastrarEleicao.setText("Testar Cadastrar Eleição");
        btnCadastrarEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEleicaoActionPerformed(evt);
            }
        });

        btnCadastrarCandidato.setText("Testar Cadastrar Candidato");
        btnCadastrarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCandidatoActionPerformed(evt);
            }
        });

        lblTestes.setText("Tela de debug para testes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCadastrarCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrarEleicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrarPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrarEleitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTestes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTestes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrarEleitor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarPartido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarEleicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarCandidato)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEleicaoActionPerformed
        this.dispose();
        new frCadastroEleicao().setVisible(true);
    }//GEN-LAST:event_btnCadastrarEleicaoActionPerformed

    private void btnCadastrarEleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEleitorActionPerformed
        this.dispose();
        new frCadastroEleitor().setVisible(true);
    }//GEN-LAST:event_btnCadastrarEleitorActionPerformed

    private void btnCadastrarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPartidoActionPerformed
        this.dispose();
        new frCadastroPartido().setVisible(true);
    }//GEN-LAST:event_btnCadastrarPartidoActionPerformed

    private void btnCadastrarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCandidatoActionPerformed
        this.dispose();
        new frCadastroCandidato().setVisible(true);
    }//GEN-LAST:event_btnCadastrarCandidatoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCandidato;
    private javax.swing.JButton btnCadastrarEleicao;
    private javax.swing.JButton btnCadastrarEleitor;
    private javax.swing.JButton btnCadastrarPartido;
    private javax.swing.JLabel lblTestes;
    // End of variables declaration//GEN-END:variables
}
