class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        int[]freq=new int[26] ;
        Queue<Character>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
char ch =s.charAt(i);
freq[ch-'a']++;
q.add(ch);

        }
        while(!q.isEmpty()&&freq[q.peek()-'a']>1){
            q.remove();
        }
        while(q.isEmpty()){
            return -1;
        }
        return s.indexOf(q.peek());
    }
}