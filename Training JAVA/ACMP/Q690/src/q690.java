import java.util.ArrayList;
import java.util.Scanner;
 
public class q690 {
    public static void main(String[] args) {
        Scanner M = new Scanner(System.in);
        int n, m, x = 0, y = 0;
        n = M.nextInt();
        m = M.nextInt();
        String s = M.nextLine().trim();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = M.nextLine().trim();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '.')
                    a[i][j] = -1;
                else {
                    a[i][j] = 0;
                    y = i;
                    x = j;
                }
            }
 
        }
    //  pr(a, n, m);
        GO(a, n, m, y, x);
 
    }
 
    private static void GO(int[][] a, int n, int m, int y, int x) {
 
        int step = 1;
        int z = Rek(step, y, x, a, n, m);
        //pr(a, n, m);
    }
 
    private static int Rek(int step, int y, int x, int[][] a, int n, int m) {
        if (step == m * n ){
            pr(a, n, m);
             
            return 1;
        }
      pr(a, n, m);
        ArrayList<Integer> list = new ArrayList<>();
        FindList(list, y, x, n, m, a);
        if(list.size()==0)
            return 0;
        //if (Chek(y, x, n, m, step))
        int q=  MinusFromList(list, n, m, a);
         
 
        for (int i = q; i < list.size()+q; i+=2) {
            if(i>=list.size())
                i-=list.size();
            int yy = list.get(i);
            int xx = list.get(i + 1);
            a[yy][xx] = step;
            int z = Rek(step + 1, yy, xx, a, n, m);
            if (z == 1)
                return 1;
            a[yy][xx] = -1;
        }
 
        return 0;
    }
 
    private static int MinusFromList(ArrayList<Integer> list, int n, int m,
            int[][] a) {
         
        ArrayList<Integer> listNew = new ArrayList<>();
        int q = 1000;
        int y = 0;
        int x = 0;
        for (int i = 0; i < list.size(); i += 2) {
            y = list.get(i);
            x = list.get(i + 1);
            FindList(listNew, y, x, n, m, a);
            if (q > listNew.size() &listNew.size()!=0 )
                q = i;
            listNew = new ArrayList<>();
        }
     
        y = list.get(q);
        x = list.get(q);
    //  list = new ArrayList<>();
    //  list.add(y);
    //  list.add(x);
        return q;
 
    }
 
    private static boolean Chek(int y, int x, int n, int m, int step) {
        int q=0;
        if(q==0)
            return true;
        if (step == n * m - 1)
            return false;
        if (Chek2(x, n, m, step))
            return false;
        if (Chek2(y, n, m, step))
            return false;
 
        return true;
 
    }
 
    private static boolean Chek2(int x, int n, int m, int step) {
        if (x == n - 1 | x == 0)
            return true;
        if (x == n - 1 | x == 0)
            return true;
        return false;
    }
 
    private static void FindList(ArrayList<Integer> list, int y1, int x1,
            int n, int m, int[][] a) {
        int Y[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int X[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        for (int i = 0; i < 8; i++) {
            int x = x1 + X[i];
            int y = y1 + Y[i];
            if (x > m-1 | x < 0 | y < 0 | y > n-1)
                continue;
            if (a[y][x] != -1)
                continue;
            list.add(y);
            list.add(x);
 
        }
 
    }
 
    private static void pr(int[][] a, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}