package utilities;
import model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class utilities {
    private String usuario;
    private String contraseña;
    public int creditosDisponibles;
    private List<Curso> cursosSeleccionados;
    private ArrayList<Curso> cursos;

    public utilities() {
        cursos = new ArrayList<>();
        cursosSeleccionados = new ArrayList<>();
        // cursos dispo
        cursos.add(new Curso("Física", 3,1));
        cursos.add(new Curso("Matemáticas", 4,2));
        cursos.add(new Curso("Programación", 5,3));
        cursos.add(new Curso("Inglés", 4,4));
    }
    public boolean Credenciales() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese su usuario: ");
            usuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            contraseña = scanner.nextLine();

            creditosDisponibles = 16; // Establecer créditos disponibles

            // Credenciales
            if (usuario.equals("camilito") && contraseña.equals("123")) {
                System.out.println("Autenticación exitosa!");
                return true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Vuelva a intentar.");
            }
        }
    }
    public void mostrarCursos() {
        System.out.println("Cursos disponibles:");
        for (Curso curso : cursos) {
            System.out.println(curso.getNombre() + ":" + curso.getCreditos() + " créditos"+"\t ID:|"+curso.getId()+"|");
        }
    }
    public void seleccionCursos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione los cursos separados por coma: ");
        String[] seleccionados = scanner.nextLine().split(",");
        for (String curso : seleccionados) {
            curso = curso.trim();
            boolean encontrado = false;
            int cursoId = Integer.parseInt(curso);

            for (Curso c1 : cursos) {
                if (c1.getId()== cursoId) {
                    cursosSeleccionados.add(c1); // Agregar el objeto Curso completo
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Curso " + curso + " no disponible.");
            }
        }
    }
    public int calcularCreditos() {
        int totalCreditos = 0;
        for (Curso curso : cursosSeleccionados) {
            totalCreditos += curso.getCreditos(); // Sumar créditos
        }
        return totalCreditos;
    }
    public void mostrarResumen() {
        int totalCreditos = calcularCreditos();
        System.out.println("[CURSOS SELECCIONADOS]:");
        for (Curso curso : cursosSeleccionados) {
            System.out.println(curso.getNombre() + " - " + curso.getCreditos() + " créditos");
        }
        System.out.println("Total de créditos: " + totalCreditos);
    }
}
