import java.util.Scanner;

public class Gorka {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int k = sc.nextInt();
		int[][] Smeg = new int[n][n];
		int[] CountUsually = new int[n];
		int[] CountGorki = new int[n];
		for (int i = 0; i < m; i++) { // обычные ребра
			int y = sc.nextInt();
			int x = sc.nextInt();
			Smeg[y - 1][x - 1] = 1;
			CountUsually[y - 1] += 1;
		}
		for (int i = 0; i < l; i++) { // ребра горки
			int y = sc.nextInt();
			int x = sc.nextInt();
			Smeg[y - 1][x - 1] = 5;
			CountGorki[y - 1] += 1;
		}
		int[] Cast = new int[k];
		for (int i = 0; i < k; i++) { // ребра горки
			Cast[i] = sc.nextInt();

		}

		Print nn = new Print();
		// nn.PrintMassiv2(Smeg);

		System.out.println();
		nn.PrintMassiv3(Smeg, CountUsually, CountGorki);

		System.out.println();
		nn.PrintMassiv1(Cast);
		int[] queue = new int[n * n];
		boolean[] Otvet = new boolean[1];
		// Otvet[0]=false;
		int q0 = 0;
		int qNextEmpty = 1;
		queue[0] = 0;
		int[] qq = new int[2];
		int Kol_voBroskov = 0;
		for (int i = 0; i < Cast.length; i++) { // кол -во бросков,
												// рассматриваем i-ый бросок

			queue = StepInside(queue, q0, qNextEmpty, CountUsually, Smeg, Cast,
					i, Otvet, qq, CountGorki);
			q0 = qq[0];
			qNextEmpty = qq[1];
			queue = walkInGorka(queue, qNextEmpty, CountGorki, Smeg, Otvet, n);
			if (Otvet[0]) {
				Kol_voBroskov = i;
				i = Cast.length;

			}
		}

		System.out.println(Otvet[0]);
		System.out.println(Kol_voBroskov + 1);

	}

	private static int[] walkInGorka(int[] queue, int qNextEmpty,
			int[] countGorki, int[][] smeg, boolean[] otvet, int n) {

		for (int i = 0; i < qNextEmpty; i++) {
			if (queue[i] == n - 1) {
				otvet[0] = true;
				i = qNextEmpty;
				continue;
			}
			if (countGorki[queue[i]] == 1) {

				int e = change(smeg, queue[i]);
				queue[i] = e;

			}
		}

		return queue;
	}

	private static int change(int[][] smeg, int i) {
		for (int i1 = 0; i1 < smeg.length; i1++) {
			if (smeg[i][i1] == 5) {
				int y = i1;
				return i1;
			}

		}
		return smeg[0][i];
	}

	private static int[] StepInside(int[] queue, int q0, int qNextEmpty,
			int[] CountUsually, int[][] Smeg, int[] Cast, int i,
			boolean[] Otvet, int[] qq, int[] countGorki) {

		int Q0_start = q0;
		for (int j = 0; j < Cast[i]; j++) { // каждый шаг броска рассматриваем
											// отдельно
			int t = qNextEmpty;
			qNextEmpty = insideAllVershini(queue, q0, qNextEmpty, CountUsually,
					Smeg, j, Cast, Otvet, countGorki);
			if (qNextEmpty != t) {
				q0 = t;
			}

		}
		qq[0] = q0;
		qq[1] = qNextEmpty;
		int Line = qNextEmpty - q0;
		queue = MinusOtrabotka(queue, q0, qNextEmpty);
		qq[0] = 0;
		qq[1] = Line;
		return queue;
	}

	private static int insideAllVershini(int[] queue, int q0, int qNextEmpty,
			int[] countUsually, int[][] smeg, int j, int[] cast,
			boolean[] Otvet, int[] countGorki) {
		int y = qNextEmpty;
		int qoVremen = q0;
		for (int s = qoVremen; s < y; s++) { // пропишем в
												// очередь все
			boolean h = false; // вершины
			for (int i = 0; i < smeg[0].length; i++) {
				if (smeg[queue[s]][i] == 1) {
					queue[qNextEmpty] = i;
					qNextEmpty += 1;
					h = true;
				}
			}
			if (!h) {
				if (countUsually[queue[s]] == 5 | countGorki[queue[s]] == 1) {
					queue[qNextEmpty] = queue[s];
					qNextEmpty += 1;
				}
			}

			qoVremen += 1;
		}

		return qNextEmpty;
	}

	private static int[] minusS(int[] queue, int s, int qNextEmpty) {
	for (int i=s; i<qNextEmpty-1;i++){
		queue[i]=queue[i+1];
	}
		return queue;
	}

	private static int[] MinusOtrabotka(int[] queue, int q0_start,
			int qNextEmpty) {
		int[] qqq = new int[queue.length];
		for (int i = q0_start; i < qNextEmpty; i++) {
			qqq[i - q0_start] = queue[i];
		}

		return qqq;
	}

}
