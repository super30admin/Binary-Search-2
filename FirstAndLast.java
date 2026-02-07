// Binary Search O(log n) time, O(1) space
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[] {-1, -1};

        int left = 0;
        int right = n-1;
        int first = getFirst(left, right, nums, target);
        int last = getLast(left, right, nums, target);
        return new int[] {first, last};
    }

    private int getFirst(int left, int right, int[] nums, int target) {
        int first = -1;
        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                first = mid;
                right = mid - 1;
            }
        }
        return first;
    }

    private int getLast(int left, int right, int[] nums, int target) {
        int last = -1;
        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                last = mid;
                left = mid + 1;
            }
        }
        return last;
    }
}
