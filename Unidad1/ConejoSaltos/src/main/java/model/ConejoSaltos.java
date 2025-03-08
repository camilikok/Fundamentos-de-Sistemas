package model;
import utilities.utilities;

import javax.swing.*;

import static utilities.utilities.contarSaltos;

public class ConejoSaltos {
    public static void main(String[] args) {
        double A = 0, B = 100, C = 12.5;


        int saltos = contarSaltos(B, C);
        JOptionPane.showMessageDialog(null, "El conejo llega al Objetivo(C) en: " + saltos + " saltos", "Resultado", JOptionPane.INFORMATION_MESSAGE, utilities.obtenerImagenConejo());
    }
}
