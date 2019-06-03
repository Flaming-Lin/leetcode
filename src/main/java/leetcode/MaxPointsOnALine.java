package leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @author Flaming
 * @date 2019/6/3 17:15
 */
public class MaxPointsOnALine {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(Point[] points) {
        if(null == points){
            return 0;
        }
        if(points.length < 3){
            return points.length;
        }

        int result = 0;

        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> slopePointMap = new HashMap<>(16);
            int verticalPointNums = 1;
            int repeatPointNums = 0;
            int currentMaxPointNum = 0;

            for(int j = 0; j < points.length; j++){
                if(i == j){
                    continue;
                }

                int diffX = points[i].x - points[j].x;
                int diffY = points[i].y - points[j].y;

                // 计算两个点的斜率，更新map
                if(0 == diffX && 0 == diffY){
                    // 两个点重合
                    repeatPointNums++;
                }else if(0 == diffX){
                    // 两个点垂直
                    verticalPointNums++;
                }else{
                    double slope = (double)diffY / (double)diffX;
                    int slopePointNum = slopePointMap.containsKey(slope) ? slopePointMap.get(slope) + 1 : 2;
                    slopePointMap.put(slope, slopePointNum);
                    currentMaxPointNum = Math.max(slopePointNum, currentMaxPointNum);
                }

                int onSameLineNum = Math.max(verticalPointNums, currentMaxPointNum) + repeatPointNums;
                result = Math.max(result, onSameLineNum);
            }
        }
        return result;
    }

}
