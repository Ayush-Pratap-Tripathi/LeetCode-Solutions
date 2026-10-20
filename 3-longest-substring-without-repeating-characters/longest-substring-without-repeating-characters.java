class Solution {
    public static int longestStringLength(ArrayList<String> list) {
        int maxLength = 0;

        for (String str : list) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> substrings = new ArrayList<>();

        String substring = "";

        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j <= s.length() - 1) {
                if (substring.indexOf(s.charAt(j)) != -1) {
                    substrings.add(substring);
                    substring = "";
                    break;
                } else {
                    if (j == s.length() - 1) {
                        substring = substring + s.charAt(j);
                        substrings.add(substring);
                    } else {
                        substring = substring + s.charAt(j);
                    }
                }
                j++;
            }
            substring = "";
        }
        return longestStringLength(substrings);
    }
}