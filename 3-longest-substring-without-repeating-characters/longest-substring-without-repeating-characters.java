import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        ArrayList<Character> result = new ArrayList<>();

        for (int x = 0; x < s.length(); x++) {

            if (s.length() - x <= result.size()) {
                break;
            }

            ArrayList<Character> substring = new ArrayList<>();
            substring.add(s.charAt(x));

            HashSet<Character> seen = new HashSet<>();
            seen.add(s.charAt(x));

            if (s.length() == 1) {
                result = substring;
            } else {

                for (int i = x + 1; i < s.length(); i++) {

                    if (seen.contains(s.charAt(i))) {

                        if (substring.size() > result.size()) {
                            result = substring;
                        }
                        break;

                    } else {

                        substring.add(s.charAt(i));
                        seen.add(s.charAt(i));
                    }
                }
            }

            if (substring.size() > result.size()) {
                result = substring;
            }
        }

        return result.size();
    }
}