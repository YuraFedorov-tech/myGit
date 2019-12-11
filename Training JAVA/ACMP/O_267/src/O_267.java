import java.util.Scanner;


public class O_267 {

	public static void main(String[] args) {
		Scanner my=new Scanner(System.in);
int n=my.nextInt();
int x=my.nextInt();
int y=my.nextInt();
if(y<x){
	int z=x;
	x=y;y=z;
}
	int xy=x*y;
	int t0=x;
	n--;
	// количество   блоков ху
	int n1=n/(x+y);
	// количество времени копиий всех  блоков
	int t1=n1*xy;
	n-=n1*(x+y);
//xfghzfgth
int tx=0;
int ty=0;
int t2=0;
while(n>0){
	t2++;
	tx++;
	ty++;
	if(x==tx){
		tx=0;
		n--;
	}
	if(y==ty){
		ty=0;
		n--;
	}
	

}
	
System.out.println(t0+t1+t2);	
	int i=8000*8000*15;
	

	}

}
