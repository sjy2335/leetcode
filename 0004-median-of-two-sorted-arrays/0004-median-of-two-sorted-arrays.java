import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] concatenated = new int[l1 + l2];
        System.arraycopy(nums1, 0, concatenated, 0, l1);
        System.arraycopy(nums2, 0, concatenated, l1, l2);
        Arrays.sort(concatenated);
        int length = concatenated.length;
        if (length % 2 == 1) return (double) concatenated[length / 2];
        return (double) (concatenated[length / 2 - 1] + concatenated[length / 2]) / 2;
    }
}