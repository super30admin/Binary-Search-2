
// Time Complexity :
//      searchRange() - O(log(n))
//      
// Space Complexity :
//      overall - O(1)
//      searchRange() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        else
        {
            int l = 0, h = nums.length-1, m = 0;
            
            while(l <= h)
            {
                m = l + (h-l)/2;
                
                if(nums[m] == target)
                    h = m-1;
                else if(nums[m] < target)
                    l = m+1;
                else if(nums[m] > target)
                    h = m-1;
            }
            
            if(l >= 0 && l < nums.length && nums[l] != target)
                return new int[]{-1,-1};
            else
            {
                int[] arr = new int[2];
                arr[0] = l;
                h = nums.length-1;
                
                while(l <= h)
                {
                    m = l + (h-l)/2;
                    
                    if(nums[m] == target)
                        l = m+1;
                    else if(nums[m] > target)
                        h = m-1;
                }
                
                if(h < nums.length && nums[h] != target)
                    return new int[]{-1,-1};
                else
                {
                    arr[1] = h;
                    return arr;
                }
            }
        }
    }
}
