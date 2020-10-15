//Time complexity:O(logn)
//Space complexity:O(1)
// Leetcode perfect execution:yes

class Solution {
    public int findMin(int[] nums) {
        
        if(nums==null || nums.length==0)return -1;
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            
            if(nums.length==1)
            {
                return nums[0];
            }
            if(  mid!=hi && nums[mid]>nums[mid+1] )
            {
                    return nums[mid+1];
            }
                
             if((mid==hi && nums[mid]<nums[mid-1]))
                {
                    return nums[mid];
               }
            
                
            if(nums[mid]>=nums[lo])
            {
                 lo=mid+1;
            }
            else 
            {
                 hi=mid;
            }
        }
        return nums[0];
      
    }
}
