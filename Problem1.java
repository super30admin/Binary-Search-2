// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I modified the binary search algorithm and implemented my logic in the same function. 
// I got a "Time Limit Exceeded" error. I created a new function and wrote the logic there and kept the binary search algorithm as it is. 
// Then it worked

// Your code here along with comments explaining your approach

class Solution {

    // Binary Search Algorithm
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return getStartEndIndices(nums, mid, target);
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    public int[] getStartEndIndices(int nums[], int mid, int target) {
        
        int start = mid;
        int end = mid;
        
        // Compare the element before nums[start] to check 
        // and see if it is equal to target
        // Decrement start to find the 1st occurence of 
        // target in the array nums
        while(start >= 1 && nums[start - 1] == target) {
            start--;
        }

        // Similarly check the latter half of the array for
        // the last occurence of target and increment end 
        while(end < nums.length - 1 && nums[end + 1] == target) {
            end++;
        }
        
        return new int[]{start, end};
    }
}