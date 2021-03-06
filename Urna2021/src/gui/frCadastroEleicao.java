/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Candidato;
import classes.Persistencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author victorPC
 */
public class frCadastroEleicao extends javax.swing.JFrame {

    /**
     * Creates new form frCadastroEleicao
     */
    
    public frCadastroEleicao() {
        initComponents();
        
        try{
            MaskFormatter maskDia = new MaskFormatter("##/##/####");
            
            maskDia.install(this.ftxtData);
        }catch(ParseException ex){
        }
    }
    
    public boolean verificaData(String data){
        String[] partes = data.split("/");  
        Calendar cal = Calendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR); 
        int ano = Integer.parseInt(partes[2]);
        if(ano < anoAtual)
            return false;
        int mesAtual = cal.get(Calendar.MONTH)+1; 
        int mes = Integer.parseInt(partes[1]);
        if(mes < mesAtual)
            return false;
        if(mes < 1 || mes > 12)
            return false;
        int dia = Integer.parseInt(partes[0]);
        int diaAtual = cal.get(Calendar.DATE);
        if(dia <= diaAtual)
            return false; 
        if(dia < 1 || dia > 31)
            return false;
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
            if(dia > 30)
                return false;
        if(mes == 2){
            if(dia > 29)
                return false;
            else if(dia == 29 )
                if(!((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))))
                    return false;
        }
        return true;
    }
    
    public void limpaCampos(){
        this.ftxtData.setText("");
        this.txtCargo.setText("");
        this.txtRegiao.setText("");
        this.txtTurno.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtData1 = new javax.swing.JTextField();
        lblData1 = new javax.swing.JLabel();
        lblBarra1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblBarra2 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        lblTitulo1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblRegiao = new javax.swing.JLabel();
        txtRegiao = new javax.swing.JTextField();
        lblDia = new javax.swing.JLabel();
        ftxtData = new javax.swing.JFormattedTextField();
        txtTurno = new javax.swing.JTextField();

        lblData1.setText("Data:");

        jLabel1.setText("Cadastro eleitoral:");

        lblNome.setText("Nome completo:");

        jLabel2.setText("Nascimento:");

        jLabel3.setText("/");

        lblBarra2.setText("/");

        lblCPF.setText("CPF:");

        lblTitulo1.setText("Título de eleitor:");

        jButton1.setText("Canlelar");

        jButton2.setText("Confirmar");

        javax.swing.GroupLayout lblBarra1Layout = new javax.swing.GroupLayout(lblBarra1);
        lblBarra1.setLayout(lblBarra1Layout);
        lblBarra1Layout.setHorizontalGroup(
            lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblBarra1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addGroup(lblBarra1Layout.createSequentialGroup()
                        .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblBarra1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCPF)
                            .addComponent(lblTitulo1)
                            .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lblBarra1Layout.createSequentialGroup()
                                        .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(lblBarra1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(51, 51, 51))
                                            .addGroup(lblBarra1Layout.createSequentialGroup()
                                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addComponent(lblBarra2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(lblNome))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        lblBarra1Layout.setVerticalGroup(
            lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblBarra1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblBarra2)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lblBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimulaEleicao");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTitulo.setText("Cadatrar eleição para o sistema:");

        lblTurno.setText("Turno:");

        btnConfirmar.setText("Confirmar ");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCargo.setText("Cargo:");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        lblRegiao.setText("Região");

        txtRegiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegiaoActionPerformed(evt);
            }
        });

        lblDia.setText("Data da eleição:");

        ftxtData.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTurno)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurno)
                            .addComponent(lblCargo)
                            .addComponent(lblRegiao)
                            .addComponent(lblDia)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRegiao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                            .addComponent(ftxtData, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRegiao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftxtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTurno)
                .addGap(1, 1, 1)
                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public boolean validaCampos(){
        String cargo = this.txtCargo.getText();
        cargo = cargo.replace(" ", "");
        String regiao = this.txtRegiao.getText();
        regiao = regiao.replace(" ", "");
        String dia = this.ftxtData.getText();
        dia = dia.replace(" ", "");
        String turno = this.txtTurno.getText();
        turno = turno.replace(" ", "");
        if(cargo.equals("")){
            JOptionPane.showMessageDialog(null, "O campo cargo não deve ficar em branco!","Erro!", 2);
            return false;
        }
        if(regiao.equals("")){
            JOptionPane.showMessageDialog(null, "O campo regiao não deve ficar em branco!","Erro!", 2);
            return false;
        }
        if(dia.equals("//") ){
            JOptionPane.showMessageDialog(null, "O campo dia da eleição: não deve ficar em branco!","Erro!", 2);
            return false;
        }
        if(turno.equals("")){
            JOptionPane.showMessageDialog(null, "O campo turno não deve ficar em branco!","Erro!", 2);
            return false;
        }
        if(!cargo.matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(null, "Cargo inválido!","Erro!", 2);
            return false;
        }
        if(!regiao.matches("[A-Za-z]{3,}")){
            JOptionPane.showMessageDialog(null, "regiao inválido!","Erro!", 2);
            return false;
        }
        if(dia.length()!=10 || !verificaData(dia)){
            JOptionPane.showMessageDialog(null, "Data inválida!","Erro!", 2);
            return false;
        }
        return true;
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(!this.validaCampos())
            return;
        PreparedStatement ps = null;
        try{
            ps = Persistencia.conexao().prepareStatement("INSERT INTO eleicao (cargo,regiao,data_da_eleicao,turno) VALUES ('"+this.txtCargo.getText()+"','"+this.txtRegiao.getText()+"','"+this.ftxtData.getText()+"','"+this.txtTurno.getText()+"');");            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso.","Sucesso!", 1);
            this.limpaCampos();                  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Não foi possível conectar ao banco de dados.","Erro!", 2);           
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        new frDebug().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtRegiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegiaoActionPerformed

    private void txtTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTurnoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField ftxtData;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel lblBarra1;
    private javax.swing.JLabel lblBarra2;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRegiao;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtData1;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRegiao;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
