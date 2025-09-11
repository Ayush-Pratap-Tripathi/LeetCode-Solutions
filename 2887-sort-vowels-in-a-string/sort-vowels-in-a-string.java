public class Solution {
    public String sortVowels(String s) {
        // ASCII size to store counts of all characters
        int[] freq = new int[128]; 
        
        // Store vowels
        String vowels = "aeiouAEIOU";
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                freq[ch]++;
            }
        }
        
        // Build result
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                // Find next smallest vowel by ASCII
                for (int ascii = 0; ascii < 128; ascii++) {
                    if (freq[ascii] > 0) {
                        result.append((char) ascii);
                        freq[ascii]--;
                        break;
                    }
                }
            } else {
                result.append(ch); // keep consonant same
            }
        }
        
        return result.toString();
    }
    
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
    
}
