// Time Complexity: O(log n)
// Space Complexity: O(1)

// Approach: perform a binary search and check if mid value is a peak, if yes return index
// if no, check if left neighbor is greater. If so, definitely one solution exists to the left.
// else check right neighbor, if that is greater, definitely one solution exists to the right.

class Solution {
    public int findPeakElement(int[] nums) {
        // edge case if there is only 1 element
        if (nums.length == 1)
            return 0;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (isPeakElement(nums, mid))
                return mid;
            else if (mid != 0 && nums[mid-1] > nums[mid])
                high = mid - 1;
            else if (mid != nums.length-1 && nums[mid+1] > nums[mid])
                low = mid + 1;
        }
        return -1;
    }

    private boolean isPeakElement(int[] nums, int mid) {

        // consider leftElement value or rightElement if it exists, if there are outside the array, consider integer.min value

        int leftElem = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
        int rightElem = mid == nums.length-1 ? Integer.MIN_VALUE : nums[mid + 1];
        return (nums[mid] > leftElem && nums[mid] > rightElem);
    }
}