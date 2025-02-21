package Day10;
/*AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false  */
import java.util.*;
class PalindromePermutation{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int initial =0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int bit =(s.charAt(i)-'a');
            initial ^= (1<<bit);
        }
        if(initial==0||(initial&(initial-1))==0){
            System.out.println("true");
        }
       
        else{
             System.out.println("false");
        }
        
    }
}
