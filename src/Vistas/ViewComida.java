/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.ComidaDAO;
import Entidades.Comida;
import java.awt.HeadlessException;
import javax.swing.*;

public class ViewComida extends javax.swing.JPanel {

    ComidaDAO ComiData;

    public ViewComida() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComidas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTnombreComida = new javax.swing.JTextField();
        jTcantCalorias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTdetalleComida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBagregarComida = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jCestadoComida = new javax.swing.JRadioButton();
        botonSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        tablaComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID COMIDA", "NOMBRE COMIDA", "C. CALORIAS", "DIETA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaComidas);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("INGRESO DE COMIDAS");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setText("Nombre Comida : ");

        jLabel3.setText("Cant. Calorias :");

        jTnombreComida.setToolTipText("Ingrese el nombre de la comida");
        jTnombreComida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTnombreComidaKeyTyped(evt);
            }
        });

        jTcantCalorias.setToolTipText("Ingrese la Cantidad de Calorias");
        jTcantCalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTcantCaloriasKeyTyped(evt);
            }
        });

        jLabel4.setText("Detalle de Comida :");

        jTdetalleComida.setToolTipText("Describa la comida");
        jTdetalleComida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTdetalleComidaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("LISTA DE COMIDAS");

        jBagregarComida.setText("Agregar Comida");
        jBagregarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBagregarComidaActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado :");

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(botonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTnombreComida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCestadoComida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTcantCalorias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTdetalleComida, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jBagregarComida, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnombreComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jTdetalleComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTcantCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCestadoComida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jBagregarComida)))
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonSalir)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBagregarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBagregarComidaActionPerformed
       ComiData = new ComidaDAO();
        try {
            if (jTnombreComida.getText().isEmpty()
                    || jTdetalleComida.getText().isEmpty()
                    || jTcantCalorias.getText().isEmpty()
                    || !jCestadoComida.isSelected()) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los valores");
            } else {

                int cantc = Integer.parseInt(jTcantCalorias.getText());
                String nc = jTnombreComida.getText();
                String dc = jTdetalleComida.getText();
                boolean estc = jCestadoComida.getVerifyInputWhenFocusTarget();
                Comida comida = new Comida(cantc, nc, dc, estc);
                ComiData.insertar(comida);
            }
        } catch (HeadlessException | NumberFormatException e) {
            e.printStackTrace(System.out);
        }


    }//GEN-LAST:event_jBagregarComidaActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        Dashboard db=new Dashboard();
        this.setVisible(false);
        db.setVisible(true);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void jTnombreComidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTnombreComidaKeyTyped
        char c = evt.getKeyChar();
        if ((c< 'a' || c> 'z') && (c< 'A' || c> 'Z') && (c< ' ' || c> ' ')) evt.consume();
    }//GEN-LAST:event_jTnombreComidaKeyTyped

    private void jTdetalleComidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdetalleComidaKeyTyped
         char c = evt.getKeyChar();
        if ((c< 'a' || c> 'z') && (c< 'A' || c> 'Z') && (c< ' ' || c> ' ')) evt.consume();
    }//GEN-LAST:event_jTdetalleComidaKeyTyped

    private void jTcantCaloriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTcantCaloriasKeyTyped
        char c = evt.getKeyChar();
        if ((c< '0' || c> '9'))evt.consume();
        if(jTcantCalorias.getText().length()>3) evt.consume();
    }//GEN-LAST:event_jTcantCaloriasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton jBagregarComida;
    private javax.swing.JRadioButton jCestadoComida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTcantCalorias;
    private javax.swing.JTextField jTdetalleComida;
    private javax.swing.JTextField jTnombreComida;
    private javax.swing.JTable tablaComidas;
    // End of variables declaration//GEN-END:variables
}