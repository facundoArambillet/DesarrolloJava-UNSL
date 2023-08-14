package ejercicio_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowDialog extends JDialog{
    
    public WindowDialog(JFrame jframe) {
         super(jframe, "JDialog Ejercicio 3", true);

        // Creo un campo de texto
        JTextField textField = new JTextField(20);

        // Creo un botón "Aceptar" y le asocio un evento que cierre el JDialog
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(btnAceptar);

        add(panel);

        setSize(300, 150);
        
        //Ubico el panel respecto al padre
        setLocationRelativeTo(jframe);
        
        setVisible(true);
    }
}
