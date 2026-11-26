import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(int x) {
      ArrayList <Integer> digits = new ArrayList<>();

      if (x < 0) {
        return false;
      }

      if (x>0){
        while (x>0){
            int digit = x%10;
            digits.add(digit);
            x = x/10;
        }
      }

      ArrayList <Integer> reversedDigits = new ArrayList<>(digits);
      Collections.reverse(reversedDigits);

      System.out.println(digits);
      System.out.println(reversedDigits);

      if (digits.equals(reversedDigits)) {
        return true;
      }
      return false;
    }
}