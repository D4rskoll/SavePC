
import java.util.*;

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[3];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves).getNombre());
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        System.out.println("|| NAVES  ||  NOMBRE  ||  FILA    ||   COLUMNA   ||   PUNTOS  ||     ESTADO   ");
        for (int i = 0; i < flota.length; i++) {
            System.out.println("|| Nave " + (i + 1) + " ||    " + flota[i].getNombre() + "     ||     "
                    + flota[i].getFila() + "    ||     "
                    + flota[i].getColumna() + "       ||   " + flota[i].getPuntos() + "       ||     "
                    + flota[i].getEstado());
        }
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Las naves con nombre: ");
        String name = sc.nextLine();
        for (int i = 0; i < flota.length; i++) {
            if (name.equals(flota[i].getNombre())) {
                System.out.println("Nave " + i);
            }
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
            System.out.println("Nave " + (i + 1) + ": " + flota[i].getPuntos());
        }
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        int max = 0;
        Nave NaveMayor = null;
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getPuntos() > max) {
                max = flota[i].getPuntos();
                NaveMayor = flota[i];
            }

        }
        return NaveMayor;
    }
    // Crear un método que devuelva un nuevo arreglo de objetos con todos los
    // objetos previamente ingresados
    // pero aleatoriamente desordenados
}