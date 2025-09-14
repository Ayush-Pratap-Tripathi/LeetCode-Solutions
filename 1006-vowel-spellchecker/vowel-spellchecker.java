import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelErrorMap = new HashMap<>();
        
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower, word);
            String devoweled = devowel(lower);
            vowelErrorMap.putIfAbsent(devoweled, word);
        }
        
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactWords.contains(q)) {
                result[i] = q; // exact match
            } else {
                String lower = q.toLowerCase();
                if (caseInsensitiveMap.containsKey(lower)) {
                    result[i] = caseInsensitiveMap.get(lower);
                } else {
                    String devoweled = devowel(lower);
                    if (vowelErrorMap.containsKey(devoweled)) {
                        result[i] = vowelErrorMap.get(devoweled);
                    } else {
                        result[i] = "";
                    }
                }
            }
        }
        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
