// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// we do bsFloor and bsCeil to get the start and end respectively

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums ==null) return new int[]{-1,-1};
        int start = -1, end = -1;
        start = bsFloor(nums,target);
        end = bsCeil(nums,target);
        
        return new int[]{start,end};
    }
    private int bsFloor(int[] nums, int target)
    {
        int index = -1;
        int lo = 0,hi = nums.length -1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target) index = mid;
            if(target<= nums[mid])
            {
                hi = mid-1;
            }
            else{
                lo = mid + 1;
            }
        }
        return index;
    }
    private int bsCeil(int []nums,int target)
    {
        int index = -1;
        int lo = 0,hi = nums.length -1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target) index = mid;
            if(target>= nums[mid])
            {
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return index;
        
    }
}