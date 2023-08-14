package ejercicio_5;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame{
    
    public Menu() {
        super("Ejercicio 5");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        setBounds(windowX, windowY, windowWidth, windowHeight);

        String imagePath = "src/ejercicio_5/resources/javaImage.png";

        // Cargo la imagen
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // En el Jlabel añado la imagen
        JLabel imageLabel = new JLabel(imageIcon);

        add(imageLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
       
}
