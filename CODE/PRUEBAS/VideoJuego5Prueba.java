import java.util.*;

public class VideoJuego5Prueba {
    public static void main(String[] args) {
        boolean iter = true;
        while (iter) {
            HashMap<Integer, Soldado> ejercito1 = new HashMap<Integer, Soldado>();
            HashMap<Integer, Soldado> ejercito2 = new HashMap<Integer, Soldado>();
            Soldado[][] tablero = new Soldado[10][10];
            int random1 = (int) (Math.random() * 10 + 1);
            int random2 = (int) (Math.random() * 10 + 1);
            GeneradorDeSoldados(tablero, ejercito1, ejercito2, random1, random2);
            Tablero(tablero);
            VidaMayor(random1, random2, ejercito1, ejercito2);
            Promedio(ejercito1, ejercito2);
            Datos(ejercito1, ejercito2);
            RankingBurbuja(ejercito1, ejercito2);
            RankingInsercion(ejercito1, ejercito2);
            iter = Iterativo(iter);
            Scanner sc = new Scanner(System.in);
            boolean resul = true;
            while (resul) {
                System.out.println("Desea jugar: (y/n)");
                String rpta = sc.next();
                switch (rpta) {
                    case "y":
                        game(ejercito1, ejercito2, tablero);

                        resul = true;
                        break;
                    case "n":
                        iter = false;
                        resul = false;
                        break;

                    default:
                        resul = true;
                }

            }

        }
    }

    public static void GeneradorDeSoldados(Soldado[][] tablero, HashMap<Integer, Soldado> ejercito1,
            HashMap<Integer, Soldado> ejercito2,
            int random1, int random2) {

        for (int i = 0; i < random1; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
            } while (tablero[x][y] != null);

            Soldado nuevoSoldado = new Soldado();
            nuevoSoldado.setNombre("Soldado" + i + "X" + 1);
            nuevoSoldado.setVidaActual((int) (Math.random() * 5 + 1));
            nuevoSoldado.setNivelAtaque((int) (Math.random() * 5 + 1));
            nuevoSoldado.setNivelDefensa((int) (Math.random() * 5 + 1));
            nuevoSoldado.setUbicacion(x + 1, (char) (y + 'a'));

            tablero[x][y] = nuevoSoldado;
            ejercito1.put(i, nuevoSoldado);

        }
        for (int i = 0; i < random2; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
            } while (tablero[x][y] != null);

            Soldado nuevoSoldado = new Soldado();
            nuevoSoldado.setNombre("Soldado" + i + "X" + 2);
            nuevoSoldado.setVidaActual((int) (Math.random() * 5 + 1));
            nuevoSoldado.setNivelAtaque((int) (Math.random() * 5 + 1));
            nuevoSoldado.setNivelDefensa((int) (Math.random() * 5 + 1));
            nuevoSoldado.setUbicacion(x + 1, (char) (y + 'a'));

