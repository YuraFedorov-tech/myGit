package e054_2;



import java.util.Arrays;

public class DO {
	int[] num;
	private int[] mean;
	int n;

	public DO(int[] num, int[] mean) {
		this.num = num.clone();
		this.mean = mean.clone();
	}

	public void change() {
		order(0);
		if (RoyalFlesh())
			return;
		if (Strit9())
			return;
		if (Kare8())
			return;
		if (Kare8())
			return;
		if (Fullxaus7())
			return;
		if (Flesh6())
			return;
		if (Strate5())
			return;
		if (tree3())
			return;
		if (twoPara2())
			return;
		if (OnePara1())
			return;
		n = 0;
	}

	private boolean OnePara1() {
		int q = Have();
		if (q < 0)
			return false;
		int v = num[0];
		int b = num[1];
		num[0] = num[q];
		num[1] = num[q + 1];
		if(q!=1) {
		num[q] = v;
		num[q + 1] = b;
		order( 2);
		}else num[q + 1]=v;
		n = 1;
		return true;

	}



	private int Have() {
		for (int i = 0; i < 4; i++)
			if (num[i] == num[i + 1])
				return i;
		return -1;
	}

	private boolean twoPara2() {
		int covp = 0;
		if (num[0] == num[1] & num[2] == num[3]) {
			n = 2;
			return true;
		}
		if (num[0] == num[1] & num[3] == num[4]) {
			int q = num[2];
			num[2] = num[4];
			num[4] = q;
			n = 2;
			return true;
		}
		if (num[1] == num[2] & num[3] == num[4]) {
			int q = num[0];
			num[0] = num[2];
			num[2] = num[4];
			num[4] = q;
			n = 2;
			return true;
		}
		return false;
	}

	private boolean tree3() {
		if (num[0] == num[2] | num[2] == num[4]) {
			if (num[2] == num[4])
				CHAnge3();
			n = 3;
			return true;
		}
		return false;
	}

	private boolean Strate5() {
		if (!Poryadok(num[0]))
			return false;
		n = 5;
		return true;
	}

	private boolean Flesh6() {
		if (!OneMast(0, 5, mean))
			return false;
		n = 6;
		return true;
	}

	private boolean Fullxaus7() {
		if (num[0] == num[1] & num[0] == num[2] & num[3] == num[4]) {
			n = 7;
			return true;
		}
		if (num[0] == num[1] & num[2] == num[3] & num[3] == num[4]) {
			CHAnge3();

			n = 7;
			return true;
		}
		return false;
	}

	private void CHAnge3() {
		int q = num[0];
		int w = num[1];
		num[0] = num[1] = num[2];
		num[3] = q;
		num[4] = w;

	}

	private boolean Kare8() {
		if (!OneMast(0, 4, num))
			if (!OneMast(1, 5, num))
				return false;
		if (OneMast(1, 5, num)) {
			int q = num[0];
			num[0] = num[4];
			num[4] = q;
		}
		n = 8;
		return true;
	}

	private boolean Strit9() {
		if (!OneMast(0, 5, mean))
			return false;
		if (!Poryadok(num[0]))
			return false;
		n = 9;
		return true;
	}

	private boolean RoyalFlesh() {
		if (!OneMast(0, 5, mean))
			return false;
		if (!Poryadok(14))
			return false;
		n = 10;
		return true;
	}

	private boolean Poryadok(int j) {

		for (int i = 0; i < 5; i++)
			if (num[i] != j--)
				return false;
		return true;
	}

	private boolean OneMast(int b, int e, int[] mean2) {
		for (int i = b; i < e - 1; i++)
			if (mean2[i] != mean2[i + 1])
				return false;
		return true;
	}

	private void order(int k) {
		for (int i = k; i < 5; i++)
			for (int j = i + 1; j < 5; j++) {
				if (num[j] > num[i]) {
					iInJ(i, j, num);
					iInJ(i, j, mean);
				}
			}

	}

	private void iInJ(int i, int j, int[] num2) {
		int q = num2[i];
		num2[i] = num2[j];
		num2[j] = q;

	}

	public boolean compear(DO e) {
		if (this.n > e.n)
			return true;
		if (this.n < e.n)
			return false;
		for(int i=0;i<5;i++) {
			if(this.num[i]>e.num[i])
				return true;
			if(this.num[i]<e.num[i])
				return false;
		}
		System.out.print(5/0);
		return false;
	}

}
