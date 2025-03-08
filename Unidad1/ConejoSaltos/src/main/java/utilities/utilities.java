package utilities;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class utilities {
    public static int contarSaltos(double distancia, double llegada) {
        int saltos = 0;
        while (distancia > llegada) {
            distancia = distancia / 2;
            saltos++;
        }
        return saltos;
    }
    //para el icono
    public static ImageIcon obtenerImagenConejo() {
        java.net.URL imgConejo = utilities.class.getResource("/images.jpg");
        if (imgConejo == null) {
            System.out.println("no esta el archivo");
            return null;
        }
        ImageIcon icon = new ImageIcon(imgConejo);
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(150, 90, java.awt.Image.SCALE_SMOOTH); // Redimensionar la imagen
        return new ImageIcon(newimg);
    }
}