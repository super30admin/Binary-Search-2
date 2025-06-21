// Time Complexity: O(log n)
// Space Complexity: O(1)

// Approach: if array is fully sorted i.e. nums at low <= nums high, return the first element
// 2nd step is check neighboring elements, if mid is smallest, then return that
// 3rd step is identifying the unsorted part, that's where our smallest element lies
// reduce search space to unsorted subarray by shifting low or high

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            // array is sorted
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            // is mid the smallest element in the array
            if ((mid != 0 && nums[mid] < nums[mid - 1]) && (mid != nums.length-1 && nums[mid] < nums[mid+1])) {
                return nums[mid];
            }

            // find unsorted part, and search there
            // right subarray is unsorted
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            }

            // left subarray is unsorted
            if (nums[mid] <= nums[high]) {
                high = mid - 1;
            }
        }

        return -1;
    }
}