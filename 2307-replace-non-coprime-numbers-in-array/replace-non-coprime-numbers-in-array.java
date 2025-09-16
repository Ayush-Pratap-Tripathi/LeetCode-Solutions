import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            long current = num;
            
            while (!result.isEmpty()) {
                long last = result.get(result.size() - 1);
                long gcd = gcd(last, current);
                
                if (gcd > 1) {  
                    current = lcm(last, current, gcd);
                    result.remove(result.size() - 1);
                } else {
                    break;
                }
            }
            result.add((int) current);
        }
        
        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b, long gcd) {
        return (a / gcd) * b;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {6, 4, 3, 2, 7, 6, 2};
        System.out.println(sol.replaceNonCoprimes(nums1));

        int[] nums2 = {2, 2, 1, 1, 3, 3, 3};
        System.out.println(sol.replaceNonCoprimes(nums2));
    }
}
