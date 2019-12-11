
public class Work {

	public static void diskrimenant( int b, int c, int d) {
if(c==0 & d==0){
	System.out.println("1 "+0);
	return;
}
if(c==0){
	int ans=(int) Math.sqrt(-d);
	int u=-ans;
	System.out.println("1 "+ans+" "+u);
	return;
}
int D=c*c-4*b*d;
if(D<0){
	System.out.println(0);
	return;
}
d=(int) Math.sqrt(D);
int x1=(-c+D)/(2*b);
int x2=(-c-D)/(2*b);
if(x2<x1){
	int z=x1;
	x1=x2;
	x2=x1;
}
if(D==0){
	System.out.println("1 "+x1);
}
System.out.println("2 "+x1+" "+x2);

	}

	
	
	
}
