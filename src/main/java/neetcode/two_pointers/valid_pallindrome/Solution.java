package neetcode.two_pointers.valid_pallindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        return myIsPalindrome(s);
    }

    public boolean myIsPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))) {
                i++;
                continue;
            }
            if (!(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j)))) {
                j--;
                continue;
            }

            char l = Character.toLowerCase(s.charAt(i));
            char r = Character.toLowerCase(s.charAt(j));
            if (l != r) return false;
            i++;
            j--;
        }
        return true;
    }
}
