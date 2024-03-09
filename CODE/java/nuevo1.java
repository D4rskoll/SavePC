
import java.util.*;

public class nuevo1 {
	public static void main(String[] args) {
		int[][] matriz = new int[2][2];
		matriz[0][0] = 1;
	}

	public static int[][] leerMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.println(matriz[i][j]);
			}
		}
		return matriz;
	}
}