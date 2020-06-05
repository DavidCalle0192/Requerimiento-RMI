/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteHabitacion.Vistas;

import clienteHabitacion.ClienteMedico;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.sop_rmi.GestionPacienteInt;

/**
 *
 * @author usuario
 */
public class MenuMedico extends javax.swing.JFrame {

    public static GestionPacienteInt objRemoto;
    public static ClienteMedico cm;
    public static int bandera = 0;
    public static String texto;
    public static int aux=0;//controla la existencia de pacientes registrados 
    /**
     * Creates new form MenuMedico
     */
    public MenuMedico(GestionPacienteInt objRemoto, ClienteMedico cm) {
        this.objRemoto = objRemoto;
        this.cm = cm;
        initComponents();
    }

    public MenuMedico() {
        initComponents();
    }

    public void hilo() {
        texto = "";
        bandera = 0;
        txtArea_seguimiento.setText("");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                if (bandera == 1) {
                    timer.cancel();
                } else {
                    try {
                        for (int i = 0; i < objRemoto.listarPacientes().size(); i++) {
                            int id = objRemoto.listarPacientes().get(i).getId();
                            String tipoId = objRemoto.listarPacientes().get(i).getTipo_id();
                            IndicadorDTO indicador = cm.iniciarSeguimiento(id);
                            texto = texto
                                    + "ID paciente: " + id
                                    + "\nFrecuencia cardiaca: " + indicador.getFrecuenciaCardiaca()
                                    + "\nFrecuencia respiratoria: " + indicador.getFrecuenciaRespiratoria()
                                    + "\nTemperatura: " + indicador.getTemperatura() + "\n\n";
                        }
                        txtArea_seguimiento.setText(texto);
                    } catch (RemoteException ex) {
                        Logger.getLogger(MenuMedico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        timer.schedule(task, 0, 8000);

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
        btn_registrarPaciente = new javax.swing.JButton();
        btn_iniciarSeguimiento = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        lb_menuMedico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_seguimiento = new javax.swing.JTextArea();
        btn_paraSeguimiento = new javax.swing.JButton();
        btn_listarPacientes = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_registrarPaciente.setText("Registrar paciente");
        btn_registrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarPacienteActionPerformed(evt);
            }
        });

        btn_iniciarSeguimiento.setText("Iniciar seguimiento");
        btn_iniciarSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarSeguimientoActionPerformed(evt);
            }
        });

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        lb_menuMedico.setText("Menú Médico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_menuMedico)
                    .addComponent(btn_registrarPaciente)
                    .addComponent(btn_iniciarSeguimiento)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_menuMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_registrarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_iniciarSeguimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salir)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        txtArea_seguimiento.setColumns(20);
        txtArea_seguimiento.setRows(5);
        jScrollPane1.setViewportView(txtArea_seguimiento);

        btn_paraSeguimiento.setText("Parar Seguimiento");
        btn_paraSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paraSeguimientoActionPerformed(evt);
            }
        });

        btn_listarPacientes.setText("Listar Pacientes");
        btn_listarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarPacientesActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_listarPacientes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_limpiar)
                                .addGap(46, 46, 46)
                                .addComponent(btn_paraSeguimiento)
                                .addGap(34, 34, 34))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_paraSeguimiento)
                    .addComponent(btn_listarPacientes)
                    .addComponent(btn_limpiar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_registrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarPacienteActionPerformed

        aux=1;
        try {
            if (objRemoto.listarPacientes().size() == objRemoto.obtenerMaxPacientes()) {
                JOptionPane.showMessageDialog(null, "Limite de registros alcanzados");
            } else {
                RegistarPaciente rp = new RegistarPaciente(objRemoto, cm);
                rp.setVisible(true);
                this.setVisible(false);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(MenuMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_registrarPacienteActionPerformed

    private void btn_paraSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paraSeguimientoActionPerformed
        // TODO add your handling code here:
        bandera = 1;
    }//GEN-LAST:event_btn_paraSeguimientoActionPerformed

    private void btn_iniciarSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarSeguimientoActionPerformed
        // TODO add your handling code here:
        if(aux == 0){
            JOptionPane.showMessageDialog(null, "No existen pacientes registrados.");
        }else{
            hilo();
        }
        
    }//GEN-LAST:event_btn_iniciarSeguimientoActionPerformed

    private void btn_listarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarPacientesActionPerformed
        try {
            // TODO add your handling code here:
            txtArea_seguimiento.setText("");
            String texto = "";
            bandera=1;
            for (int i = 0; i < objRemoto.listarPacientes().size(); i++) {
                int id = objRemoto.listarPacientes().get(i).getId();
                String tipoId = objRemoto.listarPacientes().get(i).getTipo_id();
                String nombres = objRemoto.listarPacientes().get(i).getNombres();
                String apellidos = objRemoto.listarPacientes().get(i).getApellidos();
                String direccion = objRemoto.listarPacientes().get(i).getDireccion();
                
                texto = texto +
                        "ID: " + id+
                        "\nNombres: "+ nombres+
                        "\nApellidos: " + apellidos+
                        "\ndireccion"+ direccion + "\n\n";
            }
            txtArea_seguimiento.setText(texto);
        } catch (RemoteException ex) {
            Logger.getLogger(MenuMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_listarPacientesActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        bandera=1;
        txtArea_seguimiento.setText("");
        
    }//GEN-LAST:event_btn_limpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciarSeguimiento;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_listarPacientes;
    private javax.swing.JButton btn_paraSeguimiento;
    private javax.swing.JButton btn_registrarPaciente;
    private javax.swing.JButton btn_salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_menuMedico;
    private javax.swing.JTextArea txtArea_seguimiento;
    // End of variables declaration//GEN-END:variables
}
