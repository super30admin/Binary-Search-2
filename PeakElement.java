// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

// Your code here along with comments explaining your approach in three sentences only

/**
 * Here we check if both the neighbours are less than the element at mid. Here we have
 * found the peak. To reduce the search space, we move towards the greater element's side.
 * If both neighbours are greater, we can move to ANY side.
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length - 1;
        int low = 0;
        int high = n;


        while (low <= high) {
            int mid = (high - low) / 2 + low;

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n || nums[mid + 1] < nums[mid])) {
                return mid;
            } else if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n || nums[mid + 1] > nums[mid])) {
                low = mid + 1;
            } else if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == n || nums[mid + 1] < nums[mid])) {
                high = mid - 1;
            } else if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == n || nums[mid + 1] > nums[mid])) {
//                 high = mid - 1;
                low = mid + 1;
            }
        }

        return -1;
    }
}
