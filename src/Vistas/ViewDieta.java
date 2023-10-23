/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.DietaDAO;
import Conexion.PacienteDAO;
import Entidades.Dieta;
import Entidades.Paciente;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.zoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author javie
 */
public class ViewDieta extends javax.swing.JPanel {
    
  DocumentFilter filtroLetras;
 DocumentFilter filtroNumeros;
 
 
    public ViewDieta() {
        initComponents();
        llenarComboBox();
        filtroNumeros = new FiltraEntrada(FiltraEntrada.SOLO_NUMEROS);
        filtroLetras = new FiltraEntrada(FiltraEntrada.SOLO_LETRAS);
        
        ((AbstractDocument) jTid.getDocument()).setDocumentFilter(filtroNumeros);
        ((AbstractDocument) jtnombre.getDocument()).setDocumentFilter(filtroLetras);

        
        ((AbstractDocument) jtpesofinal.getDocument()).setDocumentFilter(filtroNumeros);
    }

      private void llenarComboBox() {
       PacienteDAO pacient =new  PacienteDAO ();
        ArrayList<Paciente> pacientes = pacient.listarPaciente(1);//obtiene la una lista de materias activas de la base de datos
//        jComboPaciente.removeAllItems();
        jComboPaciente.addItem(null);
//agrega un espacio vacio en el primer elemento del combobox
        for (Paciente aux : pacientes) {//itera a traves de la lista y agrega cada materia al combobox
            jComboPaciente.addItem(aux);
            
            
        }
      } 
  public void habilitarBoton() {
     if (!jTid.getText().isEmpty() && !jtnombre.getText().isEmpty()) {// verifica que jTapellido y jTnombre no esten vacios
            jBlimpiar.setEnabled(true);//si ambos campos tienen contenido habilita el boton Nuevo
        } else {
            jBlimpiar.setEnabled(false);// si alguno de los campos esta vacio deshabilita el boton Nuevo
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlId = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlPaciente = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jlDieta = new javax.swing.JLabel();
        jDChoFeInicial = new com.toedter.calendar.JDateChooser();
        jdatechoFechaFinal = new com.toedter.calendar.JDateChooser();
        jlFeinicial = new javax.swing.JLabel();
        jlFefinal = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jtnombre = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jBlimpiar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlPesofinal = new javax.swing.JLabel();
        jtpesofinal = new javax.swing.JTextField();
        jCboxEstado = new javax.swing.JCheckBox();
        jComboPaciente = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(755, 692));

        jlId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlId.setText("ID");

        jlNombre.setBackground(new java.awt.Color(51, 51, 51));
        jlNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlNombre.setText("Nombre");

        jlPaciente.setBackground(new java.awt.Color(51, 51, 51));
        jlPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlPaciente.setText("Paciente");

        jlEstado.setBackground(new java.awt.Color(51, 51, 51));
        jlEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlEstado.setText("Estado");

        jlDieta.setBackground(new java.awt.Color(51, 51, 51));
        jlDieta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlDieta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDieta.setText("  DIETA");

        jlFeinicial.setBackground(new java.awt.Color(51, 51, 51));
        jlFeinicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlFeinicial.setText("Fecha Inicial");

        jlFefinal.setBackground(new java.awt.Color(51, 51, 51));
        jlFefinal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlFefinal.setText("Fecha Final");

        jTid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTidKeyReleased(evt);
            }
        });

        jtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtnombreKeyReleased(evt);
            }
        });

        jbBuscar.setBackground(new java.awt.Color(0, 255, 255));
        jbBuscar.setForeground(new java.awt.Color(0, 0, 51));
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jBlimpiar.setBackground(new java.awt.Color(0, 255, 255));
        jBlimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBlimpiar.setForeground(new java.awt.Color(0, 0, 51));
        jBlimpiar.setText("Limpiar");
        jBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimpiarActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(0, 255, 255));
        jbGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 0, 51));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(0, 255, 255));
        jbEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(0, 0, 51));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(0, 255, 255));
        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(0, 0, 51));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlPesofinal.setBackground(new java.awt.Color(51, 51, 51));
        jlPesofinal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlPesofinal.setText("Peso Final");

        jtpesofinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtpesofinalKeyReleased(evt);
            }
        });

        jComboPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPacienteActionPerformed(evt);
            }
        });
        jComboPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboPacienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jlDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBlimpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNombre)
                            .addComponent(jlPaciente)
                            .addComponent(jlId))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtnombre)
                            .addComponent(jTid)
                            .addComponent(jComboPaciente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDChoFeInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jbEliminar)
                                .addGap(61, 61, 61)
                                .addComponent(jbSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jbBuscar)))
                        .addGap(230, 230, 230))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlFefinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlFeinicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPesofinal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jbGuardar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboxEstado)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtpesofinal)
                                        .addComponent(jdatechoFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))))
                        .addContainerGap(423, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jlDieta)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlId)
                    .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPaciente)
                    .addComponent(jComboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlFeinicial)
                    .addComponent(jDChoFeInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdatechoFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFefinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPesofinal)
                    .addComponent(jtpesofinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCboxEstado)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBlimpiar)
                            .addComponent(jbGuardar)
                            .addComponent(jbEliminar)
                            .addComponent(jbSalir)))
                    .addComponent(jlEstado))
                .addGap(102, 102, 102))
        );

        jComboPaciente.getAccessibleContext().setAccessibleParent(jComboPaciente);
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
   
