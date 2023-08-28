// Leetcode problem : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * I perform binary search to find first occurrence of the target element. If it's not present, I straight away return {-1,-1}. If it's present, I store the first occurrence in ans[0] and I run a right
 * binary search from the boundaries ans[0] to nums.length-1.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []ans = {-1,-1};
        int leftResult = lsearch(nums, target);
        if(leftResult == -1)
        {
            return ans;
        }
        ans[0]=leftResult;
        ans[1] = rsearch(nums,target,leftResult);
        return ans;
    }

    public int lsearch(int []nums, int target)
    {
        int low = 0, high = nums.length-1;
        int result = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]>=target)
            {
                if(nums[mid]==target)
                    result = mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return result;
    }

    public int rsearch(int []nums, int target, int low)
    {
        int high = nums.length-1;
        int result = low;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                result = mid;
                low = mid+1;
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
        }
        return result;

    }
}