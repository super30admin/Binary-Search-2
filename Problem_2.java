//TC: O(log n).
//SC: O(1)
public class Problem_2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                //means complete array is sorted
                return nums[low];
            }
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                //left side is sorted, so pivot wont lie this side
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}