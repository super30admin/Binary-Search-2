/**
 * My approach was to find start index first
 * Then end index. Method was simply compare left index for start and right index for end.
 */

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};

        int start = binarySearchStart(nums, target);
        int end = binarySearchEnd(nums, target);
    
        return new int[]{start, end};
    }

    private int binarySearchStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = start + ((end - start)/2);

            if(nums[mid] == target) {
                if(mid == 0) {
                    return mid;
                }

                if(nums[mid - 1] == target) {
                    end = mid;
                }else {
                    return mid;
                }
            }else if (nums[mid] > target) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        if(nums[end] == target) return end;

        return -1;
    }

    private int binarySearchEnd(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + ((end - start)/2);

            if(nums[mid] == target) {
                if(mid == nums.length - 1) {
                    return mid;
                }

                if(nums[mid + 1] == target) {
                    start = mid + 1;
                }else {
                    return mid;
                }
            }else if (nums[mid] > target) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        if(nums[end] == target) return end;

                return -1;

    }
}