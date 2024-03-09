import java.util.Scanner;

public class ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int t = sc.nextInt();
		int u = sc.nextInt();
		int f = sc.nextInt();
		int d = sc.nextInt();
		int uni = 0;
		int sumaT = 0;

		for (int i = 0; i < t; i++) {
			String seg = sc.next();
			seg = seg.toUpperCase();
			int segT = ufd(seg, u, f, d);
			if (sumaT + segT <= m) {
				sumaT = sumaT + segT;
				uni++;
			}
		}
		System.out.println(uni + " " + sumaT);
	}

	public static int ufd(String seg, int u, int f, int d) {
		int segN = 0;
		if (seg.equals("U")) {
			segN = u + d;
		}
		if (seg.equals("F")) {
			segN = f + f;
		}
		if (seg.equals("D")) {
			segN = d + u;
		}
		return segN;
	}
}