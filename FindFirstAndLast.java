public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1, left = 0, right = nums.length - 1, mid;

        // Search for the first occurrence of target
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

         // Search for the last occurrence of target
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }
}