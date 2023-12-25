public class FindPeakElementIndex {
    // TC: O(log n), SC: O(1)
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, n = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
