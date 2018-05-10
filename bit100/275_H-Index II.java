// Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

// Seen this question in a real interview before?  


class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return len - lo;
    }
}