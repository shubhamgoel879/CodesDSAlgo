import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return null;
        Arrays.sort(intervals, (i1,i2)->(i1[0]-i2[0]));
        ArrayList<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=(res.get(res.size()-1))[1])
            {
                (res.get(res.size()-1))[1]=Math.max(intervals[i][1],(res.get(res.size()-1))[1]);
            }
            else
                res.add(intervals[i]);
        }
        int[][] finalres=new int[res.size()][];
        for(int i=0;i<res.size();i++)
        {
            finalres[i]=res.get(i);
        }
        return finalres;
    }
}
