package model;
import utilities.utilities;
import java.util.*;

public class MatriculaSemestre {

    public static void main(String[] args) {
        utilities utilities = new utilities();
        MatriculaSemestre sistema = new MatriculaSemestre();

        // Credenciales y avance
        if (utilities.Credenciales()) {
            utilities.mostrarCursos();
            utilities.seleccionCursos();
            // Resumen :)
            int totalCreditos = utilities.calcularCreditos();
            if (totalCreditos > utilities.creditosDisponibles) {
                System.out.println("Créditos insuficientes para completar la matrícula.");
            } else {
                utilities.mostrarResumen();
            }
        }
    }
}
