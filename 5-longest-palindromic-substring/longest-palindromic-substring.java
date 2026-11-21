
class Solution {

    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int left1 = i;
            int right1 = i;

            while (left1 >= 0 && right1 < s.length()
                    && s.charAt(left1) == s.charAt(right1)) {

                if (right1 - left1 > end - start) {
                    start = left1;
                    end = right1;
                }

                left1--;
                right1++;
            }

            // Even length palindrome
            int left2 = i;
            int right2 = i + 1;

            while (left2 >= 0 && right2 < s.length()
                    && s.charAt(left2) == s.charAt(right2)) {

                if (right2 - left2 > end - start) {
                    start = left2;
                    end = right2;
                }

                left2--;
                right2++;
            }
        }

        return s.substring(start, end + 1);
    }
}
