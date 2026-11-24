import java.util.ArrayList;

class Solution {
    public int reverse(int x) {
        ArrayList<Integer> digits = new ArrayList<>();
        double reversedNum = 0;

        if (x == 0) {
            return 0;
        }

        if (x < 0) {
            int y = x * -1;
            while (y > 0) {
                int digit = y % 10;
                digits.add(digit);
                y = y / 10;
            }

            for (int i = 0; i < digits.size(); i++) {
                reversedNum = reversedNum + (double) (digits.get(i)) * Math.pow(10, digits.size() - 1 - i);
            }

            if (reversedNum >= Integer.MIN_VALUE && reversedNum <= Integer.MAX_VALUE) {
                return (int) reversedNum * -1;
            } else {
                return 0;
            }
        }

        while (x > 0) {
            int digit = x % 10;
            digits.add(digit);
            x = x / 10;
        }

        for (int i = 0; i < digits.size(); i++) {
            reversedNum = reversedNum + (digits.get(i)) * Math.pow(10, digits.size() - 1 - i);
        }
        if (reversedNum >= Integer.MIN_VALUE && reversedNum <= Integer.MAX_VALUE) {
            return (int) reversedNum;
        } else {
            return 0;
        }
    }
}