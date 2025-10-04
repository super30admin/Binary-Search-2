// Time Complexity : O(log n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. The core part of finding that minimum lies in the unsorted area of the area helped in
// effectively solving the problem along with couple of straight forward cases.

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid] >= nums[low]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return Integer.MAX_VALUE;

    }
}