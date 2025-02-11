package Day4;
/*A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Sample Input-1:
---------------
xyzzaz

Sample Output-1:
----------------
1

Explanation: 
------------
There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Sample Input-2:
---------------
aababcabc

Sample Output-2:
----------------
4

Explanation: 
------------
There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc". */
import java.util.*;

class GoodStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numGoodStrings(s));
        sc.close();
    }

    public static int numGoodStrings(String s) {
        if (s.length() < 3) {
            return 0;  
        }

        Map<Character, Integer> charCount = new HashMap<>();
        int count = 0;


        for (int i = 0; i < 3; i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (charCount.size() == 3) {
            count++;
        }
        for (int i = 3; i < s.length(); i++) {
            char leftChar = s.charAt(i - 3);
            charCount.put(leftChar, charCount.get(leftChar) - 1);
            if (charCount.get(leftChar) == 0) {
                charCount.remove(leftChar);
            }

            char rightChar = s.charAt(i);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

            if (charCount.size() == 3) {
                count++;
            }
        }

        return count;
    }
}
