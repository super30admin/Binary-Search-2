// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We treat this problem as two separate problems - searching for the leftmost and rightmost index of target
// We do binary search to find each of the indices and adjust the conditions accordingly

class Solution {
    private int leftSearch(int[] nums, int low, int high, int target)
    {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target&&(mid==0||nums[mid-1]<target)) //condn for leftmost index of target
                return mid;
            else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    private int rightSearch(int[] nums, int low, int high, int target)
    {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target&&(mid==nums.length-1||nums[mid+1]>target)) //condn for rightmost index of target
                return mid;
            else if(nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        int leftIdx = leftSearch(nums, 0, nums.length-1,target);
        if(leftIdx==-1) //if element is not found in leftSearch, return [-1,-1]
            return new int[]{-1,-1};
        int rightIdx = rightSearch(nums, leftIdx, nums.length-1,target); //right search is done from leftIdx as we need not search the full array again
        return new int[]{leftIdx,rightIdx};
    }
}   