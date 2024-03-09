import java.util.*;

public class VideoJuego4 {
    public static void main(String[] args) {
        boolean iter = true;
        while (iter) {
            Soldado[] ejercito1 = new Soldado[(int) (Math.random() * 10 + 1)];
            Soldado[] ejercito2 = new Soldado[(int) (Math.random() * 10 + 1)];
            Soldado[][] tablero = new Soldado[10][10];
            for (int i = 0; i < ejercito1.length; i++) {
                ejercito1[i] = new Soldado();
            }
            for (int i = 0; i < ejercito2.length; i++) {
                ejercito2[i] = new Soldado();
            }

            Nombre(ejercito1, ejercito2);
            Vida(ejercito1, ejercito2);
            Posicion(tablero, ejercito1, ejercito2);
            Tablero(tablero, ejercito1);
            VidaMayor(ejercito1, ejercito2);
            Promedio(ejercito1, ejercito2);
            VidaTotal(ejercito1, ejercito2);
            Datos(ejercito1, ejercito2);
            RankingBurbuja(ejercito1, ejercito2);
            RankingInsercion(ejercito1, ejercito2);
            Winner(ejercito1, ejercito2);
            iter = Iterativo(iter);

        }
    }

    public static void Nombre(Soldado[] ejercito1, Soldado[] ejercito2) {
        String name;

        for (int i = 0; i < ejercito1.length; i++) {
            name = "Soldado" + i + "X" + 1;
            ejercito1[i].setNombre(name);
        }
        for (int i = 0; i < ejercito2.length; i++) {
            name = "Soldado" + i + "X" + 2;
            ejercito2[i].setNombre(name);
        }

    }

    public static void Vida(Soldado[] ejercito1, Soldado[] ejercito2) {

        for (int i = 0; i < ejercito1.length; i++) {
            int random = (int) (Math.random() * 5 + 1);
            ejercito1[i].setVida(random);
        }

        for (int i = 0; i < ejercito2.length; i++) {
            int random = (int) (Math.random() * 5 + 1);
            ejercito2[i].setVida(random);
        }
    }

    public static void Posicion(Soldado[][] tablero, Soldado[] ejercito1, Soldado[] ejercito2) {

        for (int o = 0; o < ejercito1.length; o++) {
            int i = (int) (Math.random() * 10);
            int j = (int) (Math.random() * 10);
            if (tablero[i][j] == null) {
                tablero[i][j] = ejercito1[o]; // no es null
                ejercito1[o].setUbicacion(i + 1, (char) ('a' + j));
            } else {
                o--;
            }
        }
        for (int o = 0; o < ejercito2.length; o++) {
            int i = (int) (Math.random() * 10);
            int j = (int) (Math.random() * 10);
            if (tablero[i][j] == null) {
                tablero[i][j] = ejercito2[o]; // no es null
                ejercito2[o].setUbicacion(i + 1, (char) ('a' + j));
            } else {
                o--;
            }
        }
    }

