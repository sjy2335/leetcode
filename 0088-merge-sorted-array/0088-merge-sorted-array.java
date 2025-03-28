import java.util.*;

class Solution {
    private int[] nums1;
    private int m, n;

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        this.nums1 = nums1;
        this.m = m;
        this.n = n;

        int[] tmp = Arrays.copyOf(nums1, m);
        mergeRecursively(tmp, nums2, 0, 0);
    }

    private void mergeRecursively(int[] tmp, int[] nums2, int i, int j) {
        if (i >= m && j >= n) return;
        if (i >= m) {
            nums1[i + j] = nums2[j];
            mergeRecursively(tmp, nums2, i, j + 1);
            return;
        }
        if (j >= n) {
            nums1[i + j] = tmp[i];
            mergeRecursively(tmp, nums2, i + 1, j);
            return;
        }
        if (tmp[i] <= nums2[j]) {
            nums1[i + j] = tmp[i];
            mergeRecursively(tmp, nums2, i + 1, j);
            return;
        }
        nums1[i + j] = nums2[j];
        mergeRecursively(tmp, nums2, i, j + 1);
    }
}