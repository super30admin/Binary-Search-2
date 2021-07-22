// Time Complexity : O(Lg N) where N = size of the array.
// Space Complexity : O(1). No extra space.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None.


class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Init result array
        int[] result = {-1, -1};
        
        result[0] = binSearch(nums, target, true);
        
        if(result[0] != -1)
        {
            result[1] = binSearch(nums, target, false);
        }
        
        return result;
    }
    
    private int binSearch(int[] a, int target, boolean isFirst)
    {
        int lo = 0, hi = a.length - 1;
        int ans = -1;
        
        // Simple Binary Search logic
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            
            if(a[mid] == target)
            {
                ans = mid;
                if(isFirst)
                {
                    // Means we are finding lower index than this
                    // so change hi
                    hi = mid - 1;
                }
                else
                {
                    // Means we are finding higher index than this
                    // so change lo
                    lo = mid + 1;
                }
            }
            else if(target < a[mid])
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return ans;
    }
}

