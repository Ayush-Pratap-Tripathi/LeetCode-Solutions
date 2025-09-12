class Solution {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            }
        }
        return vowelCount != 0;
    }
}
