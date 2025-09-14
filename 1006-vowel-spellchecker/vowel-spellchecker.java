import java.util.*;

class Solution {
    private static final boolean[] isVowel = new boolean[128];
    static {
        isVowel['a'] = isVowel['e'] = isVowel['i'] = isVowel['o'] = isVowel['u'] = true;
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        Set<String> exactWords = new HashSet<>(n * 2);
        Map<String, String> caseInsensitiveMap = new HashMap<>(n * 2);
        Map<String, String> vowelErrorMap = new HashMap<>(n * 2);

        // Preprocessing wordlist
        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelErrorMap.putIfAbsent(devoweled, word);
        }

        int m = queries.length;
        String[] result = new String[m];

        for (int i = 0; i < m; i++) {
            String q = queries[i];
            if (exactWords.contains(q)) {
                result[i] = q; // exact match
                continue;
            }

            String lower = q.toLowerCase();
            if (caseInsensitiveMap.containsKey(lower)) {
                result[i] = caseInsensitiveMap.get(lower);
                continue;
            }

            String devoweled = devowel(lower);
            result[i] = vowelErrorMap.getOrDefault(devoweled, "");
        }
        return result;
    }

    private String devowel(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isVowel[arr[i]]) arr[i] = '*';
        }
        return new String(arr);
    }
}
