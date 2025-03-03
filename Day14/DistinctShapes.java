package Day14;
/*Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4
 */
import java.util.*;
class DistinctShapes{
    public final static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int baseRow;
    public static int baseCol;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    arr[i][j]=0;
                    baseRow = i;
                    baseCol=j;
                    StringBuilder sb = new StringBuilder();
                    
                    bfs(i,j,sb,arr);
                    //System.out.println(sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        //System.out.println(set);
        System.out.println(set.size());
    }
    public static void bfs(int i,int j,StringBuilder sb,int[][] arr){
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[] {i,j});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] dir:directions){
                int ni=temp[0]+dir[0];
                int nj = temp[1]+dir[1];
                if(ni>=0 && nj>=0 && ni<arr.length && nj<arr[0].length && arr[ni][nj]==1){
                    q.add(new int[] {ni,nj});
                    sb.append(ni-baseRow);
                    sb.append(nj-baseCol);
                    arr[ni][nj]=0;
                    
                }
            }
        }
        
        
    }
}
