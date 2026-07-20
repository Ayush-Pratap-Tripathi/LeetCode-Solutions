class Solution {
    public static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
                k++;
            } else {
                result[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length){
            result[k] = nums2[j];
            j++;
            k++;
        }

        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);

        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
        }
    }
}