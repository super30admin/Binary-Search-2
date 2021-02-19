class Solution {
    public int findPeakElement(int[] nums) {
        
        for(int i=0; i<nums.length; i++)
        {
            if(i<nums.length-1 && nums[i]> nums[i+1])
            {
                if(i==0)
                    return i;
                if(nums[i]>nums[i-1])
                    return i;
                else
                    i++;
            }
            else{
                if(i==nums.length-1)
                    return i;
            }
            
        }
        return 0;
    }
}