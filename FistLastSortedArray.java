public class FistLastSortedArray {
    /*
    Perform binary search until target is found, the current range should include
    first an last index of target. One left side find the element where target has lower
    left neighbour and on right side higher right neighbor.
    Time: O(1) Space: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                int firstIdx = findFirstIdx(nums, target, low, mid);
                int secondIdx = findSecondIdx(nums, target, mid, high);
                return new int[] {firstIdx, secondIdx};
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int findFirstIdx(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || (mid != 0 && nums[mid - 1] < nums[mid])) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findSecondIdx(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == (nums.length - 1) || (mid != (nums.length - 1) && nums[mid + 1] > nums[mid])) {
                    return mid;
                } else {
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
}
