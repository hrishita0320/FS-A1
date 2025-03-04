package Day15;
/*
 * Given string num representing a non-negative integer num, and an integer k, 
return the smallest possible integer after removing k digits from num.

Example 1:
input =1432219
3
output =1219

num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */

 import java.util.*;
class RemoveKdigits{
    public static String help(String s,int k){
        if(k>=s.length()){
            return "0";
        }
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>0 && k>0){
            int i=0;
            while(i<sb.length()-1 && sb.charAt(i)<=sb.charAt(i+1)){
                i++;
            }
            sb.deleteCharAt(i);
            k--;
        }
        return sb.toString();
    }
    public static void main(String[] args){ 
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        System.out.println(help(s,n));
        sc.close();
    }
}