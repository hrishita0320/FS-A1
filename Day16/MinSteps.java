package Day16;
/*Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n-1 .
Return the minimum number of operations needed for n to become 1.

Sample Input-1:
---------------
8


Sample Output-1: 
----------------
3

Explanation: 8 -> 4 -> 2 -> 1

Sample Input-2:
---------------
7

Sample Output-2: 
----------------
4

Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
 */
import java.util.*;
class MinSteps{
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n,0);
        System.out.println(min);
    }
    public static void dfs(int n, int num){
        if(n==1){
            min=Math.min(min,num);
            return;
        }
        if((n&1)==1){
            dfs(n-1,num+1);
            dfs(n+1,num+1);
        }
        else{
            dfs(n/2,num+1);
        }
    }
}
/*
Chatgpt code optimized space and time complexity
 public class IntegerReplacement {
    public int integerReplacement(int n) {
        int steps = 0;
        long num = n; // Use long to prevent overflow when n == Integer.MAX_VALUE
        
        while (num > 1) {
            if ((num & 1) == 0) {
                num >>= 1; // Divide by 2 if even
            } else {
                // If num is odd, decide whether to increment or decrement
                if (num == 3 || (num & 3) == 1) { 
                    num--;  // Prefer decrementing
                } else {
                    num++;  // Prefer incrementing
                }
            }
            steps++;
        }
        
        return steps;
    }

    public static void main(String[] args) {
        IntegerReplacement solver = new IntegerReplacement();
        System.out.println(solver.integerReplacement(8));  // Output: 3
        System.out.println(solver.integerReplacement(7));  // Output: 4
    }
}
 */