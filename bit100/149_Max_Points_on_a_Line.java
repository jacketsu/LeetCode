/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;                  
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopes = new HashMap<>();           //each time should be a new slopes map in case of duplicate
            int maxPoints = 0, overlaps = 0, verticals = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        overlaps++;
                    } else {
                        verticals++;
                    }
                } else {
                    int dx = points[j].x - points[i].x;
                    int dy = points[j].y - points[i].y;
                    int gcd = gcd(dx, dy);
                    String frac = dx / gcd + "/" + dy / gcd;
                    if (!slopes.containsKey(frac)) {
                        slopes.put(frac, 0);
                    }
                    slopes.put(frac, slopes.get(frac) + 1);
                    maxPoints = Math.max(maxPoints, slopes.get(frac));
                }
            }
            maxPoints = Math.max(maxPoints, verticals);
            ans = Math.max(ans, maxPoints + overlaps + 1);
        }
        
        return ans;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
