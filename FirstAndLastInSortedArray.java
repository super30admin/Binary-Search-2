// sc - O(1)
class FirstAndLastInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0 || nums.length == 0)
            return new int[]{-1, -1};

        int n = nums.length;
        if(nums[n-1] < target || nums[0] > target) return new int[]{-1, -1};

        int left = binarySearchLeft(nums, target);
        if(left == -1) return new int[]{-1, -1};
        int right = binarySearchRight(nums, left, n-1, target);
        if(right == -1) return new int[]{-1, -1};
        System.out.println(left + " " + right);

        return new int[]{left, right};
    }

    public int binarySearchLeft(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low) / 2;

            if(nums[mid] == target) {
                if(mid == high || nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRight(int[] nums, int low, int high, int target) {
        // int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low) / 2;

            if(nums[mid] == target) {
                if(nums[mid] > nums[mid+1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}