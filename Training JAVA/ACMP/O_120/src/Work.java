import java.util.ArrayList;

public class Work {
	static int[][] FindSumma(int[][] costStep, int[][] price,
			ArrayList<Integer> list) {
		while (list.size() != 0) {

			int maxList = list.size();
			list = doWork(list, maxList, costStep, price);

		}

		return price;
	}

	private static ArrayList<Integer> doWork(ArrayList<Integer> list,
			int maxList, int[][] costStep, int[][] price) {

		for (int i = 0; i < maxList; i++) {
			int yx[] = new int[2];
			int y = costStep.length;
			int x = costStep[0].length;
			yx = Helping.FindXY_fromI(list.get(0), y, x, yx);
			for (int j = 0; j < 2; j++) {
				int xx = 0, yy = 0;
				if (j == 0) { // вправо
					xx = yx[1] + 1;
					yy = yx[0];
				}
				if (j == 1) { // вниз
					xx = yx[1];
					yy = yx[0] + 1;
				}
				boolean chek = Helping.YX(yx, costStep); // chek=true, если мы в
															// поле действия
				if (chek) {
					price = Helping.ChangePrice(price, yx[0], yx[1], costStep,
							yy, xx);
					int newNumberListing = Helping.FindI_fromXY(x, yy, xx);
					boolean cheksN=Helping.chek_newNumberListing(newNumberListing,list);
					if(cheksN)
					list.add(newNumberListing);
				}

			}
list.remove(0);
		}

		return list;
	}

}
