import java.util.*;

public class ejercicio4 {
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
	}

	public static int search(int[][] twister, int n) {
		int cont = 0;
		int ubi = 0;
		boolean conTF;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				conTF = false;
				for (int h = i; (h < n) && (conTF); h++) {
					for (int k = j; (k < n) && (conTF); k++) {
						if (twister[i][j] + 1 == twister[h][k]) {
							cont++;
							conTF = true;
						}
						ubi = twister[h][k];
					}

				}

			}
		}
		System.out.println(cont);
		return ubi;
	}
}
