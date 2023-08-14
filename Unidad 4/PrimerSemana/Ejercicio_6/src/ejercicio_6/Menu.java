package ejercicio_6;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame{
    
    public Menu() {
        super("Ejercicio 6");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        setBounds(windowX, windowY, windowWidth, windowHeight);
        setLayout(new BorderLayout());
        
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        JMenuItem imageItem_1 = new JMenuItem("Mostrar imagen 1");
        JMenuItem imageItem_2 = new JMenuItem("Mostrar imagen 2");


        menu.add(imageItem_1);
        menu.add(imageItem_2);


        menuBar.add(menu);
        //Añado el menu y lo ubico arriba del todo(por defecto se pone en el medio por mi configuracion de ventana)
        add(menuBar,BorderLayout.NORTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        imageItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "src/ejercicio_6/resources/java_1.jpg";
                ImageIcon imageIcon = new ImageIcon(path);
                TextImage image = new TextImage("Primera imagen",imageIcon);
                //Si existe un TextImage lo remuevo del componente
                Component[] components = getContentPane().getComponents();
                for (Component comp : components) {
                    if (comp instanceof TextImage) {
                        getContentPane().remove(comp);
                    }
                }
                
                add(image);
                //Actualizo el contenedor para que reorganize los componentes
                revalidate();
            }
        });
        
        imageItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "src/ejercicio_6/resources/java_2.jpg";
                ImageIcon imageIcon = new ImageIcon(path);
                TextImage image = new TextImage("Segunda imagen",imageIcon);
                
                Component[] components = getContentPane().getComponents();
                for (Component comp : components) {
                    if (comp instanceof TextImage) {
                        getContentPane().remove(comp);
                    }
                }
                
                add(image);
                revalidate();
            }
        });
    }
}
