class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return ans;
        intervals.sort((i1, i2) -> i1.start - i2.start);                //Remember that
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start > end) {
                ans.add(new Interval(start, end));
                start= interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }
        
        ans.add(new Interval(start, end));
        
        return ans;
    }
}
