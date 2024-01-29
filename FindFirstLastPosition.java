//Time Complexity - O(logn)
//Space Complexity - O(1)
// Approach - Apply Binary seacrh twice to find the first and last occurance of the target element seperately.

class FindFirstLastPosition {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);

        return new int[] { firstPosition, lastPosition };

    }

    private int findFirstPosition(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int firstPos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstPos = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstPos;
    }

    private int findLastPosition(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int lastPos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastPos = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastPos;
    }

}