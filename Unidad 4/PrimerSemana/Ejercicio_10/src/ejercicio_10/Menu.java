package ejercicio_10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Menu extends JFrame{
    String[] courses = {"Matemática","Literatura y Lengua","Idioma","Historia","Derecho"};
    
    public Menu() {
        super("Ejercicio 10");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        setBounds(windowX, windowY, windowWidth, windowHeight);
        setLayout(new BorderLayout());
        
        JList<String> listCourses = new JList<>(courses);

        //add(new JScrollPane(listaMaterias));
        add(listCourses);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}
