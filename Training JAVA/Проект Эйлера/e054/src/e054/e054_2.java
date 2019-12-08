package e054;


import java.util.Arrays;

public class e054_2 {
	int[] num;
	private int[] mean;
	int n;

	public e054_2(int[] num, int[] mean) {
		this.num = num.clone();
		this.mean = mean.clone();
	}

	public void change() {
		order(0);
		if (RoyalFlesh10(14))
			return;
		if (RoyalFlesh10(num[0]))// 9
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
		if(num[0]!=num[1])
		return false;
		n=1;
		return true;
	}

	private boolean twoPara2() {
		if (!nextPara(0))
			return false;
		if (!nextPara(2))
			return false;
		n=2;
		return true;
	}

	private boolean nextPara(int i) {
		int z = nextPARARAM(i);
		if (z == -1)
			return false;
		
		DoNewNum(i,z);
		return true;
	}

	private void DoNewNum(int i, int z) {
		int numNew[] = num.clone();
		int para=num[z];
		numNew[i]=numNew[i+1]=para;
		int t=i+2;
		for(int j=i;j<5;j++) {
			if(num[j]==para)
				continue;
			numNew[t++]=num[j];
		}
			num=numNew;
		
	}

	private int nextPARARAM(int i) {
		for (; i < 4; i++)
			if (num[i] == num[i + 1])
				return i;
		return -1;
	}

	private boolean tree3() {
		if (num[0] == num[2]) {
			n = 3;
			return true;
		}

		return false;
	}

	private boolean Strate5() {
		if (!Down(num[0]))
			return false;
		n = 5;
		return true;
	}

	private boolean Flesh6() {
		if (!Nodifferent(mean, 0, 5))
			return false;
		n = 6;
		return true;
	}

	private boolean Fullxaus7() {
		ChangeHave3();
		if (num[0] == num[2])
			if (num[3] == num[4]) {
				n = 7;
				return true;
			}

		return false;
	}

	private void ChangeHave3() {
		if (num[2] == num[4]) {
			int q = num[0];
			int a = num[1];
			num[1] = num[0] = num[2];
			num[3] = q;
			num[4] = a;
		}
		if (num[1] == num[3]) {
			int q = num[0];
		
			num[1] = num[0] = num[2];
			num[3] = q;			
		}
	}

	private boolean Kare8() {
		n = 8;
		if (Nodifferent(num, 0, 4))
			return true;
		if (Nodifferent(num, 1, 5)) {
			CH(0, 4, num);
			return true;
		}
		n = 0;
		return false;
	}

	private boolean RoyalFlesh10(int k) {
		if (!Nodifferent(mean, 0, 5))
			return false;
		if (!Down(k))
			return false;
		if (k == 14)
			n = 10;
		else
			n = 9;
		return true;
	}

	private boolean Down(int k) {
		for (int i = 0; i < 5; i++)
			if (num[i] != k--)
				return false;
		return true;
	}

	private boolean Nodifferent(int[] m, int i, int j) {
		int q = m[i];
		for (; i < j; i++)
			if (m[i] != q)
				return false;
		return true;
	}

	private void order(int i) {
		for (; i < 5; i++)
			for (int j = i + 1; j < 5; j++) {
				if (num[j] > num[i]) {
					CH(i, j, num);
					CH(i, j, mean);
				}
			}

	}

	private void CH(int i, int j, int[] n) {
		int q = n[i];
		n[i] = n[j];
		n[j] = q;

	}

	public boolean compear(e054_2 e) {
		if (this.n > e.n)
			return true;
		if (this.n < e.n)
			return false;
		for (int i = 0; i < 5; i++) {
			if (this.num[i] > e.num[i])
				return true;
			if (this.num[i] < e.num[i])
				return false;
		}
		System.out.print(5 / 0);
		return false;
	}

}
