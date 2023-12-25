public class FindMinInRotatedSortedArray {
    // TC: O(log n), SC: O(1)
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, n = nums.length;

        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
