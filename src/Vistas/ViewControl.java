/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.DietaDAO;
import Entidades.Dieta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewControl extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();

    public ViewControl() {
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

        jLabel1 = new javax.swing.JLabel();
        botonDietasFinalizadas = new javax.swing.JRadioButton();
        botonDietasNoFinalizadas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        salirControlTratamiento = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Control Tratamientos");

        botonDietasFinalizadas.setText("Dietas Finalizadas");
        botonDietasFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDietasFinalizadasActionPerformed(evt);
            }
        });

        botonDietasNoFinalizadas.setText("Dietas no Finalizadas");

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
        jScrollPane1.setViewportView(jTable1);

        salirControlTratamiento.setText("Salir");
        salirControlTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirControlTratamientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonDietasFinalizadas)
                                .addGap(18, 18, 18)
                                .addComponent(botonDietasNoFinalizadas)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(salirControlTratamiento)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonDietasFinalizadas)
                    .addComponent(botonDietasNoFinalizadas))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(salirControlTratamiento)
                .addContainerGap(338, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salirControlTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirControlTratamientoActionPerformed
        Dashboard db = new Dashboard();
        this.setVisible(false);
        db.setVisible(true);
    }//GEN-LAST:event_salirControlTratamientoActionPerformed

    public void actualizarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        jTablaDietaDispo.setModel(modelo);
    }
    private void botonDietasFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDietasFinalizadasActionPerformed
        actualizarTabla();
        DietaDAO dietadao = new DietaDAO();
        ArrayList<Dieta> buscar = dietadao.buscar(1);
        for (Dieta i : buscar) {
            modelo.addRow(new Object[]{i.getIdDieta(), i.getNombre(), i.getPaciente(), i.getFechaInicial(), i.getFechaFinal(), i.isEstado(), i.getPesoFinal()});
        }
        jTablaDietaDispo.setModel(modelo);
    }//GEN-LAST:event_botonDietasFinalizadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonDietasFinalizadas;
    private javax.swing.JRadioButton botonDietasNoFinalizadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salirControlTratamiento;
    // End of variables declaration//GEN-END:variables

    private static class jComboPaciente {

        private static void addItem(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public jComboPaciente() {
        }
    }

    private static class jTablaDietaDispo {

        private static void setModel(DefaultTableModel modelo) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public jTablaDietaDispo() {
        }
    }

    private static class modelo {

        private static int getRowCount() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void removeRow(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void addRow(Object[] object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public modelo() {
        }
    }
}
