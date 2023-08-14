package ejercicio_12;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Menu extends JFrame{
    public Menu() {
        
        super("Ejercicio 12");
        
        JCheckBox checkBoxPop = new JCheckBox("Pop");
        JCheckBox checkBoxCuarteto = new JCheckBox("Cuarteto");

        JRadioButton radioButtonJazz = new JRadioButton("Jazz");
        JRadioButton radioButtonRock = new JRadioButton("Rock");
        JRadioButton radioButtonElectronica = new JRadioButton("Electrónica");

        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonJazz);
        radioButtonGroup.add(radioButtonRock);
        radioButtonGroup.add(radioButtonElectronica);

        JPanel panel = new JPanel();
        panel.add(checkBoxPop);
        panel.add(checkBoxCuarteto);
        panel.add(radioButtonJazz);
        panel.add(radioButtonRock);
        panel.add(radioButtonElectronica);

        add(panel);

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}
