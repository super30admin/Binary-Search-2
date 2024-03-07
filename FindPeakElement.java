/**
 * BS: Move in direction where neighbour > mid
 * Say rightNeighbour > mid move right
 * This is because element to the righ of right can be smaller than right and we get our peak.
 */
class SolutionTwo {
    // We do to BS. One to find first occurance. Second to find last occurance. 

    // Finds first occurance of the target using modified binary search
    private int findFirst(int low, int high, int[] nums, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // Check if it is the first occurance as well
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    // We got first occurance. Return index.
                    return mid;
                } else {
                    // Continue the BS for the first occurance in left direction
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // If occurance was not found
    }

    private int findLast(int low, int high, int[] nums, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // Check if it is the last occurance as well
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    // We got last occurance. Return index.
                    return mid;
                } else {
                    // Continue the BS for the last occurance in right direction
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(0, nums.length - 1, nums, target);
        if (first == -1) {
            return new int[]{-1, -1}; // If target was not found in the array
        }

        int last = findLast(first, nums.length - 1, nums, target);

        return new int[]{first, last};
    }
}