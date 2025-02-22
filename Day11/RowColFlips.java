package Day11;
/*You are given a rectangular grid of M x N bulbs arranged on a wall. 
Each bulb can emit either blue light or red light, represented as:
-> 0 → Blue Light
-> 1 → Red Light

Allowed Operation:
-------------------
-> Choose any row or column.
-> Toggle each bulb in that row or column, i.e.:
    Change 0 → 1 (Blue to Red).
    Change 1 → 0 (Red to Blue).
Your task is to determine if it is possible to turn all bulbs into blue light (all 0s) using any number of toggle operations.

Constraints
------------
1 ≤ M, N ≤ 100
The grid contains only 0s and 1s.

Input Format:
-------------
Line 1: Two space-separated integers M and N, representing the size of the grid.
Next M lines: Each line contains N space-separated integers (either 0 or 1).

Output Format:
--------------
Print true if it is possible to turn all bulbs into 0. Otherwise, print false.

Sample Input-1:
---------------
3 3
1 0 1
0 1 0
1 0 1

Sample Output-1:
----------------
true

Explanation: 
------------
1) Toggle column 1 and column 3, the grid becomes:
0 0 0
1 1 1
0 0 0

2) Toggle row 2, the grid becomes:
0 0 0
0 0 0
0 0 0

3) Now, all bulbs emit blue light (0). Hence, output is true.

Sample Input-2:
---------------
3 3
1 0 0
0 1 0
0 0 0

Sample Output-2:
----------------
false

Explanation: 
------------
No sequence of toggle operations can make all bulbs 0.
Hence, output is false.

 */
import java.util.*;

class RowColFlips{
    public static boolean check(int[] row1,int[] row2){
        boolean flag;
        if((row1[0]^row2[0])==0){
            flag=true;
        }
        else{
            flag=false;
        }
        for(int i=1;i<row1.length;i++){
            if((row1[i]^row2[i])==0 && !flag){
                return false;
            }
            else if((row1[i]^row2[i])==1 && flag){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] bulbs=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                bulbs[i][j]=sc.nextInt();
            }
        }
        boolean flag=false;
        for(int i=1;i<m;i++){
            if(!check(bulbs[0],bulbs[i])){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("false");
        }
        else{
            System.out.println("true");
        }
    }
}