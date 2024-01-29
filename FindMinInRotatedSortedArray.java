// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

// Your code here along with comments explaining your approach in three sentences only

/**
 * Minimum means finding the pivot in the array. Min should be smaller
 * than both the neighbours. And at each iteration we are checking if we get a
 * strictly sorted portion. Return low in this case.
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length-1]) return nums[0];

        int n = nums.length-1;
        int low = 0;
        int high = n;

        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = (high-low)/2 + low;

            if((mid == 0 || (nums[mid] < nums[mid-1])) && (mid == n || (nums[mid] < nums[mid+1]))) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) { //left half sorted
                low = mid + 1;
            } else { //right half sorted
                high = mid - 1;
            }
        }
        return -1;
    }
}
