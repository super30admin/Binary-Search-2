// In this problem, we are using binary search algorithm to determine the
// minimum value from the list of elements in an array
// the time complexity of this implementation is O(log n)
public class FirstandLast {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1, end = -1;

        // Find the leftmost occurrence of target
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                start = mid;
                right = mid - 1;
            }
        }

        // If target is not found, return [-1, -1]
        if (start == -1) {
            return new int[]{-1, -1};
        }

        // Find the rightmost occurrence of target
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                end = mid;
                left = mid + 1;
            }
        }

        return new int[]{start, end};
    }
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("Start index: " + result[0]);
        System.out.println("End index: " + result[1]);

        target = 6;
        result = searchRange(nums, target);
        System.out.println("Start index: " + result[0]);
        System.out.println("End index: " + result[1]);
    }
}
