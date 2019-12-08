package e016;

import java.math.BigInteger;


public class e016 {
	static int ans;
	static int max;
	static BigInteger a;
	static BigInteger b;
	public e016(BigInteger one, BigInteger two, int m) {
		a=two;
		b=two;
		ans=0;
		max=m;
		}

		public static void main(String[] args) {
	
	
	e016 d = new e016(BigInteger.ONE, new BigInteger("2"),1000);
	d.work();
	d.print();

}
private void work() {
	//	FindB();
	a=b.pow(max);
		FindAns(a.toString());
	}
private void FindAns(String string) {
	for(int i=0;i<string.length();i++)
		ans+=Integer.parseInt(""+string.charAt(i));
	
}

private void FindB() {
	for(int i=0;i<max;i++)
		a=a.multiply(b);
	
}

private void print() {
	System.out.print(ans);
}

}