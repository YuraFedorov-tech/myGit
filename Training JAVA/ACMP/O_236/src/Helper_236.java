import java.util.ArrayList;


public class Helper_236 {

	public static String MinusSqwearSkoba(String s) {
		while(true){
			int n=Findsqwear_Skoba(s);
			if(n==-1)
				break;
			int end=FindEnd(n,s);
			
			s=s.substring(0,n)+s.substring(end+1,s.length());
			
		}

		
		return s;
	}

	private static int FindEnd(int n, String s) {
		for(int i=n;i<s.length();i++)
			if(s.charAt(i)==']')
				return i;
			return -1;
	}

	private static int Findsqwear_Skoba(String s) {
	for(int i=0;i<s.length();i++)
		if(s.charAt(i)=='[')
			return i;
		return -1;
	}

	public static ArrayList<String> Devide_S(String s,
			ArrayList<String> polynomial, ArrayList<Integer> znak) {

s=FistZnak(s,znak);

while(true){
	boolean find=false;
	int i=0;
	for(;i<s.length();i++){
		if(s.charAt(i)=='-'){
			znak.add(-1);
			find=true;
			break;
		}
		if(s.charAt(i)=='+'){
			znak.add(1);
			find=true;
			break;
		}

		
		
	}
	
	String sNew=s.substring(0, i);
	if(i!=s.length())
	s=s.substring(i+1,s.length());
	polynomial.add(sNew);	
	if(!find)
		break;
}



		
		return polynomial;
	}

	private static String FistZnak(String s, ArrayList<Integer> znak) {
		if(s.charAt(0)=='-'){
			s=s.substring(1,s.length());
			znak.add(-1);
		}else
			znak.add(1);
		return s;
	}
	static String FindFirstNumber(ArrayList<Integer> number, String s) {
if(s.charAt(0)=='x'){
	number.add(1);
	return s;
}
int i=0;
for(;i<s.length();i++){
	if(s.charAt(i)=='*'){
		break;
	}
}
String sNew=s.substring(0,i);
number.add(Integer.valueOf(sNew));

if(i==s.length()){
	return "";
}

s=s.substring(i+1, s.length());

return s;
	}

	public static int FindSecond(ArrayList<Integer> number, String s, int x) {
if(s.length()==1)
	return number.get(0)*x;
int pow=Integer.valueOf(""+s.charAt(2));
int answear=(int) Math.pow(x, pow);

		
	return answear*number.get(0);	
	}

	
}