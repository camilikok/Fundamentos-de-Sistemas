package comparador;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;

public class Main {
    public static void main(String[] args) {

    //cargar imagen
    java.net.URL imagen = Main.class.getResource("/icon1.jpg");
    if (imagen == null) {
           System.out.println("no esta el archivo");
           return;
       }
    ImageIcon iconOriginal = new ImageIcon(imagen);
    Image originalImage = iconOriginal.getImage();
    Image icono = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon iconoFinal = new ImageIcon(icono);
    

    
        boolean validarDatos = false;
        while (validarDatos == false) {
    String numA = JOptionPane.showInputDialog(null, "Ingresa el primer número entero que deseas evaluar");
    String numB = JOptionPane.showInputDialog(null, "Ingresa el segundo número entero que deseas evaluar");
       
        if (evaluarEnteros(numA) && evaluarEnteros(numB)) {
            validarDatos = true;
            //si se cumple los convertimos a interos para trabajar con ellos
            int numeroA = Integer.parseInt(numA);
            int numeroB = Integer.parseInt(numB);

            if (numeroA > numeroB) {
                JOptionPane.showMessageDialog(null, "El número " + numeroA + " es mayor que " + numeroB, "Resultado", JOptionPane.INFORMATION_MESSAGE, iconoFinal);
            
            } else if (numeroA < numeroB) {
                JOptionPane.showMessageDialog(null,"El número " + numeroB + " es mayor que " + numeroA,"Resultado", JOptionPane.INFORMATION_MESSAGE, iconoFinal);
            } else {
                JOptionPane.showMessageDialog(null, "Ambos números son iguales.");
            }
        } else {
                JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos, por favor ingresa números enteros");
        }
    }
}
    // revisarEntero
    public static boolean evaluarEnteros(String str) {
        try {
            double num = Double.parseDouble(str);
            return (num % 1 == 0); //num mod 1 = 0 para ser entero
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
