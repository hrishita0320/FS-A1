package Day21;

/*Mr.Sathya is playing with numbers he converts the decimal to binary 
and try to find number of positions at which the corresponding
bits are different. Help sathya by giving solution to the problem 
to find sum of bits differences between all the pairs of the 
integers in given numbers.

Input Format:
-------------
Line-1: An integer, N, Number of integers
Lint-2: N space separted, List of integers

Output Format:
--------------
Line-1: An integer, Return the sum of bit differences between all the pairs of the integers.
 
Sample Input-1:
---------------
3
4 14 2

Sample Output-1:
----------------
6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Sample Input-2:
--------------- 
3
4 14 4

Sample Output-2:
----------------
4 */
import java.util.*;
class HammingDistance{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int sum =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                sum+=HammingCode(arr[i],arr[j]);
            }
        }
        System.out.println(sum);
    }
    public static int HammingCode(int i,int j){
        int count =0;
        int k = i^j;
        while(k>0){
            count+=(k&1);
            k=k>>1;
        }
        return count;
    }
}

