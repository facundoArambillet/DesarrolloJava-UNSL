package ejercicio_1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;

public class WindowMenu extends JFrame{
   
    public WindowMenu() {
        
        super("Ejercicio 1");
        
        // Obtengo  el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calculo el tamaño y la posición de la ventana
        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        // Establezco el tamaño y la posición de la ventana
        setBounds(windowX, windowY, windowWidth, windowHeight);
        
        JLabel label = new JLabel("Hola Mundo Desarrolladores de Java");
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label);
        
        // Muestro la ventana
        setVisible(true);
        
        // Cierro la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
