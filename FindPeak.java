// sc - O(1)
class FindPeak {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        int low = 0, high = nums.length-1;

        while(low < high) {
            int mid = low + (high-low) / 2;

            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if (mid > 0 && nums[mid-1] > nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;

    }
}