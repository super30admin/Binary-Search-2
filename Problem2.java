// Time Complexity :
//      findMIn() - O(log(n))
//      
// Space Complexity :
//      overall - O(1)
//      findMin() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int minD = Integer.MAX_VALUE;
    
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        else
        {
            int l = 0, h = nums.length-1;
        
            while(l <= h) {
                
                int m = l + (h-l)/2;

                //At each step compare nums[l] , nums[m] and nums[h] with minD

                if(nums[m] <= minD)
                    minD = nums[m];
                
                if(nums[l] <= minD)
                    minD = nums[l];
                
                if(nums[h] <= minD)
                    minD = nums[h];
                

                //if left sorted adjust search range     
                if(nums[m] > nums[l]) //left sorted;
                {
                    if(nums[l] > nums[h])
                        l = m+1;
                    else
                        h = m-1;
                }

                //if right sorted we can directly search in left space 
                //because it is right sorted 
                else // right sorted
                {
                    h = m - 1;
                }
            }
            
            return minD;
        }
    }
}