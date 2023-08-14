package ejercicio_2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowMenu extends JFrame{
    
    public WindowMenu() {
        super("Ejercicio 2");
        
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

        // Creo el panel para los botones y configuro su layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 180));

        // Creo los botones
        JButton btnClicAqui = new JButton("Haz clic aquí por favor");
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        // Agrego los botones al panel
        panel.add(btnClicAqui);
        panel.add(btnAceptar);
        panel.add(btnCancelar);
        
        // Agreog el panel al JFrame
        add(panel);
        
        // Muestro la ventana
        setVisible(true);
        
        //No dejo que se modifique el tamaño
        setResizable(false);
        
        // Cierro la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
