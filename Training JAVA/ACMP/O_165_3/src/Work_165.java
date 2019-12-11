import java.util.ArrayList;

public class Work_165 {

	public static int[][] Find_MatricaSmegnosti(int[][] matricaSmegnosti,
			ArrayList<Integer> list, int[][] numberOfSteps, int[][] coordinat) {
		int step = 1;
		numberOfSteps[0][0] = 1;
		while (true) {
			step++;
			if (list.size() == 0)
				break;
			int n = list.size();
			for (int i = 0; i < n; i++) {
				TakeOnePoint(matricaSmegnosti, list, numberOfSteps, coordinat,
						step);
				list.remove(0);
		//		prin_165.prinUsulyMassiv(numberOfSteps);
		
			
			
			}
		}

		return matricaSmegnosti;
	}

	private static void TakeOnePoint(int[][] matricaSmegnosti,
			ArrayList<Integer> list, int[][] numberOfSteps, int[][] coordinat,
			int step) {
		int c = list.get(0);
		int yLen = coordinat.length;
		int xLen = coordinat[0].length;
		int yOld = c / xLen;
		int xOld = c - yOld * xLen;

		int jamp = coordinat[yOld][xOld];
		int yy[] = { 0, jamp };
		int xx[] = { jamp, 0 };

		for (int i = 0; i < 2; i++) {
			int x = xOld + xx[i];
			int y = yOld + yy[i];
			if (x > xLen - 1 | y > yLen - 1 )
				continue;
			if(coordinat[y][x]==0)
				continue;
			int newPoint = y * xLen + x;
			if (numberOfSteps[y][x] == 0) {
				numberOfSteps[y][x] = step;
				list.add(newPoint);
			}
			int inside = matricaSmegnosti[c][0];
			matricaSmegnosti[c][inside + 1] = newPoint;
			matricaSmegnosti[c][0]++;
		}

	}

}
