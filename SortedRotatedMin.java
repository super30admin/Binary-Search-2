/* Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach in three sentences only
Checking if array is sorted whenever low/high is changed. Always moving towards unsorted side by
comparing low with mid.
*/

class SortedRotatedMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // min array length is 1; so don't need to check array length condition

        while (low <= high) {
            // if array is strictly sorted or the "unsorted" side turns out to be sorted
            // eg: [3,4,5,1,2] target = 1
            if (nums[low] <= nums[high])
                return nums[low];

            int mid = low + (high - low) / 2;
            // pivot condition; smaller than the neighors (all elements)
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            // pivot can never lie in the sorted section; so keep moving to the unsorted
            // section
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[0];
    }
}