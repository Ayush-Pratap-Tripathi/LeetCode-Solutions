import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // Parallelize the outer loop over k
        int count = IntStream.range(2, n) // 2 to n-1
                .parallel()               // make it run in parallel
                .map(k -> {
                    int localCount = 0;
                    int i = 0;
                    int j = k - 1;

                    while (i < j) {
                        if (nums[i] + nums[j] > nums[k]) {
                            localCount += (j - i);
                            j--;
                        } else {
                            i++;
                        }
                    }

                    return localCount; // return count for this k
                })
                .sum(); // sum counts from all k

        return count;
    }
}
