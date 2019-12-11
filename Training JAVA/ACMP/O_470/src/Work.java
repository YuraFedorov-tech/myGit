
public class Work {

	public static int FindAnswear(int[][] price, int yL, int xL, int yR, int xR) {
int answear=0;
int [][]PartSumm=new int[price.length][price[0].length];

PartSumm=Helping.DoPartSumm(PartSumm,price);
//Print.pr(PartSumm);
for (int i = yL; i < yR+1; i++){
	
	int AnsI=Helping.Find1Stroka(xL,xR,PartSumm[i]);
	answear+=AnsI;
}





		
		return answear;
	}

}
