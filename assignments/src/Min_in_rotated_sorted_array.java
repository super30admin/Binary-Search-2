public class Min_in_rotated_sorted_array {
    public int findMin(int[] nums) {
        // base case
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length-1;

        if (nums[right] > nums[0]) return nums[0];

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid+1])
                return nums[mid+1];

            if (nums[mid] < nums[mid-1])
                return nums[mid];

            if (nums[mid] > nums[0])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return Integer.MAX_VALUE;
    }
}
