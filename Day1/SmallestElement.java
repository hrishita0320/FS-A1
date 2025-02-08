package Day1;
/*You are given an array consisting of N integers, and an integer, K. 
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15
3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1
*/

import java.util.*;
class SmallestElement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int window = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<window;i++){
            pq.add(arr[i]);
        }
        int mini = pq.peek();
        System.out.print(mini+" ");
        for(int i=window;i<n;i++){
            pq.remove(arr[i-window]);
            pq.add(arr[i]);
            mini=pq.peek();
                    System.out.print(mini+" ");

            
        }

    }
}