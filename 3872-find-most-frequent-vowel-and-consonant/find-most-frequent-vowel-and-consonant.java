class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26]; 

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            int f = freq[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (f > maxVowelFreq) maxVowelFreq = f;
            } else {
                if (f > maxConsonantFreq) maxConsonantFreq = f;
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }
}
