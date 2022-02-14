1)Subarray sum K 
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(0,-1);
        int prefix_sum=0;
        int Max_len=0;
        int n=nums.length;
        for (int i=0;i<n;i++){
            prefix_sum=prefix_sum+(nums[i]==0 ? -1 : 1);
            if(h.containsKey(prefix_sum)){
                Max_len=Math.max(Max_len,i-h.get(prefix_sum));
            }
            else{
                 h.put(prefix_sum,i);
           
            }
            
        }
        
        return Max_len;
    }
}
