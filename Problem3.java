// Time Complexity :
//      findPeakElement() - O(log(n))
//      
// Space Complexity :
//      overall - O(1)
//      findPeakElement() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return 0;
        else
        {
            int l=0, h = nums.length-1, m=0;
            
            while(l <= h)
            {
                m = l + (h-l)/2;
                
                if(m == 0 || m == nums.length-1)
                {
                    if(nums[0] > nums[1])
                        return 0;
                    
                    else if(nums[nums.length-1] > nums[nums.length-2])
                        return nums.length-1;
                    
                    else if(nums[0] < nums[1])
                        l = 1;
                    
                    else if(nums[nums.length-1] < nums[nums.length-2])
                        h = nums.length-2;
                }
                
                else if(nums[m] > nums[m+1] && nums[m] > nums[m-1])
                    return m;
                
                else if(nums[m+1] > nums[m-1])
                    l = m+1;
                
                else
                    h = m-1;
            }
            
            return m;
        }
    }
}