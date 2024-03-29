package ui;

import java.awt.Font;
import java.awt.Image;
import java.util.List;
import models.UsuarioTipo;
import services.UsuarioTipoService;
import javax.swing.*;
import models.Usuario;
import services.UsuarioService;
/**
 *
 * @author Facundo
 */
public class Register extends javax.swing.JFrame {
    private UsuarioTipoService usuarioTipoService;
    private UsuarioService usuarioService;
    private Font fontLabel = new Font("Tahoma", Font.BOLD, 18);
    private Font fontTextField = new Font("Tahoma", Font.PLAIN, 12);

    public Register() {
        initComponents();
        loadImage();
        this.usuarioTipoService = new UsuarioTipoService();
        this.usuarioService = new UsuarioService();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        loadUserTypes();
        setVisible(true);
    }
    
    private void loadUserTypes() {
       List<UsuarioTipo> usuarioTipos = this.usuarioTipoService.mostrarTodos();
       for(UsuarioTipo usuario : usuarioTipos) {
           inputUserTypes.addItem(usuario.getTipo());
       }
    }
    
    private void loadImage() {
        ImageIcon appIcon = new ImageIcon("src/resources/image_app.png");
        Image appImage = appIcon.getImage();
        setIconImage(appImage);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerContainer = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        titleName = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        titlePassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        titlePasswordConfirm = new javax.swing.JLabel();
        inputPasswordConfirm = new javax.swing.JPasswordField();
        titleTypes = new javax.swing.JLabel();
        inputUserTypes = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(420, 500));
        setMinimumSize(new java.awt.Dimension(420, 500));
        setPreferredSize(new java.awt.Dimension(420, 500));
        setResizable(false);

        registerContainer.setMaximumSize(new java.awt.Dimension(408, 432));
        registerContainer.setMinimumSize(new java.awt.Dimension(408, 432));
        registerContainer.setPreferredSize(new java.awt.Dimension(408, 432));
        registerContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Title.setText("Registro");
        registerContainer.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 0, -1, -1));

        titleName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleName.setText("USUARIO");
        registerContainer.add(titleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        inputName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputName.setBorder(null);
        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });
        registerContainer.add(inputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 111, 298, 22));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        registerContainer.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 133, 298, -1));

        titlePassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titlePassword.setText("CONTRASEÑA");
        registerContainer.add(titlePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 151, -1, -1));

        inputPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputPassword.setBorder(null);
        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });
        registerContainer.add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 179, 298, 22));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        registerContainer.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 201, 298, -1));

        titlePasswordConfirm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titlePasswordConfirm.setText("REPETIR CONTRASEÑA");
        registerContainer.add(titlePasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 210, -1, -1));

        inputPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputPasswordConfirm.setBorder(null);
        inputPasswordConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordConfirmActionPerformed(evt);
            }
        });
        registerContainer.add(inputPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 240, 298, 22));

        titleTypes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleTypes.setText("TIPO USUARIO");
        registerContainer.add(titleTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));
        titleTypes.getAccessibleContext().setAccessibleName("TIPO");

        inputUserTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUserTypesActionPerformed(evt);
            }
        });
        registerContainer.add(inputUserTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 130, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        registerContainer.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 262, 298, -1));

        btnRegister.setText("Crear cuenta");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        registerContainer.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(registerContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void inputPasswordConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPasswordConfirmActionPerformed

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPasswordActionPerformed

    private void inputUserTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUserTypesActionPerformed
        // TODO add your handling code here:
        //System.out.println(inputUserTypes.getSelectedItem());
    }//GEN-LAST:event_inputUserTypesActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String nombreUsuario = inputName.getText();
        String contrasenia = inputPassword.getText();
        String confirmacionContrasenia = inputPasswordConfirm.getText();
        String tipoUsuarioSeleccionado = (String) inputUserTypes.getSelectedItem();
        UsuarioTipo usuarioTipo = this.usuarioTipoService.mostrarPorTipo(tipoUsuarioSeleccionado);
        if (contrasenia.equals(confirmacionContrasenia)) {
                if (contrasenia.length() >= 4 && contrasenia.length() <= 10) {
                    if (this.usuarioService.mostrarPorID(nombreUsuario) == null) {
                        dispose();
                        Usuario usuario = new Usuario(nombreUsuario, contrasenia, usuarioTipo);
                        this.usuarioService.crearUsuario(usuario);
                        JOptionPane.showMessageDialog(this, "Usuario creado con éxito", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "El nombre del usuario no está disponible", "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas deben tener entre 4 a 10 caracteres", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnRegister;
    private javax.swing.JTextField inputName;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JPasswordField inputPasswordConfirm;
    private javax.swing.JComboBox<String> inputUserTypes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel registerContainer;
    private javax.swing.JLabel titleName;
    private javax.swing.JLabel titlePassword;
    private javax.swing.JLabel titlePasswordConfirm;
    private javax.swing.JLabel titleTypes;
    // End of variables declaration//GEN-END:variables
}
