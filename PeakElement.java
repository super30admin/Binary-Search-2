/* Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach in three sentences only
Use binary search. To check if element is peak, compare the neighbors. If mid is not peak,
you can choose to go any side which is bigger than the mid. There will always be atleast 1 peak there.
*/

class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // check if mid is peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            // go left if mid != 0 or mid - 1 is bigger than mid
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } else {
                // go right if mid + 1 is bigger
                low = mid + 1;
            }
        }

        return nums[0];
    }
}