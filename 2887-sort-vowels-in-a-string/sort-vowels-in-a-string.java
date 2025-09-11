import java.util.*;

public class Solution {
    public String sortVowels(String s) {
        // Define vowels (both lowercase and uppercase)
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));
        
        // Collect vowels
        List<Character> vowels = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowelsSet.contains(ch)) {
                vowels.add(ch);
            }
        }
        
        // Sort vowels by ASCII
        Collections.sort(vowels);
        
        // Reconstruct string
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char ch : s.toCharArray()) {
            if (vowelsSet.contains(ch)) {
                result.append(vowels.get(vowelIndex++)); // place sorted vowel
            } else {
                result.append(ch); // consonant remains same
            }
        }
        
        return result.toString();
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sortVowels("lEetcOde")); // Output: lEOtcede
        System.out.println(sol.sortVowels("lYmpH"));    // Output: lYmpH
    }
}
