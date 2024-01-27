class SortedRotatedMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        // there's atleast one element
        int res = nums[0];
        int mid;

        // already sorted array
        if (nums[low] <= nums[high])
            return nums[low];

        while (low <= high) {
            mid = low + (high - low) / 2;

            // left side is sorted
            if (nums[low] <= nums[mid]) {
                res = Math.min(nums[low], res);
                low = mid + 1;
            } else {
                res = Math.min(nums[mid], res);
                high = mid - 1;
            }
        }

        return res;
    }
}