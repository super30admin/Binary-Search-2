// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int findMin(int[] nums) {
        int low,mid,high;
        low = 0;
        high = nums.length - 1;

        while (low <= high) {

            if (nums[low] <= nums[high]) //whole array is sorted
            {
                return nums[low];
            }
            mid = low + (high - low)/2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length-1 || nums[mid] < nums[mid + 1]))//check for local minimum 
            {
                return nums[mid];
            }
            if (nums[low] <= nums[mid]) {//checking for sorted left side
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {//checking for sorted right side
                high = mid - 1;
            }


        }
        return -1;
    }
}
