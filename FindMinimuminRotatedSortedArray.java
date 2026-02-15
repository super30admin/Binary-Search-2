// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
we perform binary search to find min element by intially trying to check base case of if this is a sorted
array, then directly return low value. If not, find mid value and check mid's base case check. If not,
check if the value falls in right sorted range by comparing mid value with high value and updating high,
low values accordingly.
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            if(nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if(nums[mid] <= nums[high])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}