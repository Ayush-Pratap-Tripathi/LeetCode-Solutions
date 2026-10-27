
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;
        int half = (m + n + 1) / 2;

        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = half - i;

            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                int maxLeft = Math.max(left1, left2);

                if (((m + n) & 1) == 1) {
                    return maxLeft;
                }

                int minRight = Math.min(right1, right2);
                return ((double) maxLeft + minRight) / 2.0;
            }

            if (left1 > right2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Arrays must be sorted");
    }
}