//        try{
//   
//       int id =Integer.parseInt(jTid.getText());
//      DietaDAO diet= new DietaDAO ();
//     Dieta die= new Dieta();
//     
//     die = diet.buscarPorId(id, 2);
//    
//       jtnombre.setText(die.getNombre());
//     Paciente pac = new Paciente ();
//    jComboPaciente.addItem(pac);
//   jDChoFeInicial.setDate(null);
//    jdatechoFechaFinal.setDate(null);
//    double pesofi = Double.parseDouble(jtpesofinal.getText()  );
//    jCboxEstado.setSelected(pac.isEstado());
//      
//     
//  } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Ingresa un dato valido");
//            jTid.setText("");
      
    
    }//GEN-LAST:event_jbBuscarActionPerformed
    
    private void jComboPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPacienteActionPerformed
        // TODO add your handling code here:
        llenarComboBox();
    }//GEN-LAST:event_jComboPacienteActionPerformed

    private void jBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarActionPerformed
       
        ((AbstractDocument) jTid.getDocument()).setDocumentFilter(null);
        jTid.setText("");
        
        jtnombre.setText("");
        jComboPaciente.setSelectedIndex(0);
        jCboxEstado.setSelected(false);
        jDChoFeInicial.setDate(null);
        jdatechoFechaFinal.setDate(null);
        jtpesofinal.setText("");
        
    }//GEN-LAST:event_jBlimpiarActionPerformed

    private void jtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtnombreKeyReleased
        // TODO add your handling code here:
        habilitarBoton(); 
    }//GEN-LAST:event_jtnombreKeyReleased

    private void jTidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTidKeyReleased
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jTidKeyReleased

    private void jComboPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboPacienteKeyReleased
        // TODO add your handling code here:
        habilitarBoton(); 
    }//GEN-LAST:event_jComboPacienteKeyReleased

    private void jtpesofinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpesofinalKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jtpesofinalKeyReleased

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
   
           // TODO add your handling code here:
       try {//recopila los datos de los textfield, radio button y jdatechosser y los guarda en diferentes variables
            if (jTid.getText().isEmpty()
                  || jtnombre.getText().isEmpty()
                  || jComboPaciente.getSelectedItem()== null
                  || !jCboxEstado.isSelected()
                  || jDChoFeInicial.getDate() == null 
                  || jdatechoFechaFinal.getDate() == null
                  || jtpesofinal.getText().isEmpty() )  {
         JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        
        } else {
            
                Paciente pac;
                String nombre = jtnombre.getText();
                boolean estado = jCboxEstado.isSelected(); 
                
                Paciente pacient= (Paciente) jComboPaciente.getSelectedItem();
                
               LocalDate fechaInicio=jDChoFeInicial.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
               LocalDate  fechaFinal = jdatechoFechaFinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                double pesoFi=Double.parseDouble(jtpesofinal.getText()) ;
               
             
             
              
             DietaDAO dietad= new DietaDAO ();
            Dieta die= new Dieta(nombre,pacient,fechaInicio, fechaFinal,pesoFi,estado);
            
            dietad.insertar(die);
              
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, "Complete la informacion con datos validos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
                                
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
//       DietaDAO diet= new DietaDAO ();
//       Dieta dieta = new Dieta();
//      int id = Integer.parseInt(jTid.getText());
//       
//        
//        if (dieta != null) {// Si encontro un alumno usa el metodo eliminar de aluData para eliminarlo de la base de datos
//
//            diet.eliminarDieta(dieta.getIdDieta());
//            // Limpia los campos de texto y demas componentes
////            ((AbstractDocument) jTid.getDocument()).setDocumentFilter(null);
//            jTid.setText("");
            

try {
        // 1. Crear una instancia de la clase DietaDAO (o la clase correspondiente).
        DietaDAO dietaDAO = new DietaDAO();

        // 2. Obtener el valor del campo ID.
        int id = Integer.parseInt(jTid.getText());
      String tf  = jTid.getText() ;
        
        if ( tf == null && tf.isEmpty()  ) {
            JOptionPane.showMessageDialog(this, "El campo ID está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
      

        // 3. Utilizar el método para buscar la dieta por ID.
        Dieta dieta = dietaDAO.buscarPorId(id, 1);

        // 4. Si se encontró la dieta, eliminarla.
        if (dieta != null) {
            dietaDAO.eliminarDieta(dieta.getIdDieta());
            JOptionPane.showMessageDialog(this, "La dieta se eliminó con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "La dieta no se encontró en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // 5. Limpiar los campos y realizar otras acciones necesarias.
        jTid.setText("");
        jtnombre.setText("");
        jComboPaciente.setSelectedIndex(0); // Puedes establecer el índice que corresponde a la opción predeterminada
        jDChoFeInicial.setDate(null);
        jdatechoFechaFinal.setDate(null);
        jCboxEstado.setSelected(false);
        jtpesofinal.setText("");
        // ... otros campos
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El campo ID debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar la dieta.", "Error", JOptionPane.ERROR_MESSAGE);
    }

//            jtnombre.setText("");
//            jComboPaciente.setSelectedItem(null);
//            jCboxEstado.setSelected(false);
//            jDChoFeInicial.setDate(null);
//            jdatechoFechaFinal.setDate(null);
//            jtpesofinal.setText("");
//        
        
                                    
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed
      


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBlimpiar;
    private javax.swing.JCheckBox jCboxEstado;
    private javax.swing.JComboBox<Paciente> jComboPaciente;
    private com.toedter.calendar.JDateChooser jDChoFeInicial;
    private javax.swing.JTextField jTid;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdatechoFechaFinal;
    private javax.swing.JLabel jlDieta;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlFefinal;
    private javax.swing.JLabel jlFeinicial;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPaciente;
    private javax.swing.JLabel jlPesofinal;
    private javax.swing.JTextField jtnombre;
    private javax.swing.JTextField jtpesofinal;
    // End of variables declaration//GEN-END:variables

  
  

    
    
    
    
    class FiltraEntrada extends DocumentFilter {

        public static final char SOLO_NUMEROS = 'N';
        public static final char SOLO_LETRAS = 'L';
        public static final char NUM_LETRAS = 'M';
        public static final char DEFAULT = '*';

        private char tipoEntrada;
        private int longitudCadena = 0;
        private int longitudActual = 0;

        public FiltraEntrada() {
            tipoEntrada = DEFAULT;
        }

        public FiltraEntrada(char tipoEntrada) {
            this.tipoEntrada = tipoEntrada;
        }

        public FiltraEntrada(char tipoEntrada, int longitudCadena) {
            this.tipoEntrada = tipoEntrada;
            this.longitudCadena = longitudCadena;
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, javax.swing.text.AttributeSet as) throws BadLocationException {
            if (string != null && !string.isEmpty()) { // verifica que el texto no sea nulo ni este vacio
                Document dc = fb.getDocument();
                longitudActual = dc.getLength();
                if (longitudCadena == 0 || longitudActual < longitudCadena) {
                    fb.insertString(i, string, as); // Inserta el texto si no se supera la longitud máxima
                }
            }
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        /*
        En este método:
        /// @Override: Indica que estás anulando el método remove de la superclase DocumentFilter.

        /// public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException:
        Esto es la declaración del método, que acepta tres parámetros: fb (un objeto FilterBypass que permite realizar la eliminación),
        offset (la posición desde la cual se eliminará el texto) y length (la cantidad de caracteres a eliminar).  
        
        ///super.remove(fb, offset, length);: Este es el llamado al método remove de la superclase DocumentFilter, 
        que se encarga de realizar la eliminación del texto en el documento. 
        No se requiere ninguna lógica adicional en este método, ya que simplemente delega la operación de eliminación a la implementación predeterminada de la superclase.
         */
        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, javax.swing.text.AttributeSet as) throws BadLocationException {
            Document dc = fb.getDocument();
            if (string == null) {
                fb.replace(0, i1, "", as);
                return;
            }
            if (string.isEmpty()) {
                fb.replace(0, i1, "", as);
                return;
            }
            longitudActual = dc.getLength();
            if (esValido(string)) {
                if (this.longitudCadena == 0 || longitudActual < longitudCadena) {
                    fb.replace(i, i1, string, as);
                }
            }
        }

        private boolean esValido(String valor) {
            char[] letras = valor.toCharArray();
            boolean valido = false;
            for (int i = 0; i < letras.length; i++) {

                switch (tipoEntrada) {
                    case SOLO_NUMEROS:
                        return valor.matches("[0-9]+");// verifica si solo contiene numeros
                    case SOLO_LETRAS:
                        return valor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");// verifica si solo contiene letras y espacios
                    case NUM_LETRAS:
                        return valor.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");// verifica si contiene números, letras y espacios
                    default:
                        valido = true;
                        return valido;
                }
            }
            return valido;
        }
    }
}

class NumericRangeFilter4 extends DocumentFilter {

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());//obtiene el texto actual del jtf

        String nextText = currentText.substring(0, i) + string + currentText.substring(i + i1);//concatena el texto a insertar con el texto acutal

        try {
            int num = Integer.parseInt(nextText);//intenta convertir el texto en numero

            if (num >= 1 && num <= 6) {//verifica si el numero esta en el rango de 1 a 6
                super.replace(fb, i, i1, string, as);
            } else {
                //fuera de rango
                Toolkit.getDefaultToolkit().beep();//sonido de error
            }
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep(); //El texto no es un número válido...Emite un sonido de error.
        }
    }
}

    
    



