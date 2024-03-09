import java.util.*;

public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] twister = new int[n][n];
		twister[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				twister[i][j] = sc.nextInt();
			}
		}

		int cont = 0;
		int i = 0;
		int j = 0;
		for (int p = 1; p < n * n; p++) {
			int x = searchI(twister, i, j, n);
			int y = searchJ(twister, i, j, n);
			int contx = Math.abs(i - x);
			int conty = Math.abs(j - y);
			cont = cont + contx + conty;
			i = x;
			j = y;
		}
		System.out.println(cont);
	}

	public static int searchI(int[][] twister, int i, int j, int n) {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (twister[x][y] == twister[i][j] + 1) {
					return x;
				}
			}
		}
		return n;
	}

	public static int searchJ(int[][] twister, int i, int j, int n) {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (twister[x][y] == twister[i][j] + 1) {
					return y;
				}
			}
		}
		return n;
	}
}
