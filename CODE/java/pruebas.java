
import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int costo = b;
        int contSeg = 0;
        int ant = 0;
        int residuo = 0;

        for (int iT = 1; iT <= t; iT++) {
            int ubi = sc.nextInt();
            contSeg++;
            int avanza = ubi - ant;
            int p = avanza + residuo;

            if (p >= m) {
                int division = p / m;
                costo += division;
                ant = ubi;
                contSeg = 0;
            } else if (contSeg >= s) {
                costo += contSeg / s;
                ant = ubi;
                contSeg = 0;
            }

            residuo = ant % 10;
        }

        System.out.println(costo);
    }
}