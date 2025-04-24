import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner telcado = new Scanner(System.in);

        String coreo, contrasenia;
        int opsion;

        System.out.println("Benvenido al sistemaa de reserba de vuelos");
        System.out.println("1. Registrarse");
        System.out.println("2. Inisiar sesion");
        opsion = telcado.nextInt();
        telcado.nextLine(); // limpiar buffer

        if (opsion == 1) {
            System.out.print("Ingrese su correo: ");
            coreo = telcado.nextLine();
            System.out.print("Cree su contraseñaa: ");
            contrasenia = telcado.nextLine();
            System.out.println("Usuario registardo");
        } else if (opsion == 2) {
            System.out.print("Coreo: ");
            coreo = telcado.nextLine();
            System.out.print("Contrasenia: ");
            contrasenia = telcado.nextLine();
            System.out.println("Sesion inisiada");
        } else {
            System.out.println("Opcion no valida");
            return;
        }

        System.out.println("\nMenu Principal:");
        System.out.println("1. consultar vuelos");
        System.out.println("2. Reserbar vuelo");
        System.out.println("3. comprar billete");

        opsion = telcado.nextInt();
        telcado.nextLine();

        if (opsion == 1) {
            System.out.println("Coonsulta por:");
            System.out.println("1. Horarios");
            System.out.println("2. Tarifas");
            System.out.println("3. Info vuelo");
            int sub = telcado.nextInt();
            System.out.println("Mostrando resultados...");
        } else if (opsion == 2) {
            System.out.print("Origen: ");
            String ori = telcado.nextLine();
            System.out.print("Destino: ");
            String des = telcado.nextLine();
            System.out.print("Fecha: ");
            String fecha = telcado.nextLine();
            System.out.print("Hora:");
            String hora = telcado.nextLine();
            System.out.println("Vuelo reservado para el " + fecha + " a las " + hora);
        } else if (opsion == 3) {
            System.out.print("Tarjeta de kredito: ");
            String tarj = telcado.nextLine();
            System.out.println("Billete komprado y enviado a su coreo");
        } else {
            System.out.println("Opcion no existe");
        }

        System.out.println("Fin del programa. Gracias :)");
        telcado.close();
    }
}