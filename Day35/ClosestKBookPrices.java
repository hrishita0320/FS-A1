package Day35;
/*You are managing a library system that tracks book prices stored in a Binary Search Tree (BST). 
Given a floating-point target price and a number K, 
return the K book prices from the BST that are numerically closest to the target, 
sorted in ascending order.

Input Format:
-------------
Line-1: An integer N — number of books (nodes in the BST).
Line-2: N space-separated integers — book prices to be inserted into the BST.
Line-3: A floating-point number T — the target price.
Line-4: An integer K — number of closest book prices to return.

Output Format:
---------------
Line-1: Print K integers in ascending order — the closest prices to the target.

Sample Input-1:
---------------
7
5 3 8 2 4 6 9
4.3
3

Sample Output-1:
----------------
3 4 5

Explanation: 
------------
        5
       / \
      4   8
     /   / \
    3   6   9

Closest prices to 4.3: 4, 5, and 3 → sorted: 3 4 5

Sample Input-2:
---------------
3
1 2 3
2.0
1

Sample Output-2:
----------------
2

Explanation: 
------------
        2
       / \
      1   3
  
Closest prices to 2.0: 2
 */
import java.util.Scanner;

public class HighwayMaxScore {
    private static final int MOD = 1_000_000_007; //Equivalent to 10^9 + 7

    public static int getMaxScore(int[] A, int[] B) {
        //Write your code and return an integer, the maximum score
        int n = A.length;
        int m = B.length;
        int i =0;
        int j =0;
        int sumA=0;
        int sumB=0;
        int max = 0;
        while(i<n&& j<m){
            if(A[i]==B[j]){
                max+=Math.max(sumA,sumB)+A[i];
                sumA=0;
                sumB=0;
                i++;
                j++;
            }
            else if(A[i]<B[j]){
                sumA+=A[i];
                i++;
            }
            else{
                sumB+=B[j];
                j++;
            }
            
        }
        while(i<n){
            sumA+=A[i];
            i++;
        }
        while(j<m){
            sumB+=B[j];
            j++;
        }
        max+=Math.max(sumA,sumB);
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read Highway A
        int n = scanner.nextInt();
        int[] highwayA = new int[n];
        for (int i = 0; i < n; i++) {
            highwayA[i] = scanner.nextInt();
        }

        // Read Highway B
        int m = scanner.nextInt();
        int[] highwayB = new int[m];
        for (int i = 0; i < m; i++) {
            highwayB[i] = scanner.nextInt();
        }

        // Calculate and print max score
        System.out.println(getMaxScore(highwayA, highwayB));

        scanner.close();
    }
}
