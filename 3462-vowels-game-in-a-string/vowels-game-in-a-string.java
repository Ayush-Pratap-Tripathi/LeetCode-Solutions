class Solution {
    public boolean doesAliceWin(String s) {
        ArrayList<Character> characters = new ArrayList<>();
        for(char i: s.toCharArray()) {
            characters.add(i);
        }
        int count_for_alice = 0;
        for (int i=0; i < characters.size(); i++) {
            if (characters.get(i) == 'a' || characters.get(i) == 'e' || characters.get(i) == 'i' || characters.get(i) == 'o' ||characters.get(i) == 'u') {
              count_for_alice += 1;  
            }
        }
        if (count_for_alice%2 != 0){
            return true;
        }else {
            if (count_for_alice == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}