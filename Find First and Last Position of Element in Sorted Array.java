class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int n = nums.length - 1;

        int low = 0; 
        int high = n;;

        int first = binarySearchFirst(nums, low, high, target);
        if (first == -1) return new int[]{-1,-1};
        int last = binarySearchLast(nums, first, high, target);
        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < nums[mid] ) return mid;
                else high = mid - 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid] ) return mid;
                else low = mid + 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}