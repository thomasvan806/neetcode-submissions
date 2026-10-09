class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;

        while ((i + j) < nums1.length + nums2.length) {
            if (j >= nums2.length) {
                merge[i + j] = nums1[i];
                i ++;
            } else if (i >= nums1.length) {
                merge[i + j] = nums2[j];
                j ++;
            } else if (nums1[i] >= nums2[j]) {
                merge[i + j] = nums2[j];
                j ++;
            } else {
                merge[i + j] = nums1[i];
                i ++;
            }
        }

        return (merge.length % 2 == 1) ? merge[merge.length / 2] : (double)(merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2;
    }
}
