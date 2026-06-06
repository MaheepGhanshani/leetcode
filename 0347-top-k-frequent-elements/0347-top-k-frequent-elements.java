class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        PriorityQueue<int[]>heap= new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        );
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            heap.add(new int[]{entry.getKey(),entry.getValue()});
            if(heap.size()>k){
                heap.poll();
            }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=heap.remove()[0];
        }
        return ans;
    }
}