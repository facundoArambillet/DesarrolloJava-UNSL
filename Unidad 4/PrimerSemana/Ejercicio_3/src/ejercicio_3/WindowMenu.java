package ejercicio_3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowMenu extends JFrame implements ActionListener{
    
    public WindowMenu() {
        super("Ejercicio 3");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int windowWidth = screenWidth / 2;
        int windowHeight = screenHeight / 2;
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        setBounds(windowX, windowY, windowWidth, windowHeight);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 180));
        
        JButton btnClick = new JButton("Hacer Click");
        btnClick.addActionListener(this);
        panel.add(btnClick);
        
        add(panel);
        
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Le paso la clase en la que estoy como parametro(WindowMenu)
        WindowDialog dialog = new WindowDialog(this);
    }
}
