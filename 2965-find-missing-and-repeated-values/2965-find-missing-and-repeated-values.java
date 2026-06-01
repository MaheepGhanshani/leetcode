class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int size=n*n;
        HashSet<Integer>set=new HashSet<>();
        int repeated=-1;
        int actualSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val=grid[i][j];
                actualSum+=val;
                if(set.contains(val)){
                    repeated=val;
                }
                else{
                    set.add(val);
                }
            }
        }
        int expectedSum=size* (size+1)/2;
        int missing =expectedSum-(actualSum-repeated);
        return new int[]{repeated,missing };
        
    }
}