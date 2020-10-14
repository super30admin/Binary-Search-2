//Time complexity:O(n)
//Space complexity:O(1)
// Leetcode perfect execution:yes

class Solution {
    public int findMin(int[] nums) {
        
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1)
        {
            return nums[0];
        }
        
        int ele=nums[0];
        int lo=1;
        int hi=nums.length;
        for(int i=1;i<nums.length;i++)
        {
            if(ele>nums[i])
            {
                return nums[i];
            }
            ele=nums[i];
        }
    
        return nums[0];
      
    }
}
