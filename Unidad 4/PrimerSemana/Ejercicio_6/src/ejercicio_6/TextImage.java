package ejercicio_6;

import javax.swing.*;
import java.awt.*;

public class TextImage extends JPanel {

    public TextImage(String text, ImageIcon image) {
        super();

        // Hago que los elementos se agreguen uno de bajo del otro(Sino me queda la imagen a la izquierda y el texto a la derecha)
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
        // Agrego un espacio entre el texto y la barra
        add(Box.createVerticalStrut(10));
        
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT); //Centro el texto
        add(label);
       
        Image originalImage = image.getImage();

        int newWidth = 300;
        int newHeight = 250;

        // Redimensiono la imagen al nuevo ancho y altura
        Image newImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(newImage);
        
        // Agrego un espacio entre el texto y la imagen
        add(Box.createVerticalStrut(10));
        
        JLabel imageLabel = new JLabel(resizedImageIcon);
        
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //Centro la imagen
        add(imageLabel);

        setVisible(true);
    }
}