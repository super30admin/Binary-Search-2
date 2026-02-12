class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1,-1};
        int first = getFirstOccurance(nums, target, 0, nums.length - 1);
        if(first == -1) return new int[]{-1,-1};

        int last = getLastOccurance(nums, target, first, nums.length - 1);
        return new int[] {first, last};
    }

    private int getFirstOccurance(int[] nums, int target, int low, int high) {
        int mid;

        while(low <= high) {
            mid = low + (high - low) / 2;

            if(nums[mid] ==  target) {
                if(mid ==  low || nums[mid-1] != nums[mid]) {
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

    private int getLastOccurance(int[] nums, int target, int low, int high) {
        int mid;

        while(low <= high) {
            mid = low + (high - low) / 2;

            if(nums[mid] ==  target) {
                if(mid ==  high || nums[mid+1] != nums[mid]) {
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