class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n + 1) / 2;
        int v = findKth(nums1, 0, m - 1, nums2, 0, n - 1, k);
        
        if ((m + n) % 2 == 0) {
            int k2 = k + 1;
            int v2 = findKth(nums1, 0, m - 1, nums2, 0, n - 1, k2);
            return (v + v2) / 2.0;
        }
        return (double)v;
    }
    
    public int findKth(int[] nums1, int aL, int aR, int[] nums2, int bL, int bR, int k) {
        if (aL > aR) return nums2[bL + k - 1];
        if (bL > bR) return nums1[aL + k - 1];
        
        int midA = (aL + aR) / 2;
        int midB = (bL + bR) / 2;
        
        if (nums1[midA] <= nums2[midB]) {
            if (k <= (midA - aL + midB - bL + 1)) {
                return findKth(nums1, aL, aR, nums2, bL, midB - 1, k);
            } else {
                return findKth(nums1, midA + 1, aR, nums2, bL, bR, k - (midA - aL + 1));
            }
        } else {
            if (k <= (midA - aL + midB - bL + 1)) {
                return findKth(nums1, aL, midA - 1, nums2, bL, bR, k);
            } else {
                return findKth(nums1, aL, aR, nums2, midB + 1, bR, k - (midB - bL + 1));
            }
        }
    }
}
