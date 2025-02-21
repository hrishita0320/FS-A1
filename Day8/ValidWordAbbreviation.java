package Day8;
/*Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1). */
import java.util.*;
class ValidWordAbbreviation{
    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String check = sc.nextLine();
        System.out.println(checkValidity(s,check));
    }
    public static boolean checkValidity(String s,String check){
        int first = 0;
        int second =0;
        while(first<s.length() && second<check.length()){
            if(Character.isDigit(check.charAt(second))){
                  if (check.charAt(second) == '0'){
                    return false; 
                }
                int k = second+1;
                while(k < check.length() && Character.isDigit(check.charAt(k))){
                    k++;
                }
                int dig = Integer.parseInt(check.substring(second,k));
                first+=dig;
                second++;
            }
            else if(s.charAt(first)!=check.charAt(second)){
                return false;
            }
            else{
                first++;
                second++;
            }
        }
         return first == s.length() && second == check.length();
    }
}