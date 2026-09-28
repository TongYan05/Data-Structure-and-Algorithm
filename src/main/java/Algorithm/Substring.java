package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Substring {

    //560. 和为 K 的子数组
    class Solution1 {
        public int subarraySum(int[] nums, int k) {
            int sum=0;
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int time=0;
            for(int x:nums){
                sum=sum+x;

                if(map.containsKey(sum-k)){
                    time+=map.get(sum-k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return time;
        }
    }


}
/*
git add .
git commit -m "substring"
git push
 */