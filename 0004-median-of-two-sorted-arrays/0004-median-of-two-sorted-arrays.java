import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // make sure that nums1 is shorter
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int border1 = (low + high) / 2; // nums1 경계선
            int border2 = (m + n + 1) / 2 - border1; // nums2 경계선, border1과 더하면 두 배열 개수 절반

            int left1 = border1 == 0 ? Integer.MIN_VALUE : nums1[border1 - 1];
            int right1 = border1 == m ? Integer.MAX_VALUE : nums1[border1];
            int left2 = border2 == 0 ? Integer.MIN_VALUE : nums2[border2 - 1];
            int right2 = border2 == n ? Integer.MAX_VALUE : nums2[border2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = border1 - 1;
            } else {
                low = border1 + 1;
            }
        }

        return -1.0;
    }
}