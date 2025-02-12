package Day5;

/*Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */
import java.util.*;
class ReverseVowels{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        ArrayList<Character> l = new ArrayList<>();
        l.add('a');
        l.add('e');
        l.add('i');
        l.add('o');
        l.add('u');
        int n = s.length();
        int left = 0;
        int right = n-1;
        while(left<=right){
            if(l.contains(sb.charAt(left))&& l.contains(sb.charAt(right))){
                char temp = sb.charAt(left);
                sb.setCharAt(left,sb.charAt(right));
                sb.setCharAt(right,temp);
                right--;
                left++;
            }
            else if(l.contains(sb.charAt(left))){
                right--;
            }
            else{
                left++;
            }
            
        }
        System.out.println(sb.toString());
    }
}