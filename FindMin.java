public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid, min = Integer.MAX_VALUE;

        while (left <= right) {
            // check if sorted
            if (nums[left] <= nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }

            mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }
}