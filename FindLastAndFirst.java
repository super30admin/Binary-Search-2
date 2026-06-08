class FindLastAndFirst {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int n = nums.length;

        int first = binarySearchFirstElement(0, n - 1, nums, target);
        int last = binarySearchLastElement(0, n - 1, nums, target);
         
        return new int[]{first, last};
    }

    public int binarySearchFirstElement(int left, int right, int[] nums, int target) {
          
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearchLastElement(int left, int right, int[] nums, int target) {
          
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}