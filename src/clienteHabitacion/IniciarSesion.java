/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteHabitacion;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import servidorAlertas.sop_rmi.GestionPacienteInt;

/**
 *
 * @author usuario
 */
public class IniciarSesion extends javax.swing.JFrame {

    public static GestionPacienteInt objRemoto;

    /**
     * Creates new form IniciarSesion
     */
    //variables de conexión
    public IniciarSesion() {
        initComponents();
        setLocationRelativeTo(null);

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
        Label_direccion_ip = new javax.swing.JLabel();
        Label_puerto = new javax.swing.JLabel();
        TextField_direccion_ip = new javax.swing.JTextField();
        TextField_puerto = new javax.swing.JTextField();
        Button_establecer_conexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Label_direccion_ip.setText("Dirección IP");
        Label_direccion_ip.setToolTipText("Ingrese la dirección ip donde desea establecer la conexión");

        Label_puerto.setText("Puerto");
        Label_puerto.setToolTipText("Ingrese el puerto donde desea establecer la conexión");

        TextField_direccion_ip.setText("localhost");
        TextField_direccion_ip.setToolTipText("");
        TextField_direccion_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_direccion_ipActionPerformed(evt);
            }
        });

        TextField_puerto.setText("2020");

        Button_establecer_conexion.setText("Establecer conexión");
        Button_establecer_conexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_establecer_conexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Label_direccion_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Label_puerto)
                                .addGap(62, 62, 62)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextField_direccion_ip, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(TextField_puerto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(Button_establecer_conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_direccion_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_direccion_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_puerto)
                    .addComponent(TextField_puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Button_establecer_conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_establecer_conexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_establecer_conexionActionPerformed
        try {
            ClienteAdministrador ca = new ClienteAdministrador();
            ca.iniciarSesion(TextField_direccion_ip.getText(), Integer.parseInt(TextField_puerto.getText()));
            objRemoto = ca.obtenerObjRemoto();
            int tamArray = objRemoto.obtenerMaxPacientes();
            if(tamArray==-1){//si es -1 es admin
                vista1_administrador v1 = new vista1_administrador(objRemoto);
                v1.setVisible(true);
                this.setVisible(false);
            }else {
                ClienteMedico cm = new ClienteMedico();
                objRemoto = cm.obtenerObjRemoto();
                MenuMedico menu = new MenuMedico(objRemoto);
                menu.setVisible(true);
                this.setVisible(false);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Button_establecer_conexionActionPerformed

    private void TextField_direccion_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_direccion_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_direccion_ipActionPerformed

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
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {
             javax.swing.UIManager.setLookAndFeel(info.getClassName());
             break;
             }
             }*/
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_establecer_conexion;
    private javax.swing.JLabel Label_direccion_ip;
    private javax.swing.JLabel Label_puerto;
    private javax.swing.JTextField TextField_direccion_ip;
    private javax.swing.JTextField TextField_puerto;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
