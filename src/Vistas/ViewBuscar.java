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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
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
    ArrayList<Consulta> consultas;
    ArrayList<Comida> comidas;
    ArrayList<Object> lista;
    ArrayList<Dieta> dietas;
    ArrayList<Paciente> pacientes;

    public ViewBuscar() {
        initComponents();
        jComboBoxPacientes.setEnabled(false);
        jDateChooser1.setEnabled(false);
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
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void limpiarTabla() {
        DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
        mod.setRowCount(0);
    }

    private void llenarTabla(ArrayList<Object> list, String tipo) {
        switch (tipo) {
            case "Consulta":
                modConsulta = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                };
                modConsulta.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre Paciente", "Peso actual"});

                if (list != null && !list.isEmpty()) {
                    for (Object oaux : list) {
                        if (oaux instanceof Consulta) {
                            Consulta aux = (Consulta) oaux;
                            Object[] filas = new Object[4];
                            filas[0] = aux;
                            filas[1] = aux.getIdConsulta();
                            filas[2] = aux.getPaciente().getNombre();
                            filas[3] = aux.getPesoActual();
                            modConsulta.addRow(filas);
                        }
                    }
                }
                jTable1.setModel(modConsulta);
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    jTable1.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
                }
                jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(0).setWidth(0);
                jTable1.getColumnModel().getColumn(1).setMinWidth(30);
                jTable1.getColumnModel().getColumn(1).setMaxWidth(30);
                jTable1.getColumnModel().getColumn(1).setWidth(30);
                break;

            case "Dieta":
                modDieta = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                };
                modDieta.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre", "Paciente", "Fecha de inicio", "Fecha de Fin", "Peso final", "Estado"});

                if (list != null && !list.isEmpty()) {
                    for (Object oaux : list) {
                        if (oaux instanceof Dieta) {
                            Dieta aux = (Dieta) oaux;
                            Object[] filas = new Object[8];
                            filas[0] = aux;
                            filas[1] = aux.getIdDieta();
                            filas[2] = aux.getNombre();
                            filas[3] = aux.getPaciente();
                            filas[4] = aux.getFechaInicial();
                            filas[5] = aux.getFechaFinal();
                            filas[6] = aux.getPesoFinal();
                            if (aux.isEstado()) {
                                filas[7] = "Activo";
                            } else {
                                filas[7] = "Inactivo";
                            }
                            modDieta.addRow(filas);
                        }
                    }
                }
                jTable1.setModel(modDieta);
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    jTable1.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
                }
                jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(0).setWidth(0);
                jTable1.getColumnModel().getColumn(1).setMinWidth(30);
                jTable1.getColumnModel().getColumn(1).setMaxWidth(30);
                jTable1.getColumnModel().getColumn(1).setWidth(30);
                jTable1.getColumnModel().getColumn(7).setMinWidth(50);
                jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
                jTable1.getColumnModel().getColumn(7).setWidth(50);
                break;

            case "Paciente":
                modPaciente = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                };
                modPaciente.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre", "DNI", "Telefono", "Domicilio", "Peso Actual", "Estado"});

                if (list != null && !list.isEmpty()) {
                    for (Object oaux : list) {
                        if (oaux instanceof Paciente) {
                            Paciente aux = (Paciente) oaux;
                            Object[] filas = new Object[8];
                            filas[0] = aux;
                            filas[1] = aux.getIdPaciente();
                            filas[2] = aux.getNombre();
                            filas[3] = aux.getDomicilio();
                            filas[4] = aux.getDni();
                            filas[5] = aux.getTelefono();
                            filas[6] = aux.getPesoActual();
                            if (aux.isEstado()) {
                                filas[7] = "Activo";
                            } else {
                                filas[7] = "Inactivo";
                            }
                            modPaciente.addRow(filas);
                        }
                    }
                }
                jTable1.setModel(modPaciente);
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
                break;
            case "Comida":
                limpiarTabla();
                modComida = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                };
                modComida.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre", "Detalle", "Cantidad de calorias", "Estado"});
                if (list != null && !list.isEmpty()) {
                    for (Object oaux : list) {
                        if (oaux instanceof Comida) {
                            Comida aux = (Comida) oaux;
                            Object[] filas = new Object[6];
                            filas[0] = aux;
                            filas[1] = aux.getIdComida();
                            filas[2] = aux.getNombre();
                            filas[3] = aux.getDetalle();
                            filas[4] = aux.getCantCalorias();
                            if (aux.isEstado()) {
                                filas[5] = "Activo";
                            } else {
                                filas[5] = "Inactivo";
                            }
                            modComida.addRow(filas);
                        }
                    }
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
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private void llenarTabla(Comida comida) {
        limpiarTabla();
        modComida = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modComida.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre", "Detalle", "Cantidad de calorias", "Estado"});

        if (comida != null) {
            Object[] filas = new Object[6];
            filas[0] = comida;
            filas[1] = comida.getIdComida();
            filas[2] = comida.getNombre();
            filas[3] = comida.getDetalle();
            filas[4] = comida.getCantCalorias();
            if (comida.isEstado()) {
                filas[5] = "Activo";
            } else {
                filas[5] = "Inactivo";
            }
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

    private void llenarTabla(Consulta consulta) {
        limpiarTabla();
        modConsulta = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modConsulta.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre Paciente", "Peso actual"});

        if (consulta != null) {
            Object[] filas = new Object[4];
            filas[0] = consulta;
            filas[1] = consulta.getIdConsulta();
            filas[2] = consulta.getPaciente().getNombre();
            filas[3] = consulta.getPesoActual();
            modConsulta.addRow(filas);
        }

        jTable1.setModel(modConsulta);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(30);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(30);
        jTable1.getColumnModel().getColumn(1).setWidth(30);
    }

    private void llenarTabla(Dieta dieta) {
        limpiarTabla();
        modDieta = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modDieta.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre", "Paciente", "Fecha de inicio", "Fecha de Fin", "Peso final", "Estado"});

        if (dieta != null) {
            Object[] filas = new Object[8];
            filas[0] = dieta;
            filas[1] = dieta.getIdDieta();
            filas[2] = dieta.getNombre();
            filas[3] = dieta.getPaciente();
            filas[4] = dieta.getFechaInicial();
            filas[5] = dieta.getFechaFinal();
            filas[6] = dieta.getPesoFinal();
            if (dieta.isEstado()) {
                filas[7] = "Activo";
            } else {
                filas[7] = "Inactivo";
            }
            modDieta.addRow(filas);
        }

        jTable1.setModel(modDieta);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(30);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(30);
        jTable1.getColumnModel().getColumn(1).setWidth(30);
        jTable1.getColumnModel().getColumn(7).setMinWidth(50);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(7).setWidth(50);
    }

    private void llenarTabla(Paciente paciente) {
        limpiarTabla();
        modPaciente = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modPaciente.setColumnIdentifiers(new String[]{"Objeto", "ID", "Nombre", "DNI", "Telefono", "Domicilio", "Peso Actual", "Estado"});

        if (paciente != null) {
            Object[] filas = new Object[8];
            filas[0] = paciente;
            filas[1] = paciente.getIdPaciente();
            filas[2] = paciente.getNombre();
            filas[5] = paciente.getDomicilio();
            filas[3] = paciente.getDni();
            filas[4] = paciente.getTelefono();
            filas[6] = paciente.getPesoActual();
            if (paciente.isEstado()) {
                filas[7] = "Activo";
            } else {
                filas[7] = "Inactivo";
            }
            modPaciente.addRow(filas);
        }

        jTable1.setModel(modPaciente);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getTableHeader().getColumnModel().getColumn(i).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(30);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(30);
        jTable1.getColumnModel().getColumn(1).setWidth(30);
        jTable1.getColumnModel().getColumn(7).setMinWidth(50);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(7).setWidth(50);

    }

    private void llenarComboBox() {
        pacienteDAO = new PacienteDAO();
        pacientes = pacienteDAO.listarPaciente(1);

        jComboBoxPacientes.addItem(null);

        for (Paciente aux : pacientes) {
            jComboBoxPacientes.addItem(aux);
        }
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
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPacientes = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

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

        jComboBoxAtributos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAtributosItemStateChanged(evt);
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

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
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

        jComboBoxPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPacientesActionPerformed(evt);
            }
        });

        jDateChooser1.setDoubleBuffered(false);
        jDateChooser1.setMaxSelectableDate(new java.util.Date(1735704071000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(1577851271000L));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEditar)
                                .addGap(251, 251, 251)
                                .addComponent(jButtonEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSalir)))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonActivo)
                                .addGap(57, 57, 57)
                                .addComponent(jRadioButtonInactivo)
                                .addGap(46, 46, 46)
                                .addComponent(jRadioButtonAmbos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jRadioButtonActivo)
                    .addComponent(jRadioButtonInactivo)
                    .addComponent(jRadioButtonAmbos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonSalir))
                .addContainerGap())
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
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            tf = Integer.parseInt(atributoTF);
                            comidaDAO = new ComidaDAO();
                            llenarTabla(comidaDAO.buscar(tf, estado));
                        } else {
                            comidaDAO = new ComidaDAO();
                            comidas = comidaDAO.listarComidas(estado);
                            lista = new ArrayList<>(comidas);
                            llenarTabla(lista, "Comida");
                        }
                        break;
                    case "Nombre":
                        comidaDAO = new ComidaDAO();
                        llenarTabla(comidaDAO.buscarPorNombre(atributoTF, estado));
                        break;
                    case "Detalle":
                        comidaDAO = new ComidaDAO();
                        comidas = comidaDAO.buscarPorDetalle(atributoTF, estado);
                        lista = new ArrayList<>(comidas);
                        llenarTabla(lista, "Comida");
                        break;
                    case "Cantidad de calorias":
                        comidaDAO = new ComidaDAO();
                        estado = (jRadioButtonActivo.isSelected()) ? 1 : (jRadioButtonInactivo.isSelected()) ? 0 : (jRadioButtonAmbos.isSelected()) ? -1 : -3;
                        comidas = comidaDAO.buscarXCantCalorias(Integer.parseInt(atributoTF), estado);
                        lista = new ArrayList<>(comidas);
                        llenarTabla(lista, "Comida");
                        break;
                    case "Estado":
                        comidaDAO = new ComidaDAO();
                        comidas = comidaDAO.listarComidas(estado);
                        lista = new ArrayList<>(comidas);
                        llenarTabla(lista, "Comida");
                        break;
                }
            } else if (entidad.equalsIgnoreCase("Consultas")) {
                switch (atributo) {
                    case "ID"://id consulta
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            tf = Integer.parseInt(atributoTF);
                            consultaDAO = new ConsultaDAO();
                            llenarTabla(consultaDAO.buscar(tf));
                        } else {
                            consultaDAO = new ConsultaDAO();
                            consultas = consultaDAO.buscar();
                            lista = new ArrayList<>(consultas);
                            llenarTabla(lista, "Consulta");
                        }
                        break;
                    case "Paciente":
                        consultaDAO = new ConsultaDAO();
                        consultas = consultaDAO.buscar((Paciente) jComboBoxPacientes.getSelectedItem());
                        lista = new ArrayList<>(consultas);
                        llenarTabla(lista, "Consulta");
                        break;
                    case "Fecha":
                        break;
                    case "Peso actual":
                        break;
                }
            } else if (entidad.equalsIgnoreCase("Dietas")) {
                switch (atributo) {
                    case "ID":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            tf = Integer.parseInt(atributoTF);
                            dietaDAO = new DietaDAO();
                            llenarTabla(dietaDAO.buscarPorId(tf, estado));
                        } else {
                            dietaDAO = new DietaDAO();
                            dietas = dietaDAO.buscar(estado);
                            lista = new ArrayList<>(dietas);
                            llenarTabla(lista, "Dieta");
                        }
                        break;
                    case "Nombre":
                        dietaDAO = new DietaDAO();
                        dietas = dietaDAO.buscarDietasPorNombre(atributoTF, estado);
                        lista = new ArrayList<>(dietas);
                        llenarTabla(lista, "Dieta");
                        break;
                    case "Paciente":
                        Paciente p = (Paciente) jComboBoxPacientes.getSelectedItem();
                        dietaDAO = new DietaDAO();
                        llenarTabla(dietaDAO.buscarPorId(p.getIdPaciente(), estado));
                        break;
                    case "Fecha Inicial"://falta x modif vista
                        dietaDAO = new DietaDAO();
                        if (jDateChooser1.getDate() != null) {
                            LocalDate fechaInicial = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            dietas = dietaDAO.buscarDietasPorFecha(fechaInicial, estado, true);
                            lista = new ArrayList<>(dietas);
                            llenarTabla(lista, "Dieta");
                        } else {
                            JOptionPane.showMessageDialog(this, "Ingrese una fecha valida");
                        }
                        break;
                    case "Fecha Final"://falta x modif vista
                        dietaDAO = new DietaDAO();
                        if (jDateChooser1.getDate() != null) {
                            LocalDate fechaFinal = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            dietas = dietaDAO.buscarDietasPorFecha(fechaFinal, estado, false);
                            lista = new ArrayList<>(dietas);
                            llenarTabla(lista, "Dieta");
                        } else {
                            JOptionPane.showMessageDialog(this, "Ingrese una fecha valida");
                        }
                        break;
                    case "Peso Final":
                        dietaDAO = new DietaDAO();
                        double tfp = Double.parseDouble(atributoTF);
                        dietas = dietaDAO.buscarDietasPorPesoFinal(tfp, estado);
                        lista = new ArrayList<>(dietas);
                        llenarTabla(lista, "Dieta");
                        break;
                    case "Estado":
                        dietaDAO = new DietaDAO();
                        dietas = dietaDAO.buscar(estado);
                        lista = new ArrayList<>(dietas);
                        llenarTabla(lista, "Dieta");
                        break;
                }
            } else if (entidad.equalsIgnoreCase("Pacientes")) {
                switch (atributo) {
                    case "ID":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            tf = Integer.parseInt(atributoTF);
                            pacienteDAO = new PacienteDAO();
                            llenarTabla(pacienteDAO.buscarPaciente(tf, estado));
                        } else {
                            pacienteDAO = new PacienteDAO();
                            pacientes = pacienteDAO.listarPaciente(estado);
                            lista = new ArrayList<>(pacientes);
                            llenarTabla(lista, "Paciente");
                        }
                        break;
                    case "Nombre Completo":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            pacienteDAO = new PacienteDAO();
                            pacientes = pacienteDAO.buscarPacientesPorNombre(atributoTF, estado);
                            lista = new ArrayList<>(pacientes);
                            llenarTabla(lista, "Paciente");
                        }
                        break;
                    case "Domicilio":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            pacienteDAO = new PacienteDAO();
                            pacientes = pacienteDAO.buscarPacientesPorDomicilio(atributoTF, estado);
                            lista = new ArrayList<>(pacientes);
                            llenarTabla(lista, "Paciente");
                        }
                        break;
                    case "DNI":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            tf = Integer.parseInt(atributoTF);
                            pacienteDAO = new PacienteDAO();
                            llenarTabla(pacienteDAO.buscarPacientePorDni(tf, estado));
                        }
                        break;
                    case "Peso actual":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            double tfp = Double.parseDouble(atributoTF);
                            pacienteDAO = new PacienteDAO();
                            estado = (jRadioButtonActivo.isSelected()) ? 1 : (jRadioButtonInactivo.isSelected()) ? 0 : (jRadioButtonAmbos.isSelected()) ? -1 : 0;
                            pacientes = pacienteDAO.buscarPacientesPorPesoActual(tfp, estado);
                            lista = new ArrayList<>(pacientes);
                            llenarTabla(lista, "Paciente");
                        }
                        break;
                    case "Estado":
                        pacienteDAO = new PacienteDAO();
                        pacientes = pacienteDAO.listarPaciente(estado);
                        lista = new ArrayList<>(pacientes);
                        llenarTabla(lista, "Paciente");
                        break;
                    case "Celular":
                        if (atributoTF != null && !atributoTF.isEmpty() && !atributoTF.equalsIgnoreCase("")) {
                            tf = Integer.parseInt(atributoTF);
                            pacienteDAO = new PacienteDAO();
                            pacientes = pacienteDAO.buscarPacientesPorCelular(tf, estado);
                            lista = new ArrayList<>(pacientes);
                            llenarTabla(lista, "Paciente");
                        } else {
                            pacienteDAO = new PacienteDAO();
                            pacientes = pacienteDAO.listarPaciente(estado);
                            lista = new ArrayList<>(pacientes);
                            llenarTabla(lista, "Paciente");
                        }
                        break;
                }
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxEntidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEntidadesActionPerformed
        if (jComboBoxEntidades.getSelectedIndex() > 0
                && jComboBoxAtributos.getSelectedIndex() > 0
                && (jComboBoxAtributos.getSelectedItem() == null || !jComboBoxAtributos.getSelectedItem().toString().equals("Paciente")
                || (jComboBoxPacientes.getSelectedItem() != null))) {
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
        if (jComboBoxEntidades.getSelectedIndex() > 0
                && jComboBoxAtributos.getSelectedIndex() > 0
                && (jComboBoxAtributos.getSelectedItem() == null || !jComboBoxAtributos.getSelectedItem().toString().equals("Paciente")
                || (jComboBoxPacientes.getSelectedItem() != null))) {
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
        Dashboard db = new Dashboard();
        this.setVisible(false);
        db.setVisible(true);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jComboBoxAtributosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAtributosItemStateChanged
        String entidadSelect = (String) jComboBoxEntidades.getSelectedItem();
        String atributoSelect = (String) jComboBoxAtributos.getSelectedItem();

        if (atributoSelect.equals("Estado") || atributoSelect.equals("Paciente")) {
            jTextField1.setEnabled(false);
        } else {
            jTextField1.setEnabled(true);
        }
        if (atributoSelect.equals("Cantidad de calorias") || atributoSelect.equals("Peso Final")) {
            jRadioButtonActivo.setText("Mayor a");
            jRadioButtonAmbos.setText("Menor a");
            jRadioButtonInactivo.setText("Igual a");
        } else {
            jRadioButtonActivo.setText("Activo");
            jRadioButtonAmbos.setText("Ambos");
            jRadioButtonInactivo.setText("Inactivo");
        }

        if (atributoSelect.equals("Fecha Inicial") || atributoSelect.equals("Fecha Final")) {
            jTextField1.setEnabled(false);
            jDateChooser1.setEnabled(true);
        } else {
            jTextField1.setEnabled(true);
            jDateChooser1.setEnabled(false);
        }
        if (atributoSelect.equals("Paciente") || atributoSelect.equals("Paciente")) {
            jTextField1.setEditable(false);
            jComboBoxPacientes.setEnabled(true);
            jComboBoxPacientes.removeAllItems();
            llenarComboBox();
        } else {
            jTextField1.setEditable(true);
            jComboBoxPacientes.setEnabled(false);
            jComboBoxPacientes.removeAllItems();
        }
    }//GEN-LAST:event_jComboBoxAtributosItemStateChanged

    private void jComboBoxPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPacientesActionPerformed
        if (jComboBoxEntidades.getSelectedIndex() > 0
                && jComboBoxAtributos.getSelectedIndex() > 0
                && (jComboBoxAtributos.getSelectedItem() == null || !jComboBoxAtributos.getSelectedItem().toString().equals("Paciente")
                || (jComboBoxPacientes.getSelectedItem() != null))) {
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
    }//GEN-LAST:event_jComboBoxPacientesActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        int sRow = jTable1.getSelectedRow();//obtiene el índice de la fila seleccionada y lo guarda en nRow
        DefaultTableModel mod12 = (DefaultTableModel) jTable1.getModel();
        if (sRow != -1 && sRow < mod12.getRowCount()) {//getRowCount=devuelve el número total de filas en el modelo de la tabla
            jButtonEditar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_jScrollPane1MouseReleased

    public String[] atributos(String entidad) {
        String at[] = null;
        if (entidad.equalsIgnoreCase("Comidas")) {
            String atributosComidas[] = {"", "ID", "Nombre", "Detalle", "Cantidad de calorias", "Estado"};
            at = atributosComidas;
        }
        if (entidad.equalsIgnoreCase("Dietas")) {
            String atributosDietas[] = {"", "ID", "Nombre", "Paciente", "Fecha Inicial", "Fecha Final", "Peso Final", "Estado"};
            at = atributosDietas;
        }
        if (entidad.equalsIgnoreCase("Pacientes")) {
            String atributosPacientes[] = {"", "ID", "Nombre Completo", "Domicilio", "DNI", "Peso actual", "Celular", "Estado"};
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
    private javax.swing.JComboBox<Paciente> jComboBoxPacientes;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
