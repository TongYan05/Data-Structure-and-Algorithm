package Algorithm;

public class GreedyAlgorithm {

    //121. 买卖股票的最佳时机
    class Solution1 {
        public int maxProfit(int[] prices) {
            int minPrice=prices[0];
            int profit=0;
            for(int i=0;i<prices.length;i++){
                minPrice=Math.min(prices[i],minPrice);//find the min price
                int p=prices[i]-minPrice;//the calculation of profit
                profit=Math.max(profit,p);//get the max of profit
            }
            return profit;
        }
    }


}
/*
git add .
git commit -m "Greedy Algorithm"
git push

 */