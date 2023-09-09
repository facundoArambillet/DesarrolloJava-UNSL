package integradorgui;

import models.Curso;
import models.Materia;
import models.ProfesorTipo;
import models.UsuarioTipo;
import services.CursoService;
import services.MateriaService;
import services.ProfesorTipoService;
import services.UsuarioTipoService;
import ui.Login;

public class IntegradorGui {
    
    public static void main(String[] args) {
        setUp();
        Login login = new Login();
    }
    
    public static void setUp() {
        UsuarioTipoService userTypeService = new UsuarioTipoService();
        ProfesorTipoService teacherTypeService = new ProfesorTipoService();
        CursoService courseService = new CursoService();
        MateriaService subjectService = new MateriaService();
        //Para que se ejecute unicamente la primera vez que se inicia el programa
        if(courseService.mostrarTodos().isEmpty()) {
       
            UsuarioTipo type_1 = new UsuarioTipo("profesor");
            UsuarioTipo type_2 = new UsuarioTipo("estudiante");

            ProfesorTipo teacherType_1 = new ProfesorTipo("Titular");
            ProfesorTipo teacherType_2 = new ProfesorTipo("Suplente");

            Curso course_1 = new Curso("1ro");
            Curso course_2 = new Curso("2do");
            Curso course_3 = new Curso("3ro");
            Curso course_4 = new Curso("4to");
            Curso course_5 = new Curso("5to");
            Curso course_6 = new Curso("6to");
            
            Curso courseCreated_1 = courseService.crearCurso(course_1);
            Curso courseCreated_2 = courseService.crearCurso(course_2);
            Curso courseCreated_3 = courseService.crearCurso(course_3);
            Curso courseCreated_4 = courseService.crearCurso(course_4);
            Curso courseCreated_5 = courseService.crearCurso(course_5);
            Curso courseCreated_6 = courseService.crearCurso(course_6);
            
            Curso courseBase_1 = courseService.mostrarPorNombre(courseCreated_1.getNombre());
            Curso courseBase_2 = courseService.mostrarPorNombre(courseCreated_2.getNombre());
            Curso courseBase_3 = courseService.mostrarPorNombre(courseCreated_3.getNombre());
            Curso courseBase_4 = courseService.mostrarPorNombre(courseCreated_4.getNombre());
            Curso courseBase_5 = courseService.mostrarPorNombre(courseCreated_5.getNombre());
            Curso courseBase_6 = courseService.mostrarPorNombre(courseCreated_6.getNombre());
            
            Materia subject_1_course_1 = new Materia("Matematica I",courseBase_1);
            Materia subject_2_course_1 = new Materia("Literatura I",courseBase_1);
            Materia subject_3_course_1 = new Materia("Geografia I",courseBase_1);
            Materia subject_4_course_1 = new Materia("Biologica I",courseBase_1);
            Materia subject_5_course_1 = new Materia("Fisica I",courseBase_1);
            Materia subject_6_course_1 = new Materia("Quimica I",courseBase_1);
            
            Materia subject_1_course_2 = new Materia("Matematica II",courseBase_2);
            Materia subject_2_course_2 = new Materia("Literatura II",courseBase_2);
            Materia subject_3_course_2 = new Materia("Geografia II",courseBase_2);
            Materia subject_4_course_2 = new Materia("Biologica II",courseBase_2);
            Materia subject_5_course_2 = new Materia("Fisica II",courseBase_2);
            Materia subject_6_course_2 = new Materia("Quimica II",courseBase_2);
            
            Materia subject_1_course_3 = new Materia("Matematica III",courseBase_3);
            Materia subject_2_course_3 = new Materia("Literatura III",courseBase_3);
            Materia subject_3_course_3 = new Materia("Geografia III",courseBase_3);
            Materia subject_4_course_3 = new Materia("Biologica III",courseBase_3);
            Materia subject_5_course_3 = new Materia("Fisica III",courseBase_3);
            Materia subject_6_course_3 = new Materia("Quimica III",courseBase_3);
            
            Materia subject_1_course_4 = new Materia("Matematica IV",courseBase_4);
            Materia subject_2_course_4 = new Materia("Literatura IV",courseBase_4);
            Materia subject_3_course_4 = new Materia("Geografia IV",courseBase_4);
            Materia subject_4_course_4= new Materia("Biologica IV",courseBase_4);
            Materia subject_5_course_4 = new Materia("Fisica IV",courseBase_4);
            Materia subject_6_course_4 = new Materia("Quimica IV",courseBase_4);
            
            Materia subject_1_course_5 = new Materia("Matematica V",courseBase_5);
            Materia subject_2_course_5 = new Materia("Literatura V",courseBase_5);
            Materia subject_3_course_5 = new Materia("Geografia V",courseBase_5);
            Materia subject_4_course_5= new Materia("Biologica V",courseBase_5);
            Materia subject_5_course_5 = new Materia("Fisica V",courseBase_5);
            Materia subject_6_course_5 = new Materia("Quimica V",courseBase_5);
            
            Materia subject_1_course_6 = new Materia("Matematica VI",courseBase_6);
            Materia subject_2_course_6 = new Materia("Literatura VI",courseBase_6);
            Materia subject_3_course_6 = new Materia("Geografia VI",courseBase_6);
            Materia subject_4_course_6 = new Materia("Biologica VI",courseBase_6);
            Materia subject_5_course_6 = new Materia("Fisica VI",courseBase_6);
            Materia subject_6_course_6 = new Materia("Quimica VI",courseBase_6);

            userTypeService.crearTipoUsuario(type_1);
            userTypeService.crearTipoUsuario(type_2);

            teacherTypeService.crearProfesorTipo(teacherType_1);
            teacherTypeService.crearProfesorTipo(teacherType_2);

            subjectService.crearMateria(subject_1_course_1);
            subjectService.crearMateria(subject_2_course_1);
            subjectService.crearMateria(subject_3_course_1);
            subjectService.crearMateria(subject_4_course_1);
            subjectService.crearMateria(subject_5_course_1);
            subjectService.crearMateria(subject_6_course_1); 
            
            subjectService.crearMateria(subject_1_course_2);
            subjectService.crearMateria(subject_2_course_2);
            subjectService.crearMateria(subject_3_course_2);
            subjectService.crearMateria(subject_4_course_2);
            subjectService.crearMateria(subject_5_course_2);
            subjectService.crearMateria(subject_6_course_2); 
            
            subjectService.crearMateria(subject_1_course_3);
            subjectService.crearMateria(subject_2_course_3);
            subjectService.crearMateria(subject_3_course_3);
            subjectService.crearMateria(subject_4_course_3);
            subjectService.crearMateria(subject_5_course_3);
            subjectService.crearMateria(subject_6_course_3); 
            
            subjectService.crearMateria(subject_1_course_4);
            subjectService.crearMateria(subject_2_course_4);
            subjectService.crearMateria(subject_3_course_4);
            subjectService.crearMateria(subject_4_course_4);
            subjectService.crearMateria(subject_5_course_4);
            subjectService.crearMateria(subject_6_course_4); 
            
            subjectService.crearMateria(subject_1_course_5);
            subjectService.crearMateria(subject_2_course_5);
            subjectService.crearMateria(subject_3_course_5);
            subjectService.crearMateria(subject_4_course_5);
            subjectService.crearMateria(subject_5_course_5);
            subjectService.crearMateria(subject_6_course_5); 
            
            subjectService.crearMateria(subject_1_course_6);
            subjectService.crearMateria(subject_2_course_6);
            subjectService.crearMateria(subject_3_course_6);
            subjectService.crearMateria(subject_4_course_6);
            subjectService.crearMateria(subject_5_course_6);
            subjectService.crearMateria(subject_6_course_6); 
        }
 
    }
    
}
