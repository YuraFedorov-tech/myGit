import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
 
 
public class O_165_2 {
    public static int[][] Input() throws IOException {
        int a[][] = null;
        // 1b. Чтение стандартного ввода:
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        // System.out.print("Enter a line:");
   
 
            String s = stdin.readLine();
            String SSS[] = s.split(" ");
            int y = Integer.valueOf(SSS[0]);
            int x = Integer.valueOf(SSS[1]);
            a = new int[y][x];
            for (int i = 0; i <y; i++) {
                s = stdin.readLine();
                String S[] = s.split(" ");
                for (int j = 0;j < x;j++) {
                 
                    a[i][j] = Integer.valueOf(S[j]);
                     
                }
            }
            // return a;
 
            // System.out.println(stdin.readLine());

    
 
        return a;
    }
 
    public static int[][] Find_MatricaSmegnosti(int[][] matricaSmegnosti,
            ArrayList<Integer> list, int[][] numberOfSteps, int[][] coordinat) {
        int step = 1;
        numberOfSteps[0][0] = 1;
        while (true) {
            step++;
            if (list.size() == 0)
                break;
            int n = list.size();
            for (int i = 0; i < n; i++) {
                TakeOnePoint(matricaSmegnosti, list, numberOfSteps, coordinat,
                        step);
                list.remove(0);
        //      prin_165.prinUsulyMassiv(numberOfSteps);
         
             
             
            }
        }
 
        return matricaSmegnosti;
    }
 
    private static void TakeOnePoint(int[][] matricaSmegnosti,
            ArrayList<Integer> list, int[][] numberOfSteps, int[][] coordinat,
            int step) {
        int c = list.get(0);
        int yLen = coordinat.length;
        int xLen = coordinat[0].length;
        int yOld = c / xLen;
        int xOld = c - yOld * xLen;
 
        int jamp = coordinat[yOld][xOld];
        int yy[] = { 0, jamp };
        int xx[] = { jamp, 0 };
 
        for (int i = 0; i < 2; i++) {
            int x = xOld + xx[i];
            int y = yOld + yy[i];
            if (x > xLen - 1 | y > yLen - 1)
                continue;
            int newPoint = y * xLen + x;
            if (numberOfSteps[y][x] == 0) {
                numberOfSteps[y][x] = step;
                list.add(newPoint);
            }
            int inside = matricaSmegnosti[c][0];
            matricaSmegnosti[c][inside + 1] = newPoint;
            matricaSmegnosti[c][0]++;
        }
 
    }
     
    public static BigInteger Rekursia(BigInteger sum, int[][] matricaSmegnosti,
            int end, int curensy) {
if(end==curensy)
    return sum.add(BigInteger.ONE);
     
for(int i=1;i<=matricaSmegnosti[curensy][0];i++){
    sum=Rekursia(sum,matricaSmegnosti,end,matricaSmegnosti[curensy][i]);
}
 
         
        return sum;
    }
     
    public static void main(String[] args) {
        int coordinat[][] = Input();
        int y=coordinat.length;
        int x=coordinat[0].length;
        //int [] ans={0};
        int[][] NumberOfSteps=new int [y][x];
        ArrayList<Integer> list = new ArrayList<>(); // шаги
        list.add(0);
        int[][] MatricaSmegnosti=new int [y*x][140];
    //  prin_165.prinUsulyMassiv(coordinat);
        MatricaSmegnosti=Find_MatricaSmegnosti(MatricaSmegnosti,list,NumberOfSteps,coordinat);
    //  prin_165.prinUsulyMassiv(coordinat);
    //  prin_165.prinUsulyMassiv(NumberOfSteps);
    //  prin_165.prinUsulyRebra(MatricaSmegnosti);
        BigInteger sum  = BigInteger.valueOf(0);
        sum=Rekursia(sum,MatricaSmegnosti,(y-1)*x+x-1,0);
         
        System.out.println(sum);
    }
}