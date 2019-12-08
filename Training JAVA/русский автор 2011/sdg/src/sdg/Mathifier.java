public interface IMathifier { 
	public int add (int addend1, int addend2); 
	public int multiply (int factor1, int factor2); 
	public int subtract (int minuend, int subtrahend); 
} 
public class Mathifier implements IMathifier { 
	public int add (int a1, int a2) { 
		// implementation here. 
	} 
	public int multiplyNums (int f1, int f2) { 
		// implementation here. 
	} 
	public int subtractNums (int m, int s) { 
		// implementation here. 
	}
	@Override
	public int multiply(int factor1, int factor2) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int subtract(int minuend, int subtrahend) {
		// TODO Auto-generated method stub
		return 0;
	} 
} 