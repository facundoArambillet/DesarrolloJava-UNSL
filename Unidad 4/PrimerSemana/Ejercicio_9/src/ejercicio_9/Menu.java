package ejercicio_9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame{
    
    public Menu() {
        super("Ejercicio 9");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        setBounds(windowX, windowY, windowWidth, windowHeight);
        setLayout(new BorderLayout());

        JButton buttonNorth = new JButton("Norte");
        JButton buttonSouth = new JButton("Sur");
        JButton buttonEast = new JButton("Este");
        JButton buttonWest = new JButton("Oeste");
        JButton buttonCenter = new JButton("Centro");

        add(buttonNorth, BorderLayout.NORTH);
        add(buttonSouth, BorderLayout.SOUTH);
        add(buttonEast, BorderLayout.EAST);
        add(buttonWest, BorderLayout.WEST);
        add(buttonCenter, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
