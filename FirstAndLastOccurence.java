/* Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach in three sentences only
Two binary search implemented. First to find the first occurence. Then the next one from the range of
firstOccurence till end. To check if it's the first occurence, compare with left; for last occurence compare with right
*/

class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;

        // first binary search to calculate the first occurence

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // first occurence only if element to left is not equal to nums[mid] or mid == 0
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    firstIndex = mid;
                    break;
                }
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // element not found
        if (firstIndex == -1)
            return new int[] { -1, -1 };

        // second binary search from firstIndex to last element
        low = firstIndex;
        high = nums.length - 1;
        int lastIndex = firstIndex;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // last occurence only if element to right is not equal to nums[mid] or mid is
                // last index
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                    lastIndex = mid;
                    break;
                }
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] { firstIndex, lastIndex };
    }
}