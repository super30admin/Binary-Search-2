// Time Complexity: O(log n)
// Space Complexity: O(1)

// 1: To find the peak element, we need to compare the mid element with its left and right elements
// 2: We will try to expand the range of search to the area where the element is larger
// 3: L#15 covers cases where mid is the first or last element
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}