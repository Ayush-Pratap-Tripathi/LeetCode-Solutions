import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        for (int num : nums) {
            long current = num;

            while (top >= 0) {
                long last = stack[top];
                long gcd = gcd(last, current);

                if (gcd > 1) {
                    current = (last / gcd) * current;
                    top--;
                } else {
                    break;
                }
            }

            stack[++top] = (int) current;
        }

        List<Integer> result = new ArrayList<>(top + 1);
        for (int i = 0; i <= top; i++) {
            result.add(stack[i]);
        }

        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
