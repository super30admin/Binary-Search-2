// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class FirstAndLastPositionOfElement {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // First, we intend to remove the right side of the array as we are searching for first position
            if (nums[mid] >= target) {
                right = mid - 1;
                if (nums[mid] == target) {
                    position = mid;
                    System.out.println("First Occurrence Position: " + position);
                }
            } else {
                left = mid + 1;
            }
        }

        return position;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;


            // First, we intend to remove the left side of the array as we are searching for last position
            if (nums[mid] <= target) {
                left = mid + 1;
                if (nums[mid] == target) {
                    position = mid;
                    System.out.println("Last Occurrence Position: " + position);
                }
            } else {
                right = mid - 1;
            }
        }

        return position;
    }

}
