package ejercicio_11;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Menu extends JFrame{
   
    String[] colours = {"Rojo","Verde","Azul","Amarillo","Naranja","Morado","Blanco","Negro"};
    
    public Menu() {
        super("Ejercicio 11");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        setBounds(windowX, windowY, windowWidth, windowHeight);
        
        JComboBox<String> comboBoxColores = new JComboBox<>(colours);

        add(comboBoxColores);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
