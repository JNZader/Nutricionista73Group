package Vistas;

import Conexion.ComidaDAO;
import Conexion.ConsultaDAO;
import Conexion.DietaDAO;
import Conexion.PacienteDAO;
import Entidades.Comida;
import Entidades.Consulta;
import Entidades.Dieta;
import Entidades.Paciente;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewBuscar extends javax.swing.JPanel {

    private String entidad, atributo, atributoTF;
    private int estado, tf;
    private DefaultTableModel modDieta, modPaciente, modComida, modConsulta;
    private ComidaDAO comidaDAO;
    private DietaDAO dietaDAO;
    private PacienteDAO pacienteDAO;
    private ConsultaDAO consultaDAO;

    public ViewBuscar() {
        initComponents();
        jButtonBuscar.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jRadioButtonActivo.setSelected(true);
        jComboBoxAtributos.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                jLabel3.setText(event.getItem().toString() + ":");
            }//lambda que agrega un itemlistener al combobox  y modifica el label de acuerdo al item seleccionado en el combo
        });
        JTableHeader tbh = jTable1.getTableHeader();
        tbh.setReorderingAllowed(false);
        jTable1.setTableHeader(tbh);
    }

    private void limpiarTabla() {
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        mod.setRowCount(0);
    }

    private void llenarTabla(Comida comida) {
        limpiarTabla();
        modComida = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modComida.setColumnIdentifiers(new String[]{"Comida", "ID", "Nombre", "Detalle", "Cantidad de calorias", "Estado"});

        if (comida != null) {
            Object[] filas = new Object[6];
            filas[0] = comida;
            filas[1] = comida.getIdComida();
            filas[2] = comida.getNombre();
            filas[3] = comida.getDetalle();
            filas[4] = comida.getCantCalorias();
            filas[5] = comida.isEstado();
            modComida.addRow(filas);
        }

        jTable1.setModel(modComida);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(30);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(30);
        jTable1.getColumnModel().getColumn(1).setWidth(30);
        jTable1.getColumnModel().getColumn(5).setMinWidth(50);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(5).setWidth(50);

    }
    private void llenarTabla(ArrayList<Comida> comidas) {
        limpiarTabla();        
        modComida = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modComida.setColumnIdentifiers(new String[]{"Comida", "ID", "Nombre", "Detalle", "Cantidad de calorias", "Estado"});

        if (comidas != null) {
            for (Comida aux : comidas) {
                Object[] filas = new Object[6];
                filas[0] = aux;
                filas[1] = aux.getIdComida();
                filas[2] = aux.getNombre();
                filas[3] = aux.getDetalle();
                filas[4] = aux.getCantCalorias();
                filas[5] = aux.isEstado();
                modComida.addRow(filas);
            }
        }

        jTable1.setModel(modComida);

        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBoxEntidades = new javax.swing.JComboBox<>();
        jComboBoxAtributos = new javax.swing.JComboBox<>();
        jRadioButtonActivo = new javax.swing.JRadioButton();
        jRadioButtonInactivo = new javax.swing.JRadioButton();
        jRadioButtonAmbos = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBoxEntidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Comidas", "Consultas", "Dietas", "Pacientes" }));
        jComboBoxEntidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEntidadesItemStateChanged(evt);
            }
        });
        jComboBoxEntidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEntidadesActionPerformed(evt);
            }
        });

        jComboBoxAtributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAtributosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonActivo);
        jRadioButtonActivo.setText("Activo");

        buttonGroup1.add(jRadioButtonInactivo);
        jRadioButtonInactivo.setText("Inactivo");

        buttonGroup1.add(jRadioButtonAmbos);
        jRadioButtonAmbos.setText("Ambos");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonEditar.setText("Editar");

        jButtonEliminar.setText("Eliminar");

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        jLabel2.setText("Atributo:");

        jLabel3.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButtonActivo)
                                .addGap(57, 57, 57)
                                .addComponent(jRadioButtonInactivo))
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonAmbos)
                            .addComponent(jComboBoxAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonEditar)
                            .addGap(251, 251, 251)
                            .addComponent(jButtonEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSalir))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jRadioButtonActivo)
                    .addComponent(jRadioButtonInactivo)
                    .addComponent(jRadioButtonAmbos))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonSalir))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEntidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEntidadesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.jComboBoxEntidades.getSelectedIndex() > 0) {
                this.jComboBoxAtributos.setModel(new DefaultComboBoxModel<>(atributos(this.jComboBoxEntidades.getSelectedItem().toString())));
                jLabel3.setText("");
            }
            if (this.jComboBoxEntidades.getSelectedIndex() == 0) {
                this.jComboBoxAtributos.setModel(new DefaultComboBoxModel<>(atributos("")));
            }
        }
    }//GEN-LAST:event_jComboBoxEntidadesItemStateChanged

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        entidad = jComboBoxEntidades.getSelectedItem().toString();
        atributo = jComboBoxAtributos.getSelectedItem().toString();
        atributoTF = jTextField1.getText();
        estado = (jRadioButtonActivo.isSelected()) ? 1 : (jRadioButtonInactivo.isSelected()) ? 0 : (jRadioButtonAmbos.isSelected()) ? 3 : -1;
        if ("".equals(entidad) && "".equals(atributo) && "".equals(atributoTF) && !entidad.isEmpty() && !atributo.isEmpty() && !atributoTF.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione datos validos");
        } else {
            if (entidad.equalsIgnoreCase("Comidas")) {
                switch (atributo) {
                    case "ID":
                        tf = Integer.parseInt(atributoTF);
                        comidaDAO=new ComidaDAO();
                        llenarTabla(comidaDAO.buscar(tf, estado));
                        break;
                    case "Nombre":
                        comidaDAO=new ComidaDAO();
                        llenarTabla(comidaDAO.buscarPorNombre(atributoTF, estado));
                        break;
                    case "Detalle":
                        break;
                    case "Cantidad de calorias":
                        break;
                    case "Estado":
                        break;
                }
            } else if (entidad.equalsIgnoreCase("Consultas")) {
                switch (atributo) {
                    case "ID":
                        break;
                    case "Paciente":
                        break;
                    case "Fecha":
                        break;
                    case "Peso actual":
                        break;
                }
            } else if (entidad.equalsIgnoreCase("Dietas")) {
                switch (atributo) {
                    case "ID":
                        break;
                    case "Nombre":
                        break;
                    case "Paciente":
                        break;
                    case "Fecha Inicial":
                        break;
                    case "Fecha Final":
                        break;
                    case "Estado":
                        break;
                }
            } else if (entidad.equalsIgnoreCase("Pacientes")) {
                switch (atributo) {
                    case "ID":
                        break;
                    case "Nombre Completo":
                        break;
                    case "Domicilio":
                        break;
                    case "DNI":
                        break;
                    case "Peso actual":
                        break;
                    case "Estado":
                        break;
                }
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxEntidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEntidadesActionPerformed
        if (jComboBoxEntidades.getSelectedIndex() > 0 && jComboBoxAtributos.getSelectedIndex() > 0) {
            jButtonBuscar.setEnabled(true);
            if (jTable1.getSelectedRow() != -1 && jTable1.getSelectedRow() < jTable1.getModel().getRowCount()) {
                jButtonEditar.setEnabled(true);
                jButtonEliminar.setEnabled(true);
            }
        } else {
            jButtonBuscar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxEntidadesActionPerformed

    private void jComboBoxAtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAtributosActionPerformed
        if (jComboBoxEntidades.getSelectedIndex() > 0 && jComboBoxAtributos.getSelectedIndex() > 0) {
            jButtonBuscar.setEnabled(true);
            if (jTable1.getSelectedRow() != -1 && jTable1.getSelectedRow() < jTable1.getModel().getRowCount()) {
                jButtonEditar.setEnabled(true);
                jButtonEliminar.setEnabled(true);
            }
        } else {
            jButtonBuscar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxAtributosActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        Dashboard db=new Dashboard();
        this.setVisible(false);
        db.setVisible(true);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    public String[] atributos(String entidad) {
        String at[] = null;
        if (entidad.equalsIgnoreCase("Comidas")) {
            String atributosComidas[] = {"", "ID", "Nombre", "Detalle", "Cantidad de calorias", "Estado"};
            at = atributosComidas;
        }
        if (entidad.equalsIgnoreCase("Dietas")) {
            String atributosDietas[] = {"", "ID", "Nombre", "Paciente", "Fecha Inicial", "Fecha Final", "Estado"};
            at = atributosDietas;
        }
        if (entidad.equalsIgnoreCase("Pacientes")) {
            String atributosPacientes[] = {"", "ID", "Nombre Completo", "Domicilio", "DNI", "Peso actual", "Estado"};
            at = atributosPacientes;
        }
        if (entidad.equalsIgnoreCase("Consultas")) {
            String atributosConsultas[] = {"", "ID", "Paciente", "Fecha", "Peso actual"};
            at = atributosConsultas;
        }
        if (entidad.equalsIgnoreCase("")) {
            String atributos[] = {""};
            at = atributos;
        }
        return at;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxAtributos;
    private javax.swing.JComboBox<String> jComboBoxEntidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonActivo;
    private javax.swing.JRadioButton jRadioButtonAmbos;
    private javax.swing.JRadioButton jRadioButtonInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
