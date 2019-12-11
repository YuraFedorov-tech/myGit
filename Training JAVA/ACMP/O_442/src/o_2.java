import java.util.ArrayList;


public class o_2 {
	public static void main(String[] args) {
	int ans[]={0};
int cur[]=new int[5];
Rekur(0,cur,ans);
System.out.println(ans[0]);

		
	}

	private static void Rekur(int step, int[] cur, int[] ans) {
		if(step==5){
			chek(ans,cur);
			return;
		}
		for(int i=0;i<10;i++){
			if(i==0 &step<3)
				continue;
			
			cur[step]=i;
			Rekur(step+1,cur,ans);
			
		}
	}

	private static void chek(int[] ans, int[] cur) {
		int w=cur[0];
		int v=cur[1];
		int r=cur[2];
		int s=cur[3];
		int z=cur[4];
		String ww = Integer.toString(w);
		String vv = Integer.toString(v);
		String rr = Integer.toString(r);
		String ss = Integer.toString(s);
		String zz = Integer.toString(z);
		int q=w*100+v*10+z;
		int qq=v*100+v*10+w;
		int qqq=r*1000+s*100+r*10+v;
		if(q+qq==qqq){
			ans[0]++;
			System.out.println(ww+vv+zz+"+"+vv+vv+ww+"="+rr+ss+rr+vv);
		}
		
	}
}
