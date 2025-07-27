//here in my Approach I'm using a binary search to identify The first occurrence of the target element and another binary search to find the last occurrence of the target element. so the time complexity would be O(2logn)==O(logn) ;
//space complexity is O(1) since i am not additionally using any space 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        var firstIndex = findStartingIndex(nums, target);
        int[] result = { -1, -1 };
        if (firstIndex == -1)
            return result;
        var lastIndex = findLastIndex(nums, target, firstIndex);
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;

    }

    private int findStartingIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid] != nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            } else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int findLastIndex(int[] nums, int target,int index) {
        int low = index;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] != nums[mid + 1])
                    return mid;
                else low = mid + 1;
            } else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 1;
    }
}
