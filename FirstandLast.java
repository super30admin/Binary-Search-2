// Time Complexity : O(log n)
// Space Complexity : O(1)


class FirstandLast {
    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int low = 0;
        int n = nums.length;
        int high = n - 1;

        int first = firstOccurrence(nums, low, high, target);

        if(first==-1){
            return new int[]{-1,-1};
        }

        int last = LastOccurrence(nums,first,n-1,target);
        return new int[]{first,last};

    }

    public int firstOccurrence(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    public int LastOccurrence(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }
}

