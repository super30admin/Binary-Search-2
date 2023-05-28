// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We had find the first occurance of the target by using binary search. if the target is at mid we need to check if the element
// left to it (mid-1) is same we need to move left. 
// after finding the first index, we have performed Binary search on first index and the last element of the array.

class Solution {
    private int firstIndex(int[] nums, int target, int low, int high)
    {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == 0 ||nums[mid] != nums[mid-1])
                    return mid;
                else 
                    high = mid-1;
            }else if( nums[mid] > target){
                high=mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
    private int lastIndex(int[] nums, int target, int low, int high)
    {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 ||nums[mid] != nums[mid+1])
                    return mid;
                else 
                    low = mid+1;
            }else if( nums[mid] > target){
                high=mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
       int low=0;
       int n= nums.length;
       int high = n-1;
       if(nums == null || high == -1) return new int[]{-1,-1};
       if(target< nums[low] || target> nums[high]) return new int[]{-1,-1}; 
       int first = firstIndex(nums,target,low,high);
       if(first == -1) return new int[]{-1,-1};
       int last = lastIndex(nums,target,first,high);
       return new int[]{first,last};

        
    }
}