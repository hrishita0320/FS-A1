package Day17;
/*You are given an m x n grid where each cell can have one of three values:
-> 0 representing an empty cell,
-> 1 representing a fresh orange, or
-> 2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.


Input Format:
-------------
Line-1: Two integers, m and n, represents grid[] sizes
Line-2 to m: n Space separated integers, represents grid[i][j]

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation: 
-------------
The orange in the bottom left corner (row 2, column 0) is never rotten, 
because rotting only happens 4-directionally.

Sample Input-3:
---------------
1 1
0 2

Sample Output-3:
----------------
0

Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
------------
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2. */

import java.util.*;
class RottingOranges{
    public static int time =0;
    public static int oneCount=0;
    public static final int[][] desig = {{1,0},{-1,0},{0,1},{0,-1}};
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
        
        Queue<int[] > q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==2){
                    
                    q.add(new int[] {i,j,0});
                    arr[i][j]=0;
                    
                }
                else if(arr[i][j]==1){
                    oneCount++;
                    
                }
            }
        }
        bfs(q,arr);
       
        if(oneCount==0){
            System.out.println(time);
        }
        else{
            System.out.println(-1);
        }
    }
    public static void bfs(Queue<int[] > q,int[][] arr){

        
        
        
        
        while(!q.isEmpty()){
            

    
            
            int[] temp = q.poll();
            for(int[] d: desig){
                int ni= temp[0]+d[0];
                int nj= temp[1]+d[1];
                int t = temp[2];
                time = Math.max(time,t);
                if(ni>=0 && nj>=0 && ni<arr.length && nj<arr[0].length && arr[ni][nj]==1){
                    arr[ni][nj]=0;
                    oneCount--;
                    
                    q.add(new int[] {ni,nj,t+1});

                    
                }
            }
            
        }
        
        
        
    }
}
