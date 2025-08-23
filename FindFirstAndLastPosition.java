import java.util.Arrays;
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class FindFirstAndLastPosition {

    /**
     * We will perform 2 binary searches, one to find the first index of the target
     * then to find the second index, we will run a binary search from first index of the target until high
     *
     * @param nums      the array to search
     * @param target    the target
     * @return          the first and last index of the target in the nums array
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        int low = 0, high = nums.length - 1;
        int first = binarySearchFirst(nums, low, high, target);
        if (first == -1) return new int[] {-1, -1};
        int second = binarySearchSecond(nums, first, high, target);
        return new int[] {first, second};
    }

    /**
     * Performs binary search on the whole array to find the first index of the target
     *
     * @param nums      the nums array
     * @param low       the low starts from 0
     * @param high      the length of nums array - 1
     * @param target    the target element
     * @return          the first index of the target if found, else -1
     */
    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) return mid;
                else high = mid - 1;
            } else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    /**
     * Performs binary search on the array from the first index of the target to the high
     *
     * @param nums      the nums array
     * @param low       the low starts from first index of the target
     * @param high      the length of nums array - 1
     * @param target    the target element
     * @return          the second index of the target if found, else returns the first index
     */
    private int binarySearchSecond(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) return mid;
                else low = mid + 1;
            } else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        final FindFirstAndLastPosition firstAndLastPosition = new FindFirstAndLastPosition();
        System.out.println(Arrays.toString(firstAndLastPosition.searchRange(new int[]{1, 2, 3, 4, 5, 5, 7, 7, 7, 8, 8, 8, 8, 8, 10}, 8))); //returns [9, 13]
        System.out.println(Arrays.toString(firstAndLastPosition.searchRange(new int[]{1}, 1))); //returns [0, 0]
        System.out.println(Arrays.toString(firstAndLastPosition.searchRange(new int[]{8}, 1))); //returns [-1, -1]
        System.out.println(Arrays.toString(firstAndLastPosition.searchRange(new int[]{}, 1))); //returns [-1, -1]
    }
}
