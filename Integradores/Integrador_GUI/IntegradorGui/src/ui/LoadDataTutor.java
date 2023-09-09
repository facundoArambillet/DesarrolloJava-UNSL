package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import models.Curso;
import models.Estudiante;
import models.TutorEstudiante;
import models.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import services.EstudianteService;
import services.TutorEstudianteService;

/**
 *
 * @author Facundo
 */
public class LoadDataTutor extends javax.swing.JFrame {
    private TutorEstudianteService tutorEstudianteService;
    private EstudianteService estudianteService;
    
    private List<Object> dataEstudiante = new ArrayList<>();
    
    private Font fontTitle = new Font("Tahoma", Font.BOLD, 24);
    private Font fontLabel = new Font("Tahoma", Font.BOLD, 18);
    private Font fontTextField = new Font("Tahoma", Font.PLAIN, 12);
    
    
    public LoadDataTutor() {
        initComponents();
        loadImage();
        this.tutorEstudianteService = new TutorEstudianteService();
        this.estudianteService = new EstudianteService();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public void loadData(List<Object> data) {
        this.dataEstudiante = data;
        createFormTutor();
    }
    
    private void loadImage() {
        ImageIcon appIcon = new ImageIcon("src/resources/image_app.png");
        Image appImage = appIcon.getImage();
        setIconImage(appImage);
    }
    
    public void createFormTutor() {
        dataTutor.setLayout(new AbsoluteLayout());
        final int VALOR_POSICION_X = 40;
        final int VALOR_POSICION_X_ITEM = VALOR_POSICION_X + 168;
        final int VALOR_ANCHO_FIELD = 295;
        final int VALOR_ALTURA_FIELD = 22;
        final int ESPACIADO = 10;
        final int ESPACIADO_ITEM = 20;
        final int ESPACIADO_SEPARADOR = ESPACIADO - 2;
        int posicionY = 40;
        
        JLabel titulo = new JLabel("Carga Datos Tutor");
        titulo.setFont(fontTitle);
            
        JLabel nombreTutorLabel = new JLabel("NOMBRE");
        JTextField nombreTutorField = new JTextField();
        JSeparator nombreTutorSeparator = new JSeparator();
        nombreTutorSeparator.setForeground(Color.BLACK);
        nombreTutorLabel.setFont(fontLabel);
        nombreTutorField.setFont(fontTextField);
        nombreTutorField.setBorder(null);
            
        JLabel apellidoTutorLabel = new JLabel("APELLIDO");
        JTextField apellidoTutorField = new JTextField();
        JSeparator apellidoTutorSeparator = new JSeparator();
        apellidoTutorSeparator.setForeground(Color.BLACK);
        apellidoTutorLabel.setFont(fontLabel);
        apellidoTutorField.setFont(fontTextField);
        apellidoTutorField.setBorder(null);
            
        JLabel telefonoTutorLabel = new JLabel("TELEFONO TUTOR");
        JTextField telefonoTutorField = new JTextField();
        JSeparator telefonoTutorSeparator = new JSeparator();
        telefonoTutorSeparator.setForeground(Color.BLACK);
        telefonoTutorLabel.setFont(fontLabel);
        telefonoTutorField.setFont(fontTextField);
        telefonoTutorField.setBorder(null);
            
        JLabel direccionTutorLabel = new JLabel("DIRECCION");
        JTextField direccionTutorField = new JTextField();
        JSeparator direccionTutorSeparator = new JSeparator();
        direccionTutorSeparator.setForeground(Color.BLACK);
        direccionTutorLabel.setFont(fontLabel);
        direccionTutorField.setFont(fontTextField);
        direccionTutorField.setBorder(null);
        
        
        JButton btnCargarData = new JButton("Cargar Datos");
        btnCargarData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnCargarData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!nombreTutorField.getText().isBlank()) {
                    String nombreTutor = nombreTutorField.getText();
                    if(!apellidoTutorField.getText().isBlank()) {
                        String apellidoTutor = apellidoTutorField.getText();
                        if(!telefonoTutorField.getText().isBlank()) {
                            try {
                                long telefonoNumero = Long.parseLong(telefonoTutorField.getText());
                                if(!direccionTutorField.getText().isBlank()) {
                                    String direccionTutor = direccionTutorField.getText();
                                    
                                    TutorEstudiante tutor = new TutorEstudiante(nombreTutor,apellidoTutor,telefonoNumero,direccionTutor);
                                    tutorEstudianteService.crearTutorEstudiante(tutor);
                                    TutorEstudiante tutorBase = tutorEstudianteService.mostrarPorNombre(nombreTutor);
                                    
                                    String nombre = (String) dataEstudiante.get(0);
                                    String apellido = (String) dataEstudiante.get(1);
                                    long dni = (Long) dataEstudiante.get(2);
                                    long telefono = (Long) dataEstudiante.get(3);
                                    String email = (String) dataEstudiante.get(4);
                                    byte[] foto = (byte[]) dataEstudiante.get(5);
                                    Curso curso = (Curso) dataEstudiante.get(6);
                                    Usuario usuario = (Usuario) dataEstudiante.get(7);
                                    
                                    Estudiante estudiante = new Estudiante(nombre,apellido,dni,telefono,email,foto,usuario,tutorBase,curso);
                                    estudianteService.crearEstudiante(estudiante);
                                    JOptionPane.showMessageDialog(container, "Datos cargados con exito", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                                    
                                    dispose();
                                    Menu menu = new Menu();
                                    menu.setUsuarioLogueado(usuario);

                                }
                                else {
                                    JOptionPane.showMessageDialog(container, "La direccion no puede estar vacia", "Alerta", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch(NumberFormatException ex) {
                                JOptionPane.showMessageDialog(container, "El telefono debe ser numerico sin espacios", "Alerta", JOptionPane.ERROR_MESSAGE);
                            }
                              
                            } else {
                                JOptionPane.showMessageDialog(container, "El cuil no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(container, "El apellido no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                    JOptionPane.showMessageDialog(container, "El nombre no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        dataTutor.add(titulo,new AbsoluteConstraints(60 ,10, 300, 35));

        posicionY += nombreTutorLabel.getPreferredSize().height + ESPACIADO;
        dataTutor.add(nombreTutorLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 200, 20));
        posicionY += nombreTutorLabel.getPreferredSize().height + ESPACIADO;
        dataTutor.add(nombreTutorField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
        posicionY += nombreTutorField.getPreferredSize().height + ESPACIADO_SEPARADOR;
        dataTutor.add(nombreTutorSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
        posicionY += nombreTutorSeparator.getPreferredSize().height + ESPACIADO;
            
        dataTutor.add(apellidoTutorLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 200, 20));
        posicionY += apellidoTutorLabel.getPreferredSize().height + ESPACIADO;
        dataTutor.add(apellidoTutorField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
        posicionY += apellidoTutorField.getPreferredSize().height + ESPACIADO_SEPARADOR;
        dataTutor.add(apellidoTutorSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
        posicionY += apellidoTutorSeparator.getPreferredSize().height + ESPACIADO;

        dataTutor.add(telefonoTutorLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 200, 20));
        posicionY += telefonoTutorLabel.getPreferredSize().height + ESPACIADO;
        dataTutor.add(telefonoTutorField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
        posicionY += telefonoTutorField.getPreferredSize().height + ESPACIADO_SEPARADOR;
        dataTutor.add(telefonoTutorSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
        posicionY += telefonoTutorSeparator.getPreferredSize().height + ESPACIADO;
            
        dataTutor.add(direccionTutorLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 200, 20));
        posicionY += direccionTutorLabel.getPreferredSize().height + ESPACIADO;
        dataTutor.add(direccionTutorField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
        posicionY += direccionTutorField.getPreferredSize().height + ESPACIADO_SEPARADOR;
        dataTutor.add(direccionTutorSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
        
        posicionY += direccionTutorSeparator.getPreferredSize().height + ESPACIADO_ITEM + 30;
        dataTutor.add(btnCargarData, new AbsoluteConstraints(VALOR_POSICION_X_ITEM + 30, posicionY, 125, 20));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        dataTutor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(408, 550));
        setMinimumSize(new java.awt.Dimension(408, 550));
        setPreferredSize(new java.awt.Dimension(408, 550));

        container.setPreferredSize(new java.awt.Dimension(431, 408));

        javax.swing.GroupLayout dataTutorLayout = new javax.swing.GroupLayout(dataTutor);
        dataTutor.setLayout(dataTutorLayout);
        dataTutorLayout.setHorizontalGroup(
            dataTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dataTutorLayout.setVerticalGroup(
            dataTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataTutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataTutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoadDataTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadDataTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadDataTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadDataTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadDataTutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel dataTutor;
    // End of variables declaration//GEN-END:variables
}
