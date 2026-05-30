class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
        HashSet<Integer>set1=new HashSet<>();
        int count =0;
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            if(set.contains(nums2[j])){
            count++;
            set1.add(nums2[j]);
            set.remove(nums2[j]);
            }
        }
       int[]ans=new int[set1.size()];
       int k=0;
       for(int num:set1){
        ans[k++]=num;
       }
return ans;
               
}
}