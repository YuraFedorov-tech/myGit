import java.util.ArrayList;
import java.util.Scanner;

public class o154 {

     public static void main(String[] args) {
         Scanner myScanner = new Scanner(System.in);
         int y = myScanner.nextInt() + 2;
         int x = myScanner.nextInt() + 2;
         int yEnter = myScanner.nextInt();
         int xEnter = myScanner.nextInt();
         int[][] Baza = new int[y][x];
         for (int i = 1; i < y - 1; i++) {
             for (int i1 = 1; i1 < x - 1; i1++) {
                 Baza[i][i1] = myScanner.nextInt();

             }

         }
         int H = myScanner.nextInt();// кол-чество гиперпереходов
         int[][] Hiper = new int[4][H];
         for (int i = 0; i < H; i++) {
             for (int i1 = 0; i1 < 4; i1++) {
                 Hiper[i1][i] = myScanner.nextInt();
             }

         }
         int K = myScanner.nextInt();// кол-чество выходов
         int[][] Exit = new int[2][K];
         for (int i = 0; i < K; i++) {
             for (int i1 = 0; i1 < 2; i1++) {
                 Exit[i1][i] = myScanner.nextInt();

             }

         }

         for (int i = 0; i < K; i++) {
             int yy = Exit[0][i];
             int xx = Exit[1][i];

             Baza[yy][xx] = -2; // это выход
         }
         Baza[yEnter][xEnter] = -1;// это вход

         Baza = insideBoard(Baza);
    //     print.pr(Baza);
// print.pr(Hiper);
     // print.pr(Exit);
         ArrayList<Integer> list = new ArrayList<Integer>();// порядок вершин
         int Start = yEnter * x + xEnter;
         list.add(Start);
         int[] Ans = new int[2];
         Ans = pobeg(Ans, list, Baza, Hiper, 1);
         if(Ans[0]==1){
             System.out.print(Ans[1]);
         }else{
             System.out.print("Impossible");
         }
     }

     private static int[][] insideBoard(int[][] baza) {
         for (int i1 = 0; i1 <baza[0].length; i1++)
             baza[0][i1]=baza[baza.length-1][i1]=1;

             for (int i1 = 0; i1 <baza.length; i1++)
             baza[i1][0]=baza[i1][baza[0].length-1]=1;

             return baza;
             }

     private static int[] pobeg(int[] Ans, ArrayList<Integer> list, 
int[][] Baza, int[][] hiper, int Step) {
     Ans= We_in_Exit(list, Baza, Ans, Step);
         while (Ans[0]!=1 ) {
             Step++;

             int n = list.size();
             ArrayList<Integer> list_Giper = new ArrayList<Integer>();// порядок
      // вершин
      // гипертунеля
             list_Giper = inside_Giper(list, Baza, hiper, list_Giper, Step);
             for (int i = 0; i < n; i++) {
                 list = chek_Fist_point(Ans, list.get(0), Baza, Step, 
list); // рассматриваем
          // только
          // первую
          // вершину
                 list.remove(0);
             }
             if (list_Giper.size() != 0)
                 list = list_plus_list_Giper(list, list_Giper);
           //  print.pr(Baza);
             Ans = We_in_Exit(list, Baza, Ans, Step);

             if(Ans[0]==1 | list.size()==0)
                 break;
         }
         return Ans;
     }

     private static int[] We_in_Exit(ArrayList<Integer> list, int[][] 
baza, int[] ans, int Step) {
         for (int j = 0; j < list.size(); j++) {
             int[] a = find_XY_from_L(list.get(j), baza[0].length);
             int[] X_Step = { 0, 1, 0, -1 };
             int[] Y_Step = { -1, 0, 1, 0 };
         if(baza[a[0]][a[1]]==-2){
             ans[0] = 1;
             ans[1] = Step;
             return ans;
         }

             for (int i = 0; i < 4; i++) {

                 if (baza[a[0] + Y_Step[i]][a[1] + X_Step[i]] ==-2) {
                 ans[0] = 1;
                 ans[1] = Step+1;
                 return ans;
             }
         }}

         return ans;
     }

     private static ArrayList<Integer> 
list_plus_list_Giper(ArrayList<Integer> list, ArrayList<Integer> 
list_Giper) {
         for (int i = 0; i < list_Giper.size(); i++) {
             list.add(list_Giper.get(i));
         }
         return list;
     }

     private static ArrayList<Integer> chek_Fist_point(int[] ans, 
Integer V, int[][] baza, int Step,
             ArrayList<Integer> list) {
         int[] a = find_XY_from_L(V, baza[0].length);
         int[] X_Step = { 0, 1, 0, -1 };
         int[] Y_Step = { -1, 0, 1, 0 };
         for (int i = 0; i < 4; i++) {
             if (baza[a[0] + Y_Step[i]][a[1] + X_Step[i]] == 0) {
                 baza[a[0] + Y_Step[i]][a[1] + X_Step[i]] = Step;
                 int f = find_L_from_XY(a[0] + Y_Step[i], a[1] + 
X_Step[i], baza[0].length);
                 list.add(f);
             }

         }

         return list;
     }

     private static ArrayList<Integer> inside_Giper(ArrayList<Integer> 
list, int[][] baza, int[][] hiper,
             ArrayList<Integer> list_Giper, int Step) {
         for (int i = 0; i < list.size(); i++) {
             int[] a = find_XY_from_L(list.get(i), baza[0].length);// a[0]-это Y.
  // первая
             for (int j = 0; j < hiper[0].length; j++) { 
                      // координата
             if (a[0] == hiper[0][j] & a[1] == hiper[1][j]) { // a[1]-это X.
                                                                 // вторая
                                                                 // координата
                 // если мы попали в точку где есть гиперпереход

                 if (baza[hiper[2][j]][hiper[3][j]] == 0) {// и его выход не
                                                             // занят
                     baza[hiper[2][j]][hiper[3][j]] = Step;
                     int f = find_L_from_XY(hiper[2][j], hiper[3][j], 
baza[0].length);
                     list_Giper.add(f);
                 }
                 if (baza[hiper[2][j]][hiper[3][j]] == -2) {
                     int f = find_L_from_XY(hiper[2][j], hiper[3][j], 
baza[0].length);
                     list_Giper.add(f);
                 }


             }
             }
         }

         return list_Giper;
     }

     private static int find_L_from_XY(int y, int x, int L) {
         int f = y * L + x;

         return f;
     }

     private static int[] find_XY_from_L(Integer n, int L) {
         int[] aa = new int[2];
         aa[0] = n / L; // a[0]-это Y. первая координата, номер строки
         aa[1] = n - aa[0] * L; // a[1]-это X. вторая координата, номер столбца
         return aa;
     }

}
