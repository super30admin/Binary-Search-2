//Time O(log n)
//space O(1)
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = findBound(nums, target, true);

        if (firstOccurrence == -1) {
            return new int[] { -1, -1 };
        }

        int lastOccurrence = findBound(nums, target, false);

        return new int[] { firstOccurrence, lastOccurrence };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            if (nums[mid] == target) {
                if (isFirst) {
                    // Check if this is the first occurrence
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    // Check if this is the last occurrence
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    begin = mid + 1;
                }
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}