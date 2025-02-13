package Day6;
/*Two brothers are playing a game based on two sorted lists of numerical elements and a target sum.

The first brother provides:
-> Two sorted lists of integers.
-> A target sum.

The second brother's task is to find and return the closest pair of elements (one from each list) 
whose sum is closest to the given target.

Rules:
------
Each pair must consist of one element from each list.
If multiple pairs have the same closest sum, return any one valid pair.
The input lists are already sorted in ascending order.
The result must be printed as a comma-separated pair.

Input Format:
-------------
Line 1: An integer N1, representing the size of the first list.
Line 2: N1 space-separated integers, representing elements of the first sorted list.
Line 3: An integer N2, representing the size of the second list.
Line 4: N2 space-separated integers, representing elements of the second sorted list.
Line 5: An integer X, representing the target sum.

Output Format:
--------------
Line-1: Print a comma-separated pair (a, b), where a is from list_1 and b is from list_2, such that their sum is closest to the target sum.

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32

Sample Output-1:
----------------
1,30

Explanation:
------------
The closest pair to 32 is (1,30) → 1 + 30 = 31, which is the closest sum to 32.

Sample Input-2:
---------------
3
2 4 6
4
5 7 11 13
15

Sample Output-2:
----------------
2,13

Explanation:
------------
The closest pair to 15 is (2,13) → 2 + 13 = 15, which is an exact match.
 */
import java.util.*;
class ClosestPair{
    public static String helper(int[] arr1,int n,int[] arr2,int n1,int k){
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int left=0;
        int right=n1-1;
        while(left<arr1.length && right>=0){
            if(arr1[left]+arr2[right]<k){
                if(Math.abs(arr1[left]+arr2[right]-k)<min){
                    min=Math.abs(arr1[left]+arr2[right]-k);
                    i=left;
                    j=right;
                }
                left++;
            }
            else{
                if(Math.abs(arr1[left]+arr2[right]-k)<min){
                    min=Math.abs(arr1[left]+arr2[right]-k);
                    i=left;
                    j=right;
                }
                right--;
            }
        }
        String s=arr1[i]+","+arr2[j];
        return s;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr1=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        int n1=sc.nextInt();
        int[] arr2=new int[n1];
        for(int i=0;i<n1;i++){
            arr2[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(helper(arr1,n,arr2,n1,k));
        
    }
}
