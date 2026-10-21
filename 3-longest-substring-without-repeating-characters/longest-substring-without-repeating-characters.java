import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];               // last index each char was seen at
        Arrays.fill(last, -1);
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last[c] >= left) {               // repeat inside the current window
                left = last[c] + 1;              // jump just past the old copy
            }
            last[c] = right;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}