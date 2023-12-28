/*
binary seach
1. if we find mid is target, we check the mid-1; if that's also target, we just update high = mid-1 an dlook for it again
same goes for the last occurrence
we do two seprate search for the first and last index!
tc: O(log n) + O(log n)
sc: O(1)*/
class Solution {
    int found;

    public int[] searchRange(int[] nums, int target) {

        int firstOccurrence = -1, secondOccurrence = -1;
        found = 0;
        // base case
        if (nums == null || nums.length == 0)
            return new int[] { firstOccurrence, secondOccurrence };

        firstOccurrence = binarySearch(nums, target, 0, nums.length - 1, false);

        if (firstOccurrence > -1)
            secondOccurrence = binarySearch(nums, target, found, nums.length - 1, true);

        return new int[] { firstOccurrence, secondOccurrence };
    }

    private int binarySearch(int[] nums, int target, int low, int high, boolean flag) {
        if (!flag) // we are looking for first occurrence
        {
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    if (mid == low || nums[mid] != nums[mid - 1]) {
                        found = mid;
                        return mid;
                    } else
                        high = mid - 1;
                } else if (nums[mid] < target) // target on right side
                {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        } else {
            // finding last occurrnce
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid == high || nums[mid] != nums[mid + 1])
                        return mid;
                    else
                        low = mid + 1;
                } else if (nums[mid] < target) // target on right side
                {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        // never found, return -1;
        return -1;
    }
}