    public static void Tablero(Soldado[][] tablero, Soldado[] ejercito1) {
        System.out.println(
                "___________________________________________________________________________________________________________________________________");
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    "|            |            |            |            |            |            |            |            |            |            |");
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("| " + tablero[i][j].getNombre() + " ");
                } else {
                    System.out.print("|            ");
                }
            }
            System.out.println("|");
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("|    LP: " + tablero[i][j].getVida() + "   ");
                } else {
                    System.out.print("|            ");
                }
            }
            System.out.print("|\n");
            System.out.println(
                    "|____________|____________|____________|____________|____________|____________|____________|____________|____________|____________|");
        }
    }

    public static void VidaMayor(Soldado[] ejercito1, Soldado[] ejercito2) {
        int max1 = 0;
        Soldado soldadoMayor1 = null;
        for (int i = 0; i < ejercito1.length; i++) {
            if (ejercito1[i].getVida() > max1) {
                max1 = ejercito1[i].getVida();
                soldadoMayor1 = ejercito1[i];
            }

        }
        int max2 = 0;
        Soldado soldadoMayor2 = null;
        for (int i = 0; i < ejercito2.length; i++) {
            if (ejercito2[i].getVida() > max2) {
                max2 = ejercito2[i].getVida();
                soldadoMayor2 = ejercito2[i];
            }

        }
        System.out.println("-Soldado con mayor vida es : \n Nombre: " + soldadoMayor1.getNombre() + "\n Vida: "
                + soldadoMayor1.getVida() + "\n Ubicacion: "
                + soldadoMayor1.getUbicacion() + "\n");
        System.out.println("-Soldado con mayor vida es : \n Nombre: " + soldadoMayor2.getNombre() + "\n Vida: "
                + soldadoMayor2.getVida() + "\n Ubicacion: "
                + soldadoMayor2.getUbicacion() + "\n");
    }

    public static void Promedio(Soldado[] ejercito1, Soldado[] ejercito2) {
        double promedio1 = 0;
        for (int i = 0; i < ejercito1.length; i++) {
            promedio1 = ejercito1[i].getVida() + promedio1;
        }
        System.out.println("-Promedio de puntos de vida del ejercito 1 : " + (promedio1 / ejercito1.length) + "\n");
        double promedio2 = 0;
        for (int i = 0; i < ejercito2.length; i++) {
            promedio2 = ejercito2[i].getVida() + promedio2;
        }
        System.out.println("-Promedio de puntos de vida del ejercito 2: " + (promedio2 / ejercito2.length) + "\n");
    }

    public static void VidaTotal(Soldado[] ejercito1, Soldado[] ejercito2) {
        System.out.println("-Puntos de vida : ");
        for (int i = 0; i < ejercito1.length; i++) {
            System.out.println("Vida del Soldado" + i + ": " + ejercito1[i].getVida());
        }
        int vidaTotal1 = 0;
        for (int i = 0; i < ejercito1.length; i++) {
            vidaTotal1 = ejercito1[i].getVida() + vidaTotal1;
        }
        System.out.println("Los puntos de vida total del ejercito 1 es: " + vidaTotal1 + "\n");

        for (int i = 0; i < ejercito2.length; i++) {
            System.out.println("Vida del Soldado" + i + ": " + ejercito2[i].getVida());
        }
        int vidaTotal2 = 0;
        for (int i = 0; i < ejercito2.length; i++) {
            vidaTotal2 = ejercito2[i].getVida() + vidaTotal2;
        }
        System.out.println("Los puntos de vida total del ejercito 2 es: " + vidaTotal2 + "\n");
    }

    public static void Datos(Soldado[] ejercito1, Soldado[] ejercito2) {
        System.out.println("-Datos de los soldados del ejercito 1:");
        for (int i = 0; i < ejercito1.length; i++) {
            System.out.println(" Nombre: " + ejercito1[i].getNombre() + "\n Vida: "
                    + ejercito1[i].getVida() + "\n Ubicacion: "
                    + ejercito1[i].getUbicacion());
        }
        System.out.println("-Datos de los soldados del ejercito 2:");
        for (int i = 0; i < ejercito2.length; i++) {
            System.out.println(" Nombre: " + ejercito2[i].getNombre() + "\n Vida: "
                    + ejercito2[i].getVida() + "\n Ubicacion: "
                    + ejercito2[i].getUbicacion());
        }
    }

    public static void RankingBurbuja(Soldado[] ejercito1, Soldado[] ejercito2) {
        Soldado[] ejercito01 = ejercito1;
        int n = ejercito01.length;
        boolean cambio1;
        do {
            cambio1 = false;
            for (int i = 1; i < n; i++) {
                if (ejercito01[i - 1].getVida() < ejercito01[i].getVida()) {
                    Soldado temp = ejercito01[i - 1];
                    ejercito01[i - 1] = ejercito01[i];
                    ejercito01[i] = temp;
                    cambio1 = true;
                }
            }
        } while (cambio1);
        Soldado[] ejercito02 = ejercito2;
        int m = ejercito02.length;
        boolean cambio2;
        do {
            cambio2 = false;
            for (int i = 1; i < m; i++) {
                if (ejercito02[i - 1].getVida() < ejercito02[i].getVida()) {
                    Soldado temp = ejercito02[i - 1];
                    ejercito02[i - 1] = ejercito02[i];
                    ejercito02[i] = temp;
                    cambio2 = true;
                }
            }
        } while (cambio2);
        System.out.println("\n-Rankings: Burbuja");
        for (int i = 0; i < ejercito01.length; i++) {
            System.out.println(ejercito01[i].getNombre());
        }
        System.out.println("------------------------------------------------");
        for (int i = 0; i < ejercito02.length; i++) {
            System.out.println(ejercito02[i].getNombre());
        }
    }

    public static void RankingInsercion(Soldado[] ejercito1, Soldado[] ejercito2) {
        Soldado[] ejercito01 = ejercito1;
        for (int i = 0; i < ejercito01.length; i++) {
            for (int j = 0; j < ejercito01.length - 1; j++) {
                if (ejercito01[j].getVida() < ejercito01[j + 1].getVida()) {
                    Soldado temp;
                    temp = ejercito01[j];
                    ejercito01[j] = ejercito01[j + 1];
                    ejercito01[j + 1] = temp;
                }
            }
        }
        Soldado[] ejercito02 = ejercito2;
        for (int i = 0; i < ejercito02.length; i++) {
            for (int j = 0; j < ejercito02.length - 1; j++) {
                if (ejercito02[j].getVida() < ejercito02[j + 1].getVida()) {
                    Soldado temp;
                    temp = ejercito02[j];
                    ejercito02[j] = ejercito2[j + 1];
                    ejercito02[j + 1] = temp;
                }
            }
        }
        System.out.println("\n-Rankings: Insercion");
        for (int i = 0; i < ejercito01.length; i++) {
            System.out.println(ejercito01[i].getNombre());
        }
        System.out.println("------------------------------------------------");
        for (int i = 0; i < ejercito02.length; i++) {
            System.out.println(ejercito02[i].getNombre());
        }
    }

    public static void Winner(Soldado[] ejercito1, Soldado[] ejercito2) {
        int vidaTotal1 = 0;
        for (int i = 0; i < ejercito1.length; i++) {
            vidaTotal1 = ejercito1[i].getVida() + vidaTotal1;
        }
        int vidaTotal2 = 0;
        for (int i = 0; i < ejercito2.length; i++) {
            vidaTotal2 = ejercito2[i].getVida() + vidaTotal2;
        }

        if (vidaTotal1 != vidaTotal2) {
            if (vidaTotal1 > vidaTotal2) {
                System.out.print("\n-El Ejercito 1 es el ganador, con un total de vida de: " + vidaTotal1);
            } else {
                System.out.print("\n-El Ejercito 2 es el ganador, con un total de vida de: " + vidaTotal2);
            }
        } else {
            System.out.print("\n-Es un empate, con un total de vida en ambos de: " + vidaTotal1);
        }
    }

    public static boolean Iterativo(boolean iter) {
        Scanner sc = new Scanner(System.in);
        boolean resul = true;
        while (resul) {
            System.out.println("\n-Desea volver a empezar: y/n ");
            String rpta = sc.next();
            switch (rpta) {
                case "y":
                    iter = true;
                    resul = false;
                    break;
                case "n":
                    iter = false;
                    resul = false;
                    break;

                default:
                    resul = true;
            }
        }
        return iter;
    }
}
