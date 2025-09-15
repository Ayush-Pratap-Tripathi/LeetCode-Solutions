import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split("\\s+");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        char[] broken_keys = brokenLetters.toCharArray();
        for (int i=0; i<=wordsList.size()-1; i++) {
            boolean wordToBeRemoved = false;
            for (int j = 0; j<broken_keys.length; j++) {
                if (wordsList.get(i).contains(String.valueOf(broken_keys[j]))) {
                    wordsList.remove(i);
                    if (wordsList.size() == 0) {
                        return wordsList.size();
                    }
                    wordToBeRemoved = true;
                    if (i > 0) {
                        i -= 1;
                    }
                }
            }
            if (wordToBeRemoved == true && i == 0) {
                i-=1;
            }
        }
        return wordsList.size();
    }
}