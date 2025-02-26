package Day13;

import java.util.*;

/*Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:
i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.

Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Input Format:
-------------
Line-1: An integer n
Line-2: n space separated integers

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
10
100 -23 -23 404 100 23 23 23 3 404

Sample Output-1:
----------------
3

Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Sample Input-2:
---------------
1
7

Sample Output-2: 
----------------
0

Explanation: Start index is the last index. You do not need to jump.

Sample Input-3:
---------------
8
7 6 9 6 9 6 9 7

Sample Output-3:
----------------
1

Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
 Constraints:
 ------------
1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8 */
public class MinJumps {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        System.out.println(computeMin(arr,map));
    }
    public static int computeMin(int[] arr,HashMap<Integer,List<Integer>> map){
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=true;
        int count =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int temp = q.poll();
                if(temp==n-1){
                    return count;
                }
                if(temp-1>=0 && !visited[temp-1]){
                    q.add(temp-1);
                    visited[temp-1]=true;
                }
                if(temp+1<n && !visited[temp+1]){
                    q.add(temp+1);
                    visited[temp+1]=true;
                }
                if(map.containsKey(arr[temp])){
                    for(int val:map.get(arr[temp])){
                        q.add(val);
                        visited[val]=true;
                    }
                }
            }
            count++;
        }
        return count;
    }
    
}
