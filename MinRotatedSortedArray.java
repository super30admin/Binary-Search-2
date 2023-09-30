public class MinRotatedSortedArray {
    public MinRotatedSortedArray() {

    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid;
        int min = Integer.MAX_VALUE;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[lo] <= nums[mid]) {
                min = Math.min(nums[lo], min);
                lo = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                hi = mid - 1;
            }
        }
        return min;
    }
}