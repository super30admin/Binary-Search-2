public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])) {
                return mid;
            }
            if(nums[mid+1] > nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return 0;
    }
}
