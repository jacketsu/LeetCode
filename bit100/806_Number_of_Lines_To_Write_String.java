class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        if (widths == null || widths.length == 0 || S == null || S.length() == 0) return new int[]{0, 0};
        int sum = 0;
        int line = 1;
        int lastLineNum = 0;
        for (int i = 0; i < S.length(); i++) {
            int width = widths[S.charAt(i) - 'a'];
            if (sum + width > 100) {
                line++;
                sum = width;
            } else {
                sum += width;
            }
        }
        
        return new int[]{line, sum};
    }
}
