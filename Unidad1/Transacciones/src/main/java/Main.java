import java.util.Scanner;

class Cliente {
    String nom, ciudad, prof, docId;
    boolean cuentaExenta;

    public Cliente(String nom, String ciudad, String prof, String docId, boolean cuentaExenta){
        this.nom = nom;
        this.ciudad = ciudad;
        this.prof = prof;
        this.docId = docId;
        this.cuentaExenta = cuentaExenta;
    }
}

public class Main {

    static double tasaCambio = 4236.63;
    static double maxComision = 11.5;
    static double gmf = 0.004;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cliente c = null;
        int opc = 0;
        boolean vinculado = false;

        System.out.println("----- BIENVENIDO A FastUSC -----");

        while(opc != 5){
            System.out.println("\nSeleccione opción:");
            System.out.println("1. Vincular cuenta PayPal");
            System.out.println("2. Recibir dinero por PayPal");
            System.out.println("3. Recibir dinero por SiPac");
            System.out.println("4. Consultar GMF");
            System.out.println("5. Salir");
            opc = Integer.parseInt(input.nextLine());

            switch(opc){
                case 1:
                    // Vinculación
                    System.out.println("Ingrese su nombre:");
                    String name = input.nextLine();
                    System.out.println("Ciudad:");
                    String city = input.nextLine();
                    System.out.println("Profesión:");
                    String profe = input.nextLine();
                    System.out.println("Documento de identidad:");
                    String doc = input.nextLine();
                    System.out.println("¿Su cuenta es exenta de GMF? (true/false):");
                    boolean exento = Boolean.parseBoolean(input.nextLine());

                    c = new Cliente(name, city, profe, doc, exento);
                    vinculado = true;
                    System.out.println("Vinculación completada.");
                    break;

                case 2:
                    // Recibir desde PayPal
                    if (!vinculado) {
                        System.out.println("Debe vincular su cuenta primero.");
                        break;
                    }

                    System.out.println("Ingrese cantidad en USD a recibir:");
                    double monto = Double.parseDouble(input.nextLine());

                    double comisionPaypal = monto * 0.05;
                    if(comisionPaypal > maxComision) comisionPaypal = maxComision;

                    double montoFinal = monto - comisionPaypal;
                    double valorCOP = montoFinal * tasaCambio;

                    System.out.println("Monto a recibir en COP: $" + valorCOP);
                    System.out.println("¿Desea aceptar la remesa? (si/no)");
                    String confirm = input.nextLine();

                    if(confirm.equalsIgnoreCase("si")){
                        if (!c.cuentaExenta){
                            double descGMF = valorCOP * gmf;
                            valorCOP -= descGMF;
                            System.out.println("Se aplicoGMF ($" + descGMF + ")");
                        }
                        System.out.println("Remesa recibida con éxito. Total: $" + valorCOP);
                    } else {
                        System.out.println("Remesa rechazada. Informe generado.");
                    }
                    break;

                case 3:
                    // Desde SiPac
                    System.out.println("Ingese cantidad enviada desde oficina SiPac:");
                    double enviado = Double.parseDouble(input.nextLine());

                    double comision = enviado * 0.05;
                    if (comision > maxComision) comision = maxComision;

                    double neto = enviado - comision;
                    double totalRecibido = neto * tasaCambio;

                    System.out.println("Confirmar recepción por $" + totalRecibido + " COP. (aceptar/rechazar)");
                    String resp = input.nextLine();

                    if (resp.equalsIgnoreCase("aceptar")) {
                        if (c == null || !c.cuentaExenta){
                            double gmfDescuento = totalRecibido * gmf;
                            totalRecibido -= gmfDescuento;
                            System.out.println("Se aplicó GMF de:$" + gmfDescuento);
                        }
                        System.out.println("Remesa recibida correctamente:$" + totalRecibido);
                    } else {
                        System.out.println("Transacción anulada.");
                    }
                    break;

                case 4:
                    System.out.println("GMF actual es 0.4% sobre los movimientos.");
                    break;

                case 5:
                    System.out.println("Bye..");
                    break;

                default:
                    System.out.println("Opción invalid");
                    break;
            }
        }

        input.close();
    }
}
