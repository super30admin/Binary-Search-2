import java.util.Arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Search for the first occurrence
        int firstOccurrence = binarySearch(nums, target, true);
        if (firstOccurrence == -1) {
            return result; // Target not found
        }

        // Search for the last occurrence
        int lastOccurrence = binarySearch(nums, target, false);

        result[0] = firstOccurrence;
        result[1] = lastOccurrence;

        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;

                // Adjust search space based on whether to find first or last occurrence
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Example 1: " + Arrays.toString(result1));

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Example 2: " + Arrays.toString(result2));
    }
}
