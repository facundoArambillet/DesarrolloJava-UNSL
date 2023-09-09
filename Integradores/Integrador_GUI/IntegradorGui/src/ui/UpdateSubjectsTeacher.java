package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import models.Materia;
import models.Profesor;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import services.MateriaService;
import services.ProfesorService;
import services.UsuarioService;

public class UpdateSubjectsTeacher extends javax.swing.JFrame {
    
    private ProfesorService teacherService;
    private MateriaService subjectService;
    private UsuarioService userService;
    private Profesor teacher;
    private int idTeacher;
    private List<Materia> subjects;
    
    private Font fontTitle = new Font("Tahoma", Font.BOLD, 24);
    private Font fontLabel = new Font("Tahoma", Font.BOLD, 18);
    private Font fontTextField = new Font("Tahoma", Font.PLAIN, 12);

    public UpdateSubjectsTeacher() {
        initComponents();
        loadImage();
        this.teacherService = new ProfesorService();
        this.subjectService = new MateriaService();
        this.userService = new UsuarioService();
        this.teacher = new Profesor();
        this.subjects = new ArrayList<>();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public void loadTeacher(int idTeacher,Profesor teacher) {
        this.teacher = teacher;
        this.idTeacher = idTeacher;
        createFormSubjects();
    }
    
    private void loadImage() {
        ImageIcon appIcon = new ImageIcon("src/resources/image_app.png");
        Image appImage = appIcon.getImage();
        setIconImage(appImage);
    }
    
    public void createFormSubjects() {
        formData.setLayout(new AbsoluteLayout());
        
        final int ITEM_POSITION_VALUE_X = 220;
        final int ITEM_WIDTH_VALUE = 120;
        final int ITEM_HEIGHT_VALUE = 20;
        
        JLabel title = new JLabel("Actualizar Materias");
        title.setFont(fontTitle);
        
        JLabel subjectsLabel = new JLabel("MATERIAS");
        subjectsLabel.setFont(fontLabel);
        JComboBox subjectsBox = new JComboBox();
        
        JButton btnSelect = new JButton("Seleccionar");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");
        JLabel subjectsSelected = new JLabel("Materias seleccionadas");
        subjectsSelected.setFont(fontTitle);
        
        subjects = this.subjectService.mostrarTodos();
        for(Materia subject : subjects) {
            subjectsBox.addItem(subject.getNombre());
        }
        
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();

        model.addColumn("Materias");
        model.addColumn("Cursos");
        
        List<Materia> subjectsSelectedBase = this.subjectService.mostrarPorProfesor(this.idTeacher);
        for(Materia subject: subjectsSelectedBase) {
            model.addRow(new Object[]{subject.getNombre(),subject.getCurso().getNombre()});
        }

        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        
        formData.add(title,new AbsoluteConstraints(80 ,10, 300, 35));
        formData.add(subjectsLabel,new AbsoluteConstraints(40 ,80, 200, 30));
        formData.add(subjectsBox,new AbsoluteConstraints(ITEM_POSITION_VALUE_X ,80, ITEM_WIDTH_VALUE, ITEM_HEIGHT_VALUE));
        formData.add(btnSelect,new AbsoluteConstraints(ITEM_POSITION_VALUE_X ,120, ITEM_WIDTH_VALUE, ITEM_HEIGHT_VALUE));
        formData.add(subjectsSelected,new AbsoluteConstraints(50 ,200, 300, 35));
        formData.add(scrollPane,new AbsoluteConstraints(40 ,250, 300, 100));
        formData.add(btnUpdate,new AbsoluteConstraints(ITEM_POSITION_VALUE_X ,360, ITEM_WIDTH_VALUE, ITEM_HEIGHT_VALUE));
        formData.add(btnDelete,new AbsoluteConstraints(ITEM_POSITION_VALUE_X -150,360, ITEM_WIDTH_VALUE, ITEM_HEIGHT_VALUE));
        
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subjectSelected = (String) subjectsBox.getSelectedItem();
                Materia subjectBase = subjectService.mostrarPorNombre(subjectSelected);
                String courseName = subjectBase.getCurso().getNombre();
                
                boolean alreadyExists = false;

                for (int row = 0; row < model.getRowCount(); row++) {
                    String existingSubject = (String) model.getValueAt(row, 0);
                    if (subjectSelected.equals(existingSubject)) {
                        alreadyExists = true;
                        JOptionPane.showMessageDialog(formData, "La materia ya esta seleccionada", "Alerta", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }

                if (!alreadyExists) {
                    model.addRow(new Object[]{subjectSelected, courseName});
                }
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if(model.getRowCount() == 1) {
                    JOptionPane.showMessageDialog(formData, "No puedes eliminar todas las materias", "Alerta", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (selectedRow != -1) {
                        model.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(formData, "Selecciona una fila para eliminar", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });
        
        List<Materia> subjectsSelectedTeacher = new ArrayList<>();
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                for(int row = 0; row < model.getRowCount(); row++) {
                    String existingSubject = (String) model.getValueAt(row, 0);
                    Materia subjectBase = subjectService.mostrarPorNombre(existingSubject);
                    subjectsSelectedTeacher.add(subjectBase);
                }
                teacherService.actualizarProfesor(idTeacher, teacher, subjectsSelectedTeacher);
                JOptionPane.showMessageDialog(formData, "Datos actualizados con éxito", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        formData = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(408, 520));

        javax.swing.GroupLayout formDataLayout = new javax.swing.GroupLayout(formData);
        formData.setLayout(formDataLayout);
        formDataLayout.setHorizontalGroup(
            formDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        formDataLayout.setVerticalGroup(
            formDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(UpdateSubjectsTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectsTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectsTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSubjectsTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSubjectsTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel formData;
    // End of variables declaration                   
}
