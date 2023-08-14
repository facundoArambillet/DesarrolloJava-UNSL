package ejercicio_4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class WindowMenu extends JFrame {
    
    public WindowMenu() {
        super("Ejercicio 4");
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
        JMenuItem newItem = new JMenuItem("Nuevo");
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");
        JMenuItem saveAsItem = new JMenuItem("Guardar Como");
        JMenuItem printItem = new JMenuItem("Imprimir");
        JMenuItem closeItem = new JMenuItem("Salir");

        menu.add(newItem);
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(saveAsItem);
        menu.add(printItem);
        menu.addSeparator(); // Agrego un separador entre "Imprimir" y "Salir"
        menu.add(closeItem);

        menuBar.add(menu);
        //Añado el menu y lo ubico arriba del todo(por defecto se pone en el medio por mi configuracion de ventana)
        add(menuBar,BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // Agrego ActionListener a cada opción del menú
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(newItem, "Opción Nuevo seleccionada.");
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(openItem, "Opción Abrir seleccionada.");
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(saveItem, "Opción Guardar seleccionada.");
            }
        });

        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(saveAsItem, "Opción Guardar Como seleccionada.");
            }
        });

        printItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(printItem, "Opción Imprimir seleccionada.");
            }
        });

        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
