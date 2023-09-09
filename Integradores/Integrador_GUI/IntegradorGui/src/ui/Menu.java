package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import models.Curso;
import models.Estudiante;
import models.Materia;
import models.Profesor;
import models.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import services.CursoService;
import services.EstudianteService;
import services.MateriaService;
import services.ProfesorMateriaService;
import services.ProfesorService;

/**
 *
 * @author Facundo
 */
public class Menu extends javax.swing.JFrame {
    private ProfesorService teacherService;
    private ProfesorMateriaService teacherSubjectService;
    private CursoService courseService;
    private EstudianteService studentService;
    private MateriaService subjectService;
    
    private Usuario user;
    
    private Font fontTitle = new Font("Tahoma", Font.BOLD, 24);
    private Font fontLabelKey = new Font("Tahoma", Font.BOLD, 18);
    private Font fontLabelValue = new Font("Tahoma", Font.BOLD, 14);
    private Font fontBody = new Font ("Sylfaen",Font.PLAIN,14);
    
    public Menu() {
        initComponents();
        this.teacherService = new ProfesorService();
        this.teacherSubjectService = new ProfesorMateriaService();
        this.courseService = new CursoService();
        this.studentService = new EstudianteService();
        this.subjectService = new MateriaService();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
    
    public void setUsuarioLogueado(Usuario usuario) {
        this.user = usuario;
        loadNavbar();
    }
    
    public void loadNavbar() {
        String usuario = this.user.getIdUsuario();
        String capitalizedUsername = usuario.substring(0, 1).toUpperCase() + usuario.substring(1);

        JMenu userMenu = new JMenu(capitalizedUsername);
        JMenuItem userProfile = new JMenuItem("Mi perfil");
        JMenuItem userMaterials = new JMenuItem("Mis materias");
        userMenu.add(userProfile);
        userMenu.add(userMaterials);
        navbar.add(userMenu);

        userMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
        JMenu menuAboutUs = new JMenu("Acerca de nosotros");
        JMenu menuServices = new JMenu("Servicios y recursos");
        menuAboutUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuServices.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
        JMenuItem history = new JMenuItem("Historia");
        JMenuItem diningRoom = new JMenuItem("Comedor");
        JMenuItem library = new JMenuItem("Biblioteca");
        JMenuItem culturalCenter = new JMenuItem("Centro Cultural");
        JMenuItem residences = new JMenuItem("Residencias");
            
        menuAboutUs.add(history);
        menuServices.add(diningRoom);
        menuServices.add(library);
        menuServices.add(culturalCenter);
        menuServices.add(residences);
            
        userProfile.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
            createContentProfile();
            }
        });
            
        userMaterials.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createContentMaterials();
            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createContentHistory();
            }
        });
            
        diningRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem itemSelected = (JMenuItem) e.getSource();
                createContentServices(itemSelected);
            }
        });
        
        culturalCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem itemSelected = (JMenuItem) e.getSource();
                createContentServices(itemSelected);
            }
        });
            
        residences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem itemSelected = (JMenuItem) e.getSource();
                createContentServices(itemSelected);
            }
        });
              
        library.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem itemSelected = (JMenuItem) e.getSource();
                createContentServices(itemSelected);
            }
        });
            
        navbar.add(menuAboutUs);
        navbar.add(menuServices);
    }
    
    private Image createCircularImage(Image image , int width, int heigth) {
        
        BufferedImage circularImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = circularImage.createGraphics();
        Ellipse2D.Double clip = new Ellipse2D.Double(0, 0, width, heigth);

        g2.setClip(clip);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

        return circularImage;
    }

    
    private void createContentProfile() { 
        container.removeAll();
        container.setLayout(new AbsoluteLayout());

        if("estudiante".equals( this.user.getTipoUsuario().getTipo())) {
            Estudiante studentLogged = this.studentService.mostrarPorIDUsuario(this.user.getIdUsuario());
            
            final int STUDENT_POSITION_VALUE_X = 100;
            final int TUTOR_POSITION_VALUE_X = 600;
            final int IMAGE_POSITION_VALUE_X = 350;
            final int LABEL_VALUE_POSITION_VALUE_X = 200;
            final int LABEL_TUTOR_VALUE_POSITION_VALUE_X = 700;
            final int FIELD_TUTOR_VALUE_WIDTH = 200;
            final int SPACING = 40;
            int positionValueY = 140;
            
            JLabel studentTitle = new JLabel("Estudiante");
            JLabel tutorTitle = new JLabel("Tutor");
            JLabel studentNameKey = new JLabel("Nombre:");
            JLabel studentLastNameKey = new JLabel("Apellido:");
            JLabel studentDniKey = new JLabel("Dni:");
            JLabel studentPhoneNumberKey = new JLabel("Telefono:");
            JLabel studentEmailKey = new JLabel("Email:");
            JLabel studentCourseKey = new JLabel("Curso:");
            JLabel tutorNameKey = new JLabel("Nombre:");
            JLabel tutorLastNameKey = new JLabel("Apellido:");
            JLabel tutorPhoneNumberKey = new JLabel("Telefono:");
            JLabel tutorAddressKey = new JLabel("Direccion:");
            
            ImageIcon updateIcon = new ImageIcon("src/resources/icon_edit.png");
            JLabel updateLabelStudent = new JLabel();
            JLabel updateLabelTutor = new JLabel();
            updateLabelTutor.setIcon(updateIcon);
            updateLabelStudent.setIcon(updateIcon);
            updateLabelTutor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            updateLabelStudent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            studentTitle.setFont(fontTitle);
            studentTitle.setForeground(Color.WHITE);
            tutorTitle.setFont(fontTitle);
            tutorTitle.setForeground(Color.WHITE);
            studentNameKey.setFont(fontLabelKey);
            studentNameKey.setForeground(Color.WHITE);
            studentLastNameKey.setFont(fontLabelKey);
            studentLastNameKey.setForeground(Color.WHITE);
            studentDniKey.setFont(fontLabelKey);
            studentDniKey.setForeground(Color.WHITE);
            studentPhoneNumberKey.setFont(fontLabelKey);
            studentPhoneNumberKey.setForeground(Color.WHITE);
            studentEmailKey.setFont(fontLabelKey);
            studentEmailKey.setForeground(Color.WHITE);
            studentCourseKey.setFont(fontLabelKey);
            studentCourseKey.setForeground(Color.WHITE);
            tutorNameKey.setFont(fontLabelKey);
            tutorNameKey.setForeground(Color.WHITE);
            tutorLastNameKey.setFont(fontLabelKey);
            tutorLastNameKey.setForeground(Color.WHITE);
            tutorPhoneNumberKey.setFont(fontLabelKey);
            tutorPhoneNumberKey.setForeground(Color.WHITE);
            tutorAddressKey.setFont(fontLabelKey);
            tutorAddressKey.setForeground(Color.WHITE);
            
            JLabel studentNameValue = new JLabel(studentLogged.getNombre());
            JLabel studentLastNameValue = new JLabel(studentLogged.getApellido());
            JLabel studentDniValue = new JLabel(String.valueOf(studentLogged.getDni()));
            JLabel studentPhoneNumberValue = new JLabel(String.valueOf(studentLogged.getTelefono()));
            JLabel studentEmailValue = new JLabel(studentLogged.getEmail());
            JLabel studentCourseValue = new JLabel(studentLogged.getCurso().getNombre());
            
            JLabel tutorNameValue = new JLabel(studentLogged.getTutor().getNombre());
            JLabel tutorLastNameValue = new JLabel(studentLogged.getTutor().getApellido());
            JLabel tutorPhoneNumberValue = new JLabel(String.valueOf(studentLogged.getTutor().getTelefono()));
            JLabel tutorAddressValue = new JLabel(studentLogged.getTutor().getDireccion());
            
            studentNameValue.setFont(fontLabelValue);
            studentNameValue.setForeground(Color.WHITE);
            studentLastNameValue.setFont(fontLabelValue);
            studentLastNameValue.setForeground(Color.WHITE);
            studentDniValue.setFont(fontLabelValue);
            studentDniValue.setForeground(Color.WHITE);
            studentPhoneNumberValue.setFont(fontLabelValue);
            studentPhoneNumberValue.setForeground(Color.WHITE);
            studentEmailValue.setFont(fontLabelValue);
            studentEmailValue.setForeground(Color.WHITE);
            studentCourseValue.setFont(fontLabelValue);
            studentCourseValue.setForeground(Color.WHITE);
            tutorNameValue.setFont(fontLabelValue);
            tutorNameValue.setForeground(Color.WHITE);
            tutorLastNameValue.setFont(fontLabelValue);
            tutorLastNameValue.setForeground(Color.WHITE);
            tutorPhoneNumberValue.setFont(fontLabelValue);
            tutorPhoneNumberValue.setForeground(Color.WHITE);
            tutorAddressValue.setFont(fontLabelValue);
            tutorAddressValue.setForeground(Color.WHITE);
            
            JLabel imageLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(studentLogged.getFoto());
            Image image = imageIcon.getImage();
            Image circularImage = createCircularImage(image,100,100);
            ImageIcon circularImageIcon = new ImageIcon(circularImage); 
            imageLabel.setIcon(circularImageIcon);
                     
            container.add(studentTitle,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,60, 300, 35));  
            container.add(updateLabelStudent,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X + 140,70, 20, 20));
            container.add(updateLabelTutor,new AbsoluteConstraints(TUTOR_POSITION_VALUE_X + 80 ,70, 20, 20));  
            container.add(tutorTitle,new AbsoluteConstraints(TUTOR_POSITION_VALUE_X ,60, 300, 35));
            container.add(imageLabel,new AbsoluteConstraints(IMAGE_POSITION_VALUE_X ,20, 100,100));
            
            container.add(studentNameKey,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(studentNameValue,new AbsoluteConstraints(LABEL_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            container.add(tutorNameKey,new AbsoluteConstraints(TUTOR_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(tutorNameValue,new AbsoluteConstraints(LABEL_TUTOR_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            positionValueY += SPACING;
            container.add(studentLastNameKey,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(studentLastNameValue,new AbsoluteConstraints(LABEL_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            container.add(tutorLastNameKey,new AbsoluteConstraints(TUTOR_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(tutorLastNameValue,new AbsoluteConstraints(LABEL_TUTOR_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            positionValueY += SPACING;
            container.add(studentDniKey,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(studentDniValue,new AbsoluteConstraints(LABEL_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            container.add(tutorPhoneNumberKey,new AbsoluteConstraints(TUTOR_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(tutorPhoneNumberValue,new AbsoluteConstraints(LABEL_TUTOR_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            positionValueY += SPACING;
            container.add(studentPhoneNumberKey,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(studentPhoneNumberValue,new AbsoluteConstraints(LABEL_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            container.add(tutorAddressKey,new AbsoluteConstraints(TUTOR_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(tutorAddressValue,new AbsoluteConstraints(LABEL_TUTOR_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            positionValueY += SPACING;
            container.add(studentEmailKey,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(studentEmailValue,new AbsoluteConstraints(LABEL_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            positionValueY += SPACING;
            container.add(studentCourseKey,new AbsoluteConstraints(STUDENT_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(studentCourseValue,new AbsoluteConstraints(LABEL_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TUTOR_VALUE_WIDTH, 20));
            
            updateLabelTutor.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UpdateDataTutor updateDataTutor = new UpdateDataTutor();
                    updateDataTutor.loadTutor(studentLogged.getTutor());
                }
            });

            updateLabelStudent.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UpdateData updateData = new UpdateData();
                    updateData.loadUser(user);
                }
            });
            
        } else if("profesor".equals(this.user.getTipoUsuario().getTipo())) {
            
            Profesor teacherLogged = this.teacherService.mostrarPorIDUsuario(this.user.getIdUsuario());
            
            final int TEACHER_POSITION_VALUE_X = 350;
            final int FIELD_VALUE_POSITION_VALUE_X = TEACHER_POSITION_VALUE_X + 100;
            final int FIELD_TEACHER_WIDTH_VALUE = 200;
            final int SPACING = 40;
            int positionValueY = 100;
            
            JLabel teacherTitle = new JLabel("Profesor");
            JLabel teacherNameKey = new JLabel("Nombre:");
            JLabel teacherLastNameKey = new JLabel("Apellido:");
            JLabel teacherCuilKey = new JLabel("Cuil:");
            JLabel teacherPhoneNumberKey = new JLabel("Telefono:");
            JLabel teacherEmailKey = new JLabel("Email:");
            JLabel teacherTypeKey = new JLabel("Tipo:");
            
            ImageIcon updateIcon = new ImageIcon("src/resources/icon_edit.png");
            JLabel updateLabelTeacher = new JLabel();
            updateLabelTeacher.setIcon(updateIcon);
            updateLabelTeacher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            teacherTitle.setFont(fontTitle);
            teacherTitle.setForeground(Color.WHITE);
            teacherNameKey.setFont(fontLabelKey);
            teacherNameKey.setForeground(Color.WHITE);
            teacherLastNameKey.setFont(fontLabelKey);
            teacherLastNameKey.setForeground(Color.WHITE);
            teacherCuilKey.setFont(fontLabelKey);
            teacherCuilKey.setForeground(Color.WHITE);
            teacherPhoneNumberKey.setFont(fontLabelKey);
            teacherPhoneNumberKey.setForeground(Color.WHITE);
            teacherEmailKey.setFont(fontLabelKey);
            teacherEmailKey.setForeground(Color.WHITE);
            teacherTypeKey.setFont(fontLabelKey);
            teacherTypeKey.setForeground(Color.WHITE);
            
            JLabel teacherNameValue = new JLabel(teacherLogged.getNombre());
            JLabel teacherLastNameValue = new JLabel(teacherLogged.getApellido());
            JLabel teacherCuilValue = new JLabel(String.valueOf(teacherLogged.getCuil()));
            JLabel teacherPhoneNumberValue = new JLabel(String.valueOf(teacherLogged.getTelefono()));
            JLabel teacherEmailValue = new JLabel(teacherLogged.getEmail());
            JLabel teacherTypeValue = new JLabel(teacherLogged.getTipoProfesor().getTipo());
            
            teacherNameValue.setFont(fontLabelValue);
            teacherNameValue.setForeground(Color.WHITE);
            teacherLastNameValue.setFont(fontLabelValue);
            teacherLastNameValue.setForeground(Color.WHITE);
            teacherCuilValue.setFont(fontLabelValue);
            teacherCuilValue.setForeground(Color.WHITE);
            teacherPhoneNumberValue.setFont(fontLabelValue);
            teacherPhoneNumberValue.setForeground(Color.WHITE);
            teacherEmailValue.setFont(fontLabelValue);
            teacherEmailValue.setForeground(Color.WHITE);
            teacherTypeValue.setFont(fontLabelValue);
            teacherTypeValue.setForeground(Color.WHITE);
            
            container.add(teacherTitle,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,40, 300, 35));  
            container.add(updateLabelTeacher,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X + 120,50, 20, 20));
            
            container.add(teacherNameKey,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(teacherNameValue,new AbsoluteConstraints(FIELD_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TEACHER_WIDTH_VALUE, 20));
            positionValueY += SPACING;
            container.add(teacherLastNameKey,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(teacherLastNameValue,new AbsoluteConstraints(FIELD_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TEACHER_WIDTH_VALUE, 20));
            positionValueY += SPACING;
            container.add(teacherCuilKey,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(teacherCuilValue,new AbsoluteConstraints(FIELD_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TEACHER_WIDTH_VALUE, 20));
            positionValueY += SPACING;
            container.add(teacherPhoneNumberKey,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(teacherPhoneNumberValue,new AbsoluteConstraints(FIELD_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TEACHER_WIDTH_VALUE, 20));
            positionValueY += SPACING;
            container.add(teacherEmailKey,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(teacherEmailValue,new AbsoluteConstraints(FIELD_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TEACHER_WIDTH_VALUE, 20));
            positionValueY += SPACING;
            container.add(teacherTypeKey,new AbsoluteConstraints(TEACHER_POSITION_VALUE_X ,positionValueY, 100, 20)); 
            container.add(teacherTypeValue,new AbsoluteConstraints(FIELD_VALUE_POSITION_VALUE_X ,positionValueY, FIELD_TEACHER_WIDTH_VALUE, 20));
            

            updateLabelTeacher.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UpdateData updateData = new UpdateData();
                    updateData.loadUser(user);
                }
            });

        }
        container.revalidate();
        container.repaint();
    }
    
    
    private void createContentMaterials() {
        container.removeAll();
        container.setLayout(new AbsoluteLayout());
        
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();
        scrollPane.getViewport().setBackground(Color.BLACK);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);

        
        if("estudiante".equals(this.user.getTipoUsuario().getTipo())) {
            
            JLabel titleMaterials = new JLabel("Mis materias");
            JLabel filterByText = new JLabel("Filtrar por");
            JComboBox filterBy = new JComboBox();
            
            filterBy.addItem("Materias");
            filterBy.addItem("Estudiantes");

            titleMaterials.setFont(fontTitle);
            titleMaterials.setForeground(Color.WHITE);
            filterByText.setFont(fontLabelValue);
            filterByText.setForeground(Color.WHITE);
            
            container.add(titleMaterials,new AbsoluteConstraints(350 ,20, 300, 35)); 
            container.add(filterByText,new AbsoluteConstraints(520 ,80, 200, 20)); 
            container.add(filterBy,new AbsoluteConstraints(600 ,80, 100, 20)); 
            container.add(scrollPane,new AbsoluteConstraints(200 ,100, 500, 300)); 
            
            String selectedOption = (String) filterBy.getSelectedItem();
            loadTableStudent(model,selectedOption);
            
            filterBy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedOptionListener = (String) filterBy.getSelectedItem();
                    loadTableStudent(model,selectedOptionListener);
                }
            });
            
        } else if("profesor".equals(this.user.getTipoUsuario().getTipo())) {
            JLabel titleMaterials = new JLabel("Mis materias");
            JLabel filterByText = new JLabel("Filtrar por");
            JComboBox filterBy = new JComboBox();
            JButton btnSelect = new JButton("Seleccionar");
            
            filterBy.addItem("Materias");
            filterBy.addItem("Cursos");

            titleMaterials.setFont(fontTitle);
            titleMaterials.setForeground(Color.WHITE);
            filterByText.setFont(fontLabelValue);
            filterByText.setForeground(Color.WHITE);
            
            container.add(titleMaterials,new AbsoluteConstraints(350 ,20, 300, 35)); 
            container.add(filterByText,new AbsoluteConstraints(520 ,80, 200, 20)); 
            container.add(filterBy,new AbsoluteConstraints(600 ,80, 100, 20)); 
            container.add(scrollPane,new AbsoluteConstraints(200 ,100, 500, 100)); 
            container.add(btnSelect,new AbsoluteConstraints(550,200, 150, 20)); 
            
            String selectedOption = (String) filterBy.getSelectedItem();
            loadTableTeacher(model,selectedOption);
            
            filterBy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedOptionListener = (String) filterBy.getSelectedItem();
                    loadTableTeacher(model,selectedOptionListener);
                }
            });
            btnSelect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();

                    if (selectedRow >= 0) {
                        String selectedOptionListener = (String) filterBy.getSelectedItem();

                        Object data = model.getValueAt(selectedRow, 0); 
                        String rowName = data.toString();
                        showStudentsSelect(selectedOptionListener,rowName);
                        
                    } else {
                        JOptionPane.showMessageDialog(container, "No se ha seleccionado ninguna fila", "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            
        }
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        container.revalidate();
        container.repaint();
    }

    private void showStudentsSelect(String selectedOptionListener, String rowName) {
        if("Materias".equals(selectedOptionListener)){
            Materia subjectSelected = this.subjectService.mostrarPorNombre(rowName);
            List<Estudiante> studentsBySubject = this.studentService.mostrarPorMateria(subjectSelected.getIdMateria());
            
            ShowStudents showStudents = new ShowStudents();
            showStudents.loadStudent(studentsBySubject, rowName);
        } else if("Cursos".equals(selectedOptionListener)) {
            Curso courseSelected = this.courseService.mostrarPorNombre(rowName);
            List<Estudiante> studentsByCourse = this.studentService.mostrarPorCurso(courseSelected.getIdCurso());
            
            ShowStudents showStudents = new ShowStudents();
            showStudents.loadStudent(studentsByCourse, rowName);
        }
    }
    
    private void loadTableTeacher(DefaultTableModel model,String selectedOption) {
        Profesor teacherLogged = this.teacherService.mostrarPorIDUsuario(this.user.getIdUsuario());
        if("Materias".equals(selectedOption)) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Materias");
            model.addColumn("Profesores");
            model.addColumn("Cursos");
            
            List<Materia> subjectsByTeacher = this.subjectService.mostrarPorProfesor(teacherLogged.getId());
            
            for(Materia subject : subjectsByTeacher) {
                List<Profesor> teachers = this.teacherService.mostrarPorMateria(subject.getIdMateria());
                String teachersName = "";
                if(!teachers.isEmpty()) {
                    for(Profesor teacher : teachers) {
                        teachersName += teacher.getNombre() + ",";
                    }
                    teachersName = teachersName.substring(0, teachersName.length() - 1);
                } else {
                    teachersName = "No registrado";
                }
                
                model.addRow(new Object[]{subject.getNombre(), teachersName, subject.getCurso().getNombre()});
            }
            
            
        } else if("Cursos".equals(selectedOption)) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Cursos");
            
            List<Curso> coursesByTeacher = this.courseService.mostrarPorProfesor(teacherLogged.getId());
            
            for(Curso course : coursesByTeacher) {
                model.addRow(new Object[]{course.getNombre()});
            }
            
        }
    }
    private void loadTableStudent(DefaultTableModel model,String selectedOption) {
        Estudiante studentLogged = this.studentService.mostrarPorIDUsuario(this.user.getIdUsuario());
        if("Materias".equals(selectedOption)) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Materias");
            model.addColumn("Profesores");
            model.addColumn("Curso");
            
            List<Materia> subjectsByCourse = this.subjectService.mostrarPorCurso(studentLogged.getCurso().getIdCurso());
            
            for(Materia subject : subjectsByCourse) {
                List<Profesor> teachers = this.teacherService.mostrarPorMateria(subject.getIdMateria());
                String teachersName = "";
                if(!teachers.isEmpty()) {
                    for(Profesor teacher : teachers) {
                        teachersName += teacher.getNombre() + ",";
                    }
                    teachersName = teachersName.substring(0, teachersName.length() - 1);
                } else {
                    teachersName = "No registrado";
                }

                model.addRow(new Object[]{subject.getNombre(), teachersName, studentLogged.getCurso().getNombre()});
            }
            
                
        } else if("Estudiantes".equals(selectedOption)) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Compañeros");
            List<Estudiante> students = this.studentService.mostrarPorCurso(studentLogged.getCurso().getIdCurso());
            if(!students.isEmpty()) {
                for(Estudiante student : students) {
                    if(student.getIdEstudiante() != studentLogged.getIdEstudiante()) {
                        model.addRow(new Object[]{student.getNombre()});  
                    }
                    else {
                        model.addRow(new Object[]{"No hay estudiantes registrados"});  
                    }
                }
            } else {
                model.addRow(new Object[]{"No hay estudiantes registrados"});
            }

        }
    }
    
    private void createContentHistory() {
        container.removeAll();
        container.setLayout(new AbsoluteLayout());
        final int CONTENT_VALUE_POSITION_X = 20;
        final int LABEL_WIDTH_VALUE = 500;
        final int LABEL_HEIGHT_VALUE = 100;
        final int SPACING = 20;
        
        int positionY = 15;
        JLabel titleHistory = new JLabel("Historia de la institucion");
        titleHistory.setFont(fontTitle);
        titleHistory.setForeground(Color.WHITE);
        
        ImageIcon campusIcon = new ImageIcon("src/resources/image_history.jpg");
        JLabel campusIconLabel  = new JLabel();
        campusIconLabel.setIcon(campusIcon);
        
        JLabel content_1 = new JLabel("La Universidad Nacional del Centro de la Provincia de Buenos Aires, también conocida");
        JLabel content_2 = new JLabel("como UNCPBA o UNICEN, es una universidad pública argentina con epicentro en la ");
        JLabel content_3 = new JLabel("ciudad de Tandil. A su vez, tiene dependencias (facultades) en las localidades");
        JLabel content_4 = new JLabel("cercanas de Azul y Olavarría, en el centro del interior de la Provincia de Buenos Aires");
        JLabel content_5 = new JLabel("Fue fundada en 1974 por ley 20.753, en el marco del plan Taquini. Sin embargo,");
        JLabel content_6 = new JLabel("previamente ya funcionaba en Tandil un instituto universitario privado," );
        JLabel content_7= new JLabel("y en Azul y Olavarría existían institutos vinculados a la");
        JLabel content_8 = new JLabel("Universidad Nacional del Sur de Bahía Blanca. La UNICEN se formó aglomerando");
        JLabel content_9 = new JLabel("toda esta infraestructura ya existente con el objetivo de proveer estudios");
        JLabel content_10 = new JLabel("universitarios en la región y evitar de ese modo la emigración masiva hacia");
        JLabel content_11 = new JLabel("polos universitarios como la Ciudad de Buenos Aires o La Plata.");
        
        content_1.setFont(fontBody);
        content_1.setForeground(Color.WHITE);
        content_2.setFont(fontBody);
        content_2.setForeground(Color.WHITE);
        content_3.setFont(fontBody);
        content_3.setForeground(Color.WHITE);
        content_4.setFont(fontBody);
        content_4.setForeground(Color.WHITE);
        content_5.setFont(fontBody);
        content_5.setForeground(Color.WHITE);
        content_6.setFont(fontBody);
        content_6.setForeground(Color.WHITE);
        content_7.setFont(fontBody);
        content_7.setForeground(Color.WHITE);
        content_8.setFont(fontBody);
        content_8.setForeground(Color.WHITE);
        content_9.setFont(fontBody);
        content_9.setForeground(Color.WHITE);
        content_10.setFont(fontBody);
        content_10.setForeground(Color.WHITE);
        content_11.setFont(fontBody);
        content_11.setForeground(Color.WHITE);
        
        container.add(titleHistory,new AbsoluteConstraints(100 ,10, 300, 20));
        container.add(campusIconLabel,new AbsoluteConstraints(560 ,0, 350, 408));
        
        container.add(content_1,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_2,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_3,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_4,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_5,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_6,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_7,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_8,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_9,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_10,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_11,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        
        container.revalidate();
        container.repaint();
    }
    
    private void createContentServices(JMenuItem itemSelected) {
        container.removeAll();
        container.setLayout(new AbsoluteLayout());
        
        final int CONTENT_VALUE_POSITION_X = 20;
        final int LABEL_WIDTH_VALUE = 500;
        final int LABEL_HEIGHT_VALUE = 100;
        final int SPACING = 20;
        
        int positionY = 15;
        
        String itemName = itemSelected.getText();
        JLabel itemTitle = new JLabel();
        itemTitle.setText(itemName);
        itemTitle.setFont(fontTitle);
        itemTitle.setForeground(Color.WHITE);
        
        JLabel itemIcon = new JLabel();
        
        JLabel content_1 = new JLabel();
        JLabel content_2 = new JLabel();
        JLabel content_3 = new JLabel();
        JLabel content_4 = new JLabel();
        JLabel content_5 = new JLabel();
        JLabel content_6 = new JLabel();
        JLabel content_7= new JLabel();
        JLabel content_8 = new JLabel();
        JLabel content_9 = new JLabel();
        JLabel content_10 = new JLabel();
        JLabel content_11 = new JLabel();
        
        if("Comedor".equals(itemName)) {
            ImageIcon diningRoomIcon = new ImageIcon("src/resources/image_dining_room.jpg");
            itemIcon.setIcon(diningRoomIcon);
            
            content_1.setText("La Universidad Nacional del Centro de la Provincia de Buenos Aires cuenta con un");
            content_2.setText("comedor universitario en cada una de sus sedes (autogestionado en las ciudades");
            content_3.setText("de  Tandil, Olavarría y concesionado en la ciudad de Azul y Quequén)");
            content_4.setText("donde los estudiantes pueden acceder a una dieta equilibradaa un muy bajo costo.");
            content_5.setText("Actualmente en el comedor del campus universitario Tandil almuerzan más de 1000");
            content_6.setText("personas por día, entre alumnos, personal docente y no docente; el mismo consta");
            content_7.setText("con capacidad para 435 personas sentadas.El menú consta de plato principal,");
            content_8.setText("postre y pan y es programado semanalmente, por una nutricionista, procurando");
            content_9.setText("aportar las proteínas, vitaminas y fibras necesarias para una jornada de actividad");
            
        } else if("Centro Cultural".equals(itemName)) {
            ImageIcon culturalCenterIcon = new ImageIcon("src/resources/image_cultural_center.jpg");
            itemIcon.setIcon(culturalCenterIcon);
            
            content_1.setText("Situado en Yrigoyen 662 de la ciudad de Tandil, se encuentra el Centro Cultural");
            content_2.setText("universitario. El cual dispone de 3 amplias plantas con cómodos halls de acceso ");
            content_3.setText("en cada una. Cuenta además con rampa y ascensor para el mejor acceso de personas");
            content_4.setText("discapacitadas o con movilidad reducida. Entre sus espacios se destaca un amplio");
            content_5.setText("gimnasio  con capacidad para 2700 personas en el cual se realizan todo tipo de");
            content_6.setText("actividades, tanto deportivas como culturales; y el moderno Auditórium en el cual");
            content_7.setText("funciona actualmente el espacio INCAA, donde se realizan obras de teatro, congresos,");
            content_8.setText("colaciones, espectáculos diversos, etc.");
            content_9.setText("En el primer piso del Centro Cultural, el Auditórium cuenta con cortinado móvil y una");
            content_10.setText("pantalla fija para proyección de videos y películas 2D y 3D. Cuenta con camarines");
            content_11.setText("equipados para cualquier tipo de espectáculo");
            
        } else if("Residencias".equals(itemName)) {
            ImageIcon residencesIcon = new ImageIcon("src/resources/image_residences.jpg");
            itemIcon.setIcon(residencesIcon);
            
            content_1.setText("La Universidad otorga, a través de la Secretaría de Bienestar Estudiantil, Becas");
            content_2.setText("de Residencias Universitaria, para estudiantes con bajo nivel socio-económico,");
            content_3.setText("buen rendimiento académico y adecuado perfil psicológico. Desde el mes de Julio");
            content_4.setText("del año 2015, funciona en la Sede Tandil, un módulo con capacidad para");
            content_5.setText("72 estudiantes, con 36 habitaciones para dos alumnos por habitación, distribuidos");
            content_6.setText("en 4 alas, con 5 baños por ala, con duchas y vestidores, un comedor común.");
            content_7.setText("En la sede Olavarría funciona la Residencia Universitaria con capacidad para");
            content_8.setText("20 alumnos. Posee habitaciones dobles con baño privado, sala de estar común");
            content_9.setText("y comedor.En la Sede Azul, funciona el Barrio Universitario con  36 casas, que");
            content_10.setText("la Universidad alquila a diversos Municipios mediante convenios. Se encuentran");
            content_11.setText("en etapa de acondicionamiento cinco viviendas de dicho Barrio");
            
        } else if("Biblioteca".equals(itemName)) {
            ImageIcon libraryIcon = new ImageIcon("src/resources/image_library.jpg");
            itemIcon.setIcon(libraryIcon);
            
            content_1.setText("El Sistema de Bibliotecas de la UNICEN está compuesto por la Biblioteca Central,");
            content_2.setText("ubicada en Campus Universitario Tandil, las de la Sede Olavarría ubicadas");
            content_3.setText("en el Campus Universitario y Escuela Superior de Ciencias de la Salud las de");
            content_4.setText("la Sede Azul ubicadas en el Campus Universitario y Biblioteca de Posgrado y la");
            content_5.setText("de Unidad de Enseñanza Universitaria de Quequén.");
            content_6.setText("El fondo bibliográfico suma más de 96500 libros y 876 títulos de publicaciones");
            content_7.setText("periódicas,además de recursos virtuales: PROQUEST hemeroteca y bases de datos");
            content_8.setText("especializadas en ingeniería, negocios, computación, ciencias humanas y sociales");
            content_9.setText("y obras de consulta y referencia en CD (1995-2000) y Acceso a Biblioteca Electrónica");
            content_10.setText("del MINCYT");
        }
        
        content_1.setFont(fontBody);
        content_1.setForeground(Color.WHITE);
        content_2.setFont(fontBody);
        content_2.setForeground(Color.WHITE);
        content_3.setFont(fontBody);
        content_3.setForeground(Color.WHITE);
        content_4.setFont(fontBody);
        content_4.setForeground(Color.WHITE);
        content_5.setFont(fontBody);
        content_5.setForeground(Color.WHITE);
        content_6.setFont(fontBody);
        content_6.setForeground(Color.WHITE);
        content_7.setFont(fontBody);
        content_7.setForeground(Color.WHITE);
        content_8.setFont(fontBody);
        content_8.setForeground(Color.WHITE);
        content_9.setFont(fontBody);
        content_9.setForeground(Color.WHITE);
        content_10.setFont(fontBody);
        content_10.setForeground(Color.WHITE);
        content_11.setFont(fontBody);
        content_11.setForeground(Color.WHITE);
        
        container.add(itemTitle,new AbsoluteConstraints(200 ,10, 300, 30));
        container.add(itemIcon,new AbsoluteConstraints(560 ,0, 350, 408));
        
        container.add(content_1,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_2,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_3,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_4,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_5,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_6,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_7,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_8,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_9,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_10,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
        positionY += SPACING;
        container.add(content_11,new AbsoluteConstraints(CONTENT_VALUE_POSITION_X ,positionY, LABEL_WIDTH_VALUE, LABEL_HEIGHT_VALUE));
           
        
        container.revalidate();
        container.repaint();
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
        image = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        JField_1 = new javax.swing.JLabel();
        JField_2 = new javax.swing.JLabel();
        JField_3 = new javax.swing.JLabel();
        JField_4 = new javax.swing.JLabel();
        JField_5 = new javax.swing.JLabel();
        JField_6 = new javax.swing.JLabel();
        JField_7 = new javax.swing.JLabel();
        navbar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setBackground(new java.awt.Color(0, 0, 0));
        container.setToolTipText("");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image_menu.jpg"))); // NOI18N
        image.setText("jLabel1");

        title.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Sistema de gestion institucional");

        JField_1.setForeground(new java.awt.Color(255, 255, 255));
        JField_1.setText("Este es un sistema que ayuda a la gestión de las instituciones educativas, simplificando y ");

        JField_2.setForeground(new java.awt.Color(255, 255, 255));
        JField_2.setText("optimizando el manejo de información crucial relacionada con los usuarios. Desde ");

        JField_3.setForeground(new java.awt.Color(255, 255, 255));
        JField_3.setText("estudiantes y profesores hasta personal administrativo, nuestra aplicación proporciona una ");

        JField_4.setForeground(new java.awt.Color(255, 255, 255));
        JField_4.setText("plataforma centralizada para administrar perfiles, y conocer los recursos de las instituciones .");

        JField_5.setForeground(new java.awt.Color(255, 255, 255));
        JField_5.setText("Con nuestra herramienta, las instituciones pueden mejorar la eficiencia de sus operaciones y");

        JField_6.setForeground(new java.awt.Color(255, 255, 255));
        JField_6.setText("ofrecer una experiencia educativa más fluida y organizada para todos los involucrados");

        JField_7.setForeground(new java.awt.Color(255, 255, 255));
        JField_7.setText("Simplifique la administración escolar y potencie el éxito académico con nuestra aplicación");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(title))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JField_2)
                            .addComponent(JField_1)
                            .addComponent(JField_3)
                            .addComponent(JField_4)
                            .addComponent(JField_5)
                            .addComponent(JField_6)
                            .addComponent(JField_7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(image)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(JField_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JField_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JField_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JField_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JField_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JField_6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JField_7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        navbar.setPreferredSize(new java.awt.Dimension(16, 15));
        setJMenuBar(navbar);

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JField_1;
    private javax.swing.JLabel JField_2;
    private javax.swing.JLabel JField_3;
    private javax.swing.JLabel JField_4;
    private javax.swing.JLabel JField_5;
    private javax.swing.JLabel JField_6;
    private javax.swing.JLabel JField_7;
    private javax.swing.JPanel container;
    private javax.swing.JLabel image;
    private javax.swing.JMenuBar navbar;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
