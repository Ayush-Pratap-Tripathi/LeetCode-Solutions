class Solution {
    public int[] mergeArray(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                merged[k] = nums1[i];
                i++;
            }else{
                merged[k]=nums2[j];
                j++;
            }
            k++;
        }

        while (j<m) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        while (i<n) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        return merged;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] finalArray = mergeArray(nums1, nums2);
        int n = finalArray.length;

        if(n == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        if ( n%2 != 0) {
            return finalArray[n/2];
        }else {
            int mid1 = finalArray[n/2 - 1];
            int mid2 = finalArray[n/2];
            return ((double) mid1 + mid2)/2;
        }
    }
}