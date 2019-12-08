class SMatrix {
	private int n;
	private int a[][];

	void setBase(int n) {
		this.n = n;
		a = new int[n][n];
	}

	// Заполнение случайными числами:
	void setRND() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = (int)( Math.random() * 10);
	}

	// Заполнение одинаковыми числами:
	void setVal(int w) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = w;
	}

	// Заполнение последовательностью цифр:
	void setNums() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = (i*n+j)%9+1;
	}

	// Единичная матрица:
	void setE() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = 1;
	}

	// Отображение матрицы:
	void show() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				System.out.print(a[i][j] + (j == n - 1 ? "\n" : " "));
	}

	// След матрицы:
	int Sp() {
		int s = 0;
		for (int i = 0; i < n; i++)
			s += a[i][i];
		return s;
	}

	// Определитель матрицы:
	int det() {
		int D = 0;
		switch (n) {
		case 1:
			D = a[0][0];
			break;
		case 2:
			D = a[0][0] * a[1][1] - a[0][1] * a[1][0];
			break;
		case 3:
			int i, j, A, B;
			for (j = 0; j < n; j++) {
				A = 1;
				B = 1;
				for (i = 0; i < n; i++) {
					A *= a[i][(j + i) % n];
					B *= a[n - i - 1][(j + i) % n];
				}
				D += A - B;
			}
			break;
		default:
			int k,sign=1;
			SMatrix m;
			for(k=0;k<n;k++){
			m=new SMatrix();
			m.setBase(n-1);
			for(i=1;i<n;i++){
			for(j=0;j<k;j++) m.a[i-1][j]=a[i][j];
			for(j=k+1;j<n;j++) m.a[i-1][j-1]=a[i][j];
			}
			D+=sign*a[0][k]*m.det();
			sign*=(-1);
			}
			}
			return D;}

	void trans() {
		int i, j, s;
		for (i = 0; i < n; i++)
			for (j = i + 1; j < n; j++) {
				s = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = s;
			}
	}
	
}
public class r4_11 {
	public static void main(String[] args){
		
		SMatrix obj=new SMatrix();
		// Определение размера матрицы и ее создание:
		obj.setBase(3);
		// Заполнение случайными числами:
		obj.setRND();
		// Единичная матрица:
		obj.setE();
		// Заполнение единицами:
		//obj.setVal(1);
		// Заполнение последовательностью цифр:
		obj.setNums();
		System.out.println("Исходная матрица:");
		obj.show();
		System.out.println("После транспонирования:");
		// Транспонирование матрицы:
		obj.trans();
		obj.show();
		// Вычисление следа матрицы:
		System.out.println("След матрицы: "+obj.Sp());
		// Вычисление определителя матрицы:
		System.out.println("Определитель матрицы: "+obj.det());
		
		
	}
}
