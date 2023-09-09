package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Curso;
import models.Profesor;
import models.ProfesorTipo;
import models.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import services.CursoService;
import services.MateriaService;
import services.ProfesorService;
import services.ProfesorTipoService;


/**
 *
 * @author Facundo
 */
public class LoadDataUser extends javax.swing.JFrame {
    private ProfesorTipoService profesorTipoService;
    private ProfesorService profesorService;
    private MateriaService materiaService;
    private CursoService cursoService;
    
    private Usuario usuario;
    //Tengo que declarar la variable como atributo ya que las variables que quieran usarse en una clase interna de java
    //Como es dentro del ActionListener unicamente pueden ser final(por lo que no puedo modificarla)
    private byte[] fotoEstudiante;
    private Font fontTitle = new Font("Tahoma", Font.BOLD, 24);
    private Font fontLabel = new Font("Tahoma", Font.BOLD, 18);
    private Font fontTextField = new Font("Tahoma", Font.PLAIN, 12);

    public LoadDataUser() {
        initComponents();
        loadImage();
        this.profesorTipoService = new ProfesorTipoService();
        this.profesorService = new ProfesorService();
        this.materiaService = new MateriaService();
        this.cursoService = new CursoService();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void loadImage() {
        ImageIcon appIcon = new ImageIcon("src/resources/image_app.png");
        Image appImage = appIcon.getImage();
        setIconImage(appImage);
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        createForm();
    }
     
    public void createForm() {
        formData.setLayout(new AbsoluteLayout());
        
        final int VALOR_POSICION_X = 40;
        final int VALOR_POSICION_X_ITEM = VALOR_POSICION_X + 168;
        final int VALOR_ANCHO_FIELD = 295;
        final int VALOR_ALTURA_FIELD = 22;
        final int VALOR_ANCHO_ITEM = 130;
        final int VALOR_ALTURA_ITEM = 20;
        final int ESPACIADO = 10;
        final int ESPACIADO_ITEM = 20;
        final int ESPACIADO_SEPARADOR = ESPACIADO - 2;
        int posicionY = 80;
        
        if("estudiante".equals(this.usuario.getTipoUsuario().getTipo())) {
            
            JLabel titulo = new JLabel("Carga Datos Estudiante");
            titulo.setFont(fontTitle);
            
            JLabel nombreLabel = new JLabel("NOMBRE");
            JTextField nombreField = new JTextField();
            JSeparator nombreSeparator = new JSeparator();
            nombreSeparator.setForeground(Color.BLACK);
            nombreLabel.setFont(fontLabel);
            nombreField.setFont(fontTextField);
            nombreField.setBorder(null);
            
            JLabel apellidoLabel = new JLabel("APELLIDO");
            JTextField apellidoField = new JTextField();
            JSeparator apellidoSeparator = new JSeparator();
            apellidoSeparator.setForeground(Color.BLACK);
            apellidoLabel.setFont(fontLabel);
            apellidoField.setFont(fontTextField);
            apellidoField.setBorder(null);
            
            JLabel dniLabel = new JLabel("DNI");
            JTextField dniField = new JTextField();
            JSeparator dniSeparator = new JSeparator();
            dniSeparator.setForeground(Color.BLACK);
            dniLabel.setFont(fontLabel);
            dniField.setFont(fontTextField);
            dniField.setBorder(null);
            
            JLabel telefonoLabel = new JLabel("TELEFONO");
            JTextField telefonoField = new JTextField();
            JSeparator telefonoSeparator = new JSeparator();
            telefonoSeparator.setForeground(Color.BLACK);
            telefonoLabel.setFont(fontLabel);
            telefonoField.setFont(fontTextField);
            telefonoField.setBorder(null);
            
            JLabel emailLabel = new JLabel("EMAIL");
            JTextField emailField = new JTextField();
            JSeparator emailSeparator = new JSeparator();
            emailSeparator.setForeground(Color.BLACK);
            emailLabel.setFont(fontLabel);
            emailField.setFont(fontTextField);
            emailField.setBorder(null);
            
            JLabel fotoLabel = new JLabel("FOTO");
            JButton btnFoto = new JButton("Cargar Foto");
            btnFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            fotoLabel.setFont(fontLabel);
            
            btnFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser eleccionArchivo = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif");
                eleccionArchivo.setFileFilter(filtro);
                
                int resultado = eleccionArchivo.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = eleccionArchivo.getSelectedFile();
                    try {
                        BufferedImage imagenOriginal = ImageIO.read(archivoSeleccionado);

                        BufferedImage imagenRedimensionada = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                        Graphics2D grafico = imagenRedimensionada.createGraphics();
                        grafico.drawImage(imagenOriginal, 0, 0, 100, 100, null);
                        grafico.dispose();

                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        ImageIO.write(imagenRedimensionada, "jpg", bos);

                        byte[] imagenRedimensionadaBytes = bos.toByteArray();

                        fotoEstudiante = imagenRedimensionadaBytes;
                        if (fotoEstudiante != null) {
                            btnFoto.setText(archivoSeleccionado.getName());
                        }

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                
            }
        });
            
            JLabel cursoLabel = new JLabel("CURSOS");
            cursoLabel.setFont(fontLabel);
            List<Curso> cursos = this.cursoService.mostrarTodos();
            JComboBox cursoBox = new JComboBox();
            for(Curso curso : cursos) {
                cursoBox.addItem(curso.getNombre());
            }

            JButton btnCargar = new JButton("Cargar");
            btnCargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            btnCargar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!nombreField.getText().isBlank()) {
                        String nombre = nombreField.getText();
                        if(!apellidoField.getText().isBlank()) {
                            String apellido = apellidoField.getText();
                            if(!dniField.getText().isBlank()) {
                              try {
                                long dniNumero = Long.parseLong(dniField.getText());
                                if(!telefonoField.getText().isBlank()) {
                                    try {
                                        long telefonoNumero = Long.parseLong(telefonoField.getText());
                                        if(!emailField.getText().isBlank()) {
                                            String email = emailField.getText();
                                            if(fotoEstudiante != null) {
                                                String cursosText = (String) cursoBox.getSelectedItem();
                                                Curso curso = cursoService.mostrarPorNombre(cursosText);

                                                List<Object> dataEstudiante = new ArrayList<>();
                                                dataEstudiante.add(nombre);
                                                dataEstudiante.add(apellido);
                                                dataEstudiante.add(dniNumero);
                                                dataEstudiante.add(telefonoNumero);
                                                dataEstudiante.add(email);
                                                dataEstudiante.add(fotoEstudiante);
                                                dataEstudiante.add(curso);
                                                dataEstudiante.add(usuario);
                                                dispose();
                                                LoadDataTutor loadDataTutor = new LoadDataTutor();
                                                loadDataTutor.loadData(dataEstudiante);
                                            } else {
                                                JOptionPane.showMessageDialog(container, "Debe cargar una imagen", "Alerta", JOptionPane.ERROR_MESSAGE);
  
                                            }
                                            
                                        } else {
                                            JOptionPane.showMessageDialog(container, "El email no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } catch(NumberFormatException ext) {
                                        JOptionPane.showMessageDialog(container, "El campo telefono debe ser numerico", "Alerta", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(container, "El telefono no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                                }
                              } catch(NumberFormatException ex) {
                                JOptionPane.showMessageDialog(container, "El cuil debe ser numerico sin guiones", "Alerta", JOptionPane.ERROR_MESSAGE);
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
            
            formData.add(titulo,new AbsoluteConstraints(60 ,10, 300, 35));
            
            formData.add(nombreLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += nombreLabel.getPreferredSize().height + ESPACIADO;
            formData.add(nombreField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += nombreField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(nombreSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += nombreSeparator.getPreferredSize().height + ESPACIADO;

            formData.add(apellidoLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += apellidoLabel.getPreferredSize().height + ESPACIADO;
            formData.add(apellidoField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += apellidoField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(apellidoSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += apellidoSeparator.getPreferredSize().height + ESPACIADO;
            
            formData.add(dniLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += dniLabel.getPreferredSize().height + ESPACIADO;
            formData.add(dniField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += dniField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(dniSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += dniSeparator.getPreferredSize().height + ESPACIADO;
            
            formData.add(telefonoLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += telefonoLabel.getPreferredSize().height + ESPACIADO;
            formData.add(telefonoField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += telefonoField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(telefonoSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += telefonoSeparator.getPreferredSize().height + ESPACIADO;
            
            formData.add(emailLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += emailLabel.getPreferredSize().height + ESPACIADO;
            formData.add(emailField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += emailField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(emailSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            
            //BOTON FOTO
            posicionY += fotoLabel.getPreferredSize().height + ESPACIADO;
            formData.add(fotoLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            formData.add(btnFoto, new AbsoluteConstraints(VALOR_POSICION_X_ITEM, posicionY, 130, 20));

            //COMBO BOXS
            posicionY += emailSeparator.getPreferredSize().height + ESPACIADO_ITEM + 30;
            formData.add(cursoLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            formData.add(cursoBox, new AbsoluteConstraints(VALOR_POSICION_X_ITEM, posicionY, VALOR_ANCHO_ITEM, VALOR_ALTURA_ITEM));
            
            //BOTON CARGAR
            posicionY += emailSeparator.getPreferredSize().height + ESPACIADO_ITEM + 30;
            formData.add(btnCargar, new AbsoluteConstraints(VALOR_POSICION_X_ITEM + 30, posicionY, 100, 20));
            
        } else if("profesor".equals(this.usuario.getTipoUsuario().getTipo())){
            
            JLabel titulo = new JLabel("Carga Datos Profesor");
            titulo.setFont(fontTitle);
            
            JLabel nombreLabel = new JLabel("NOMBRE");
            JTextField nombreField = new JTextField();
            JSeparator nombreSeparator = new JSeparator();
            nombreSeparator.setForeground(Color.BLACK);
            nombreLabel.setFont(fontLabel);
            nombreField.setFont(fontTextField);
            nombreField.setBorder(null);
            
            JLabel apellidoLabel = new JLabel("APELLIDO");
            JTextField apellidoField = new JTextField();
            JSeparator apellidoSeparator = new JSeparator();
            apellidoSeparator.setForeground(Color.BLACK);
            apellidoLabel.setFont(fontLabel);
            apellidoField.setFont(fontTextField);
            apellidoField.setBorder(null);
            
            JLabel cuilLabel = new JLabel("CUIL");
            JTextField cuilField = new JTextField();
            JSeparator cuilSeparator = new JSeparator();
            cuilSeparator.setForeground(Color.BLACK);
            cuilLabel.setFont(fontLabel);
            cuilField.setFont(fontTextField);
            cuilField.setBorder(null);
            
            JLabel telefonoLabel = new JLabel("TELEFONO");
            JTextField telefonoField = new JTextField();
            JSeparator telefonoSeparator = new JSeparator();
            telefonoSeparator.setForeground(Color.BLACK);
            telefonoLabel.setFont(fontLabel);
            telefonoField.setFont(fontTextField);
            telefonoField.setBorder(null);
            
            JLabel emailLabel = new JLabel("EMAIL");
            JTextField emailField = new JTextField();
            JSeparator emailSeparator = new JSeparator();
            emailSeparator.setForeground(Color.BLACK);
            emailLabel.setFont(fontLabel);
            emailField.setFont(fontTextField);
            emailField.setBorder(null);
            
            
            JLabel tiposLabel = new JLabel("TIPOS");
            tiposLabel.setFont(fontLabel);
            List<ProfesorTipo> profesorTipos = this.profesorTipoService.mostrarTodos();
            JComboBox tipos = new JComboBox();
            for(ProfesorTipo profesorTipo : profesorTipos) {
                tipos.addItem(profesorTipo.getTipo());
            }
            
            
            JButton btnCargar = new JButton("Cargar");
            btnCargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            btnCargar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!nombreField.getText().isBlank()) {
                        String nombre = nombreField.getText();
                        if(!apellidoField.getText().isBlank()) {
                            String apellido = apellidoField.getText();
                            if(!cuilField.getText().isBlank()) {
                              try {
                                long cuilNumero = Long.parseLong(cuilField.getText());
                                if(!telefonoField.getText().isBlank()) {
                                    try {
                                        long telefonoNumero = Long.parseLong(telefonoField.getText());
                                        if(!emailField.getText().isBlank()) {
                                            
                                            String email = emailField.getText();
                                            String profesorTipoText = (String) tipos.getSelectedItem();
                                            ProfesorTipo profesorTipo = profesorTipoService.mostrarPorTipo(profesorTipoText);
                                            Profesor profesor = new Profesor(nombre,apellido,cuilNumero,telefonoNumero,
                                                    email,profesorTipo,usuario);
                                            dispose();
                                            LoadSubjectsTeacher loadSubjectsTeacher = new LoadSubjectsTeacher();
                                            loadSubjectsTeacher.loadTeacher(profesor);
                                            
                                        } else {
                                            JOptionPane.showMessageDialog(container, "El email no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } catch(NumberFormatException ext) {
                                        JOptionPane.showMessageDialog(container, "El campo telefono debe ser numerico", "Alerta", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(container, "El telefono no puede estar vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
                                }
                              } catch(NumberFormatException ex) {
                                JOptionPane.showMessageDialog(container, "El cuil debe ser numerico sin guiones", "Alerta", JOptionPane.ERROR_MESSAGE);
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
            
            formData.add(titulo,new AbsoluteConstraints(60 ,10, 300, 35));
            
            formData.add(nombreLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += nombreLabel.getPreferredSize().height + ESPACIADO;
            formData.add(nombreField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += nombreField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(nombreSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += nombreSeparator.getPreferredSize().height + ESPACIADO;

            formData.add(apellidoLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += apellidoLabel.getPreferredSize().height + ESPACIADO;
            formData.add(apellidoField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += apellidoField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(apellidoSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += apellidoSeparator.getPreferredSize().height + ESPACIADO;
            
            formData.add(cuilLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += cuilLabel.getPreferredSize().height + ESPACIADO;
            formData.add(cuilField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += cuilField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(cuilSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += cuilSeparator.getPreferredSize().height + ESPACIADO;
            
            formData.add(telefonoLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += telefonoLabel.getPreferredSize().height + ESPACIADO;
            formData.add(telefonoField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += telefonoField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(telefonoSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            posicionY += telefonoSeparator.getPreferredSize().height + ESPACIADO;
            
            formData.add(emailLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            posicionY += emailLabel.getPreferredSize().height + ESPACIADO;
            formData.add(emailField, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, VALOR_ALTURA_FIELD));
            posicionY += emailField.getPreferredSize().height + ESPACIADO_SEPARADOR;
            formData.add(emailSeparator, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, VALOR_ANCHO_FIELD, 1));
            
            //COMBOS BOXS
            posicionY += emailSeparator.getPreferredSize().height + ESPACIADO_ITEM;
            formData.add(tiposLabel, new AbsoluteConstraints(VALOR_POSICION_X, posicionY, 100, 20));
            formData.add(tipos, new AbsoluteConstraints(VALOR_POSICION_X_ITEM, posicionY, VALOR_ANCHO_ITEM, VALOR_ALTURA_ITEM));
           
            
            //BOTON CARGAR
            posicionY += emailSeparator.getPreferredSize().height + ESPACIADO_ITEM + 30;
            formData.add(btnCargar, new AbsoluteConstraints(VALOR_POSICION_X_ITEM + 30, posicionY, 100, 20));
            
            
            
        }
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
        formData = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1234, 4567));
        setMinimumSize(new java.awt.Dimension(200, 650));
        setPreferredSize(new java.awt.Dimension(408, 650));

        formData.setPreferredSize(new java.awt.Dimension(216, 367));

        javax.swing.GroupLayout formDataLayout = new javax.swing.GroupLayout(formData);
        formData.setLayout(formDataLayout);
        formDataLayout.setHorizontalGroup(
            formDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        formDataLayout.setVerticalGroup(
            formDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(formData, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(LoadDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadDataUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel formData;
    // End of variables declaration//GEN-END:variables
}
