// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/*
 * Find first index by using binary search and find last index by doing binary search from first occurence till end
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find first occurence using binary search from 0 to n-1
        int firstIndex = getFirstIndex(nums,target,0);
        // If element is not found then return -1,-1
        if (firstIndex == -1)
            return new int [] {-1,-1};
        // else get the last index by using binary search from first to n-1
        int lastIndex = getLastIndex(nums,target,firstIndex);
        return new int [] {firstIndex,lastIndex};
    }
    public int getFirstIndex(int [] nums,int target,int start){
        int n = nums.length;
        int low = start;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            // if yuou find one element we check if there is same element before it 
            if (nums[mid] == target){
                // if there is same element before shrink to left
                if (mid > 0 && nums[mid-1] == target)
                {
                    high = mid - 1;
                }
                // if that is first occurence return mid
                else{
                    return mid;
                }
            }
            // if less than target then shrink to right
            else if (nums[mid] < target)
                low = mid + 1;
            // shrink left
            else 
                high = mid - 1;
        }
        //element not found
        return -1;
    }
    public int getLastIndex(int [] nums,int target,int start){
        int n = nums.length;
        int low = start;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            // if element is found
            if (nums[mid] == target){
                // if there is element after this element then shrink right
                if (mid < n-1 && nums[mid+1] == target)
                {
                    low = mid + 1;
                }
                // if this is last return mid
                else{
                    return mid;
                }
            }
            // shrink to right
            else if (nums[mid] < target)
                low = mid + 1;
            //shrink to left
            else 
                high = mid - 1;
        }
        return -1;
    }
}