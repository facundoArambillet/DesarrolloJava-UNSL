package ejercicio_7;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {
    
    public Menu() {
        super("Ejercicio 7");
        
            setSize(200,300);

            JPanel gridPanel = new JPanel(new GridLayout(3, 3,5,5)); // 3 filas, 3 columnas, espaciado de 5 píxeles entre botones
            for (int i = 1; i <= 9; i++) {
                JButton button = new JButton(String.valueOf(i));
                gridPanel.add(button);
            }

            add(gridPanel);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            
            
    }
    
    
}
