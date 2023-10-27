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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        botonDietasFinalizadas = new javax.swing.JRadioButton();
        botonDietasNoFinalizadas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        salirControlTratamiento = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Control Tratamientos");

        buttonGroup1.add(botonDietasFinalizadas);
        botonDietasFinalizadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonDietasFinalizadas.setText("Dietas Finalizadas");
        botonDietasFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDietasFinalizadasActionPerformed(evt);
            }
        });

        buttonGroup1.add(botonDietasNoFinalizadas);
        botonDietasNoFinalizadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salirControlTratamiento)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(botonDietasFinalizadas)
                            .addGap(211, 211, 211)
                            .addComponent(botonDietasNoFinalizadas))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonDietasFinalizadas)
                    .addComponent(botonDietasNoFinalizadas))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(salirControlTratamiento)
                .addGap(45, 45, 45))
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salirControlTratamiento;
    // End of variables declaration//GEN-END:variables
//    private static class jComboPaciente {
//
//        private static void addItem(Object object) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        public jComboPaciente() {
//        }
//    }

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
