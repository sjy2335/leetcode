import java.util.stream.IntStream;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] concatenated = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).toArray();
        Arrays.sort(concatenated);
        int length = concatenated.length;
        if (length % 2 == 1) return (double) concatenated[length / 2];
        return (double) (concatenated[length / 2 - 1] + concatenated[length / 2]) / 2;
    }
}