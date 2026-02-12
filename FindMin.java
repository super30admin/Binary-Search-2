class FindMin {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length - 1, mid;

        while(low <= high) {
            mid = low + (high - low) / 2;

            if(nums[low] <= nums[high]) return nums[low];

            if((mid == low || nums[mid] < nums[mid - 1])
                    && (mid == high || nums[mid] < nums[mid + 1]))
                return nums[mid];

            if(nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }
}