            tablero[x][y] = nuevoSoldado;
            ejercito2.put(i, nuevoSoldado);

        }
    }

    public static void Tablero(Soldado[][] tablero) {
        System.out.println(
                "___________________________________________________________________________________________________________________________________");
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    "|            |            |            |            |            |            |            |            |            |            |");
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    if (tablero[i][j].getNombre().charAt(9) == '1') {
                        System.out.print("|OOOOOOOOOOOO");
                    } else {
                        System.out.print("|++++++++++++");
                    }
                } else {
                    System.out.print("|            ");
                }
            }
            System.out.print("|\n");
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
                    System.out.print("|    LP: " + tablero[i][j].getVidaActual() + "   ");
                } else {
                    System.out.print("|            ");
                }
            }
            System.out.print("|\n");
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    if (tablero[i][j].getNombre().charAt(9) == '1') {
                        System.out.print("|OOOOOOOOOOOO");
                    } else {
                        System.out.print("|++++++++++++");
                    }
                } else {
                    System.out.print("|            ");
                }
            }
            System.out.print("|\n");
            System.out.println(
                    "|____________|____________|____________|____________|____________|____________|____________|____________|____________|____________|");
        }
    }

    public static void VidaMayor(int random1, int random2, HashMap<Integer, Soldado> ejercito1,
            HashMap<Integer, Soldado> ejercito2) {
        int max1 = 0;
        Soldado soldadoMayor1 = null;
        for (int i = 0; i < ejercito1.size(); i++) {
            if (ejercito1.get(i).getVidaActual() > max1) {
                max1 = ejercito1.get(i).getVidaActual();
                soldadoMayor1 = ejercito1.get(i);
            }

        }
        int max2 = 0;
        Soldado soldadoMayor2 = null;
        for (int i = 0; i < ejercito2.size(); i++) {
            if (ejercito2.get(i).getVidaActual() > max2) {
                max2 = ejercito2.get(i).getVidaActual();
                soldadoMayor2 = ejercito2.get(i);
            }

        }
        System.out.println("-Soldado con mayor vida es : \n Nombre: " + soldadoMayor1.getNombre() + "\n Vida: "
                + soldadoMayor1.getVidaActual() + "\n Nivel de Ataque: " + soldadoMayor1.getNivelAtaque()
                + "\n Nivel de Defensa: " + soldadoMayor1.getNivelDefensa() + "\n Ubicacion: "
                + soldadoMayor1.getUbicacion() + "\n");
        System.out.println("-Soldado con mayor vida es : \n Nombre: " + soldadoMayor2.getNombre() + "\n Vida: "
                + soldadoMayor2.getVidaActual() + "\n Nivel de Ataque: " + soldadoMayor2.getNivelAtaque()
                + "\n Nivel de Defensa: " + soldadoMayor2.getNivelDefensa() + "\n Ubicacion: "
                + soldadoMayor2.getUbicacion() + "\n");
    }

    public static void Promedio(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        double promedio1 = 0;
        for (int i = 0; i < ejercito1.size(); i++) {
            promedio1 = ejercito1.get(i).getVidaActual() + promedio1;
        }
        System.out.println("-Promedio de puntos de vida del ejercito 1 : " + (promedio1 / ejercito1.size()) + "\n");
        double promedio2 = 0;
        for (int i = 0; i < ejercito2.size(); i++) {
            promedio2 = ejercito2.get(i).getVidaActual() + promedio2;
        }
        System.out.println("-Promedio de puntos de vida del ejercito 2: " + (promedio2 / ejercito2.size()) + "\n");
    }

    public static void Datos(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        System.out.println("-Datos de los soldados del ejercito 1:");
        for (int i = 0; i < ejercito1.size(); i++) {
            System.out.println(" Nombre: " + ejercito1.get(i).getNombre() + "\n Vida: "
                    + ejercito1.get(i).getVidaActual() + "\n Ubicacion: "
                    + ejercito1.get(i).getUbicacion() + "\n Nivel de ataque: "
                    + ejercito1.get(i).getNivelAtaque() + "\n NIvel de defensa: "
                    + ejercito1.get(i).getNivelDefensa());
        }
        System.out.println("-Datos de los soldados del ejercito 2:");
        for (int i = 0; i < ejercito2.size(); i++) {
            System.out.println(" Nombre: " + ejercito2.get(i).getNombre() + "\n Vida: "
                    + ejercito2.get(i).getVidaActual() + "\n Ubicacion: "
                    + ejercito2.get(i).getUbicacion() + "\n Nivel de ataque: "
                    + ejercito2.get(i).getNivelAtaque() + "\n NIvel de defensa: "
                    + ejercito2.get(i).getNivelDefensa());
        }
    }

    public static void RankingBurbuja(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        HashMap<Integer, Soldado> ejercito01 = new HashMap<>(ejercito1);
        int n = ejercito01.size();
        boolean cambio1;
        do {
            cambio1 = false;
            for (int i = 1; i < n; i++) {
                if (ejercito01.get(i - 1).getVidaActual() < ejercito01.get(i).getVidaActual()) {
                    Soldado temp = ejercito01.get(i - 1);
                    ejercito01.replace(i - 1, ejercito01.get(i));
                    ejercito01.replace(i, temp);
                    cambio1 = true;
                }
            }
        } while (cambio1);
        HashMap<Integer, Soldado> ejercito02 = new HashMap<>(ejercito2);
        int m = ejercito02.size();
        boolean cambio2;
        do {
            cambio2 = false;
            for (int i = 1; i < m; i++) {
                if (ejercito02.get(i - 1).getVidaActual() < ejercito02.get(i).getVidaActual()) {
                    Soldado temp = ejercito02.get(i - 1);
                    ejercito02.replace(i - 1, ejercito02.get(i));
                    ejercito02.replace(i, temp);
                    cambio2 = true;
                }
            }
        } while (cambio2);
        System.out.println("\n-Rankings: Burbuja");
        for (int i = 0; i < ejercito01.size(); i++) {
            System.out.println(ejercito01.get(i).getNombre());
        }
        System.out.println("------------------------------------------------");
        for (int i = 0; i < ejercito02.size(); i++) {
            System.out.println(ejercito02.get(i).getNombre());
        }
    }

    public static void RankingInsercion(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2) {
        HashMap<Integer, Soldado> ejercito01 = new HashMap<>(ejercito1);
        for (int i = 0; i < ejercito01.size(); i++) {
            for (int j = 0; j < ejercito01.size() - 1; j++) {
                if (ejercito01.get(j).getVidaActual() < ejercito01.get(j + 1).getVidaActual()) {
                    Soldado temp = ejercito01.get(j);
                    ejercito01.replace(j, ejercito01.get(j + 1));
                    ejercito01.replace(j + 1, temp);
                }
            }
        }
        HashMap<Integer, Soldado> ejercito02 = new HashMap<>(ejercito2);
        for (int i = 0; i < ejercito02.size(); i++) {
            for (int j = 0; j < ejercito02.size() - 1; j++) {
                if (ejercito02.get(j).getVidaActual() < ejercito02.get(j + 1).getVidaActual()) {
                    Soldado temp = ejercito02.get(j);
                    ejercito02.replace(j, ejercito02.get(j + 1));
                    ejercito02.replace(j + 1, temp);
                }
            }
        }
        System.out.println("\n-Rankings: Insercion");
        for (int i = 0; i < ejercito01.size(); i++) {
            System.out.println(ejercito01.get(i).getNombre());
        }
        System.out.println("------------------------------------------------");
        for (int i = 0; i < ejercito02.size(); i++) {
            System.out.println(ejercito02.get(i).getNombre());
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

    public static void game(HashMap<Integer, Soldado> ejercito1, HashMap<Integer, Soldado> ejercito2,
            Soldado[][] Tablero) {
        Scanner sc = new Scanner(System.in);
        boolean iter = true;
        if (iter) {
            System.out.println("****JUGAR****");
            // --------------------------------------------------------------------------------------------------------------------------------
            boolean again = true;
            for (int i = 0; again; i++) {
                boolean turn = (i % 2 == 0); // Simplificado
                if (turn) {
                    System.out.println("Turno del Ejército 01");
                } else {
                    System.out.println("Turno del Ejército 02");
                }
                System.out.println("Elija el soldado:");
                int sold = sc.nextInt();
                boolean moveValid = true;
                // --------------------------------------------------------------------------------------------------------------------------------
                while (moveValid) {
                    System.out.println("Elija qué dirección moverse:\n UP = ^    DOWN = v\n LEFT = <    RIGHT = >");
                    String movimiento = sc.next();
                    moveValid = move(movimiento, sold, Tablero, ejercito1, ejercito2, turn);
                }
                Tablero(Tablero);
                // --------------------------------------------------------------------------------------------------------------------------------
                if (ejercito1.size() == 0 || ejercito2.size() == 0) {
                    if (ejercito1.size() != 0) {
                        System.out.println("-----El ejército 01 es el ganador-----");
                    } else {
                        System.out.println("-----El ejército 02 es el ganador-----");
                    }
                    again = false;
                } else {
                    // --------------------------------------------------------------------------------------------------------------------------------
                    System.out.println("Desea seguir jugando: (y/n)");
                    String play = sc.next();
                    if (play.equals("n")) {
                        again = false;
                        iter = false;
                    }
                }
                // --------------------------------------------------------------------------------------------------------------------------------
            }
        }
    }

    public static boolean move(String movimiento, int sold, Soldado[][] Tablero, HashMap<Integer, Soldado> ejercito1,
            HashMap<Integer, Soldado> ejercito2, boolean turn) {
        HashMap<Integer, Soldado> army = new HashMap<Integer, Soldado>();
        if (turn) {
            army = ejercito1;
        } else {
            army = ejercito2;
        }
        int ubiX = army.get(sold).getUbicacionX() - 1;
        int ubiY = army.get(sold).getUbicacionY() - 'a';
        System.out.println(army.get(sold).getNombre() + "," + sold);

        switch (movimiento) {
            case "UP":
                ubiX -= 1;
                break;
            case "DOWN":
                ubiX += 1;
                break;
            case "LEFT":
                ubiY -= 1;
                break;
            case "RIGHT":
                ubiY += 1;
                break;
            default:
                System.out.println("---Opción no válida, inténtelo de nuevo.---");
                return true;
        }

        if (ubiX >= 0 && ubiX < Tablero.length && ubiY >= 0 && ubiY < Tablero[0].length) {
            if (Tablero[ubiX][ubiY] != null) {
                char oneORtwo;
                if (turn) {
                    oneORtwo = '1';
                } else {
                    oneORtwo = '2';
                }

                if (Tablero[ubiX][ubiY].getNombre().charAt(9) == (oneORtwo)) {
                    System.out.println(
                            "----Esta coordenada esta ocupada por tu mismo ejercito, elija otra direccion----");
                    return true;
                } else {
                    HashMap<Integer, Soldado> army2 = new HashMap<Integer, Soldado>();
                    if (oneORtwo == '1') {
                        army2 = ejercito2;
                    } else {
                        army2 = ejercito1;
                    }
                    if (army.get(sold).getVidaActual() == Tablero[ubiX][ubiY].getVidaActual()) {

                        army.put(sold, null);
                        Tablero[ubiX][ubiY] = null;
                        army2.put(sold, null);
                    } else {
                        if (army.get(sold).getVidaActual() > Tablero[ubiX][ubiY].getVidaActual()) {

                            army.get(sold).setUbicacion(ubiX, (char) (ubiY + 'a'));
                            Tablero[army.get(sold).getUbicacionX()][army.get(sold).getUbicacionY() - 97] = null;

                        } else {
                            army.put(sold, null);
                        }
                    }

                    return false;
                }
            } else {
                Tablero[ubiX][ubiY] = army.get(sold);
                System.out.println(army.get(sold).getUbicacionX() + "," + (army.get(sold).getUbicacionY() - 97));
                Tablero[army.get(sold).getUbicacionX() - 1][army.get(sold).getUbicacionY() - 'a'] = null;

                army.get(sold).setUbicacion(ubiX, (char) (ubiY + 'a'));

                return false;

            }
        } else {
            System.out.println("Invalid move. Please try again.");
            return true;
        }
    }
}
