class Solution {
    /*
        Time Complexity : O(log n)
        Space complexity : O(1)

        Solution : To find the starting and ending position of a given target element, 
        we can apply binary search twice. The first binary search will determine the first 
        occurrence of the target element. We will keep applying binary search until the 
        prev element of the target element is smaller than the target element. 
        Then we apply binary search to find the last position of the target element by 
        narrowing the search starting with the frist position we found and then applying binary 
        search until we find the target element position where the next element is greater than
        target element.
    */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int n = nums.length;
        int first = binarySearchForStart(nums, target, 0, n -1);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = binarySearchForLast(nums, target, first, nums.length -1);
        return new int[]{first, last};
    }

    private int binarySearchForStart(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid -1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchForLast(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}