class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int mx =0;
        
        for(int i=0;i<prices.length;i++){
           if(prices[i]<minPrice){
            minPrice=prices[i];
           }
             int profit=prices[i]-minPrice  ;
             if(profit>mx){
                mx=profit;
             }
          
        }
        return mx;
    }
}