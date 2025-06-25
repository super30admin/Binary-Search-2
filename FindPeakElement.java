//Time Complexity - O(log n)
//Space Complexity - O(1) Not using any extra space.

// Implemented using Binary search on a unsorted array. The condition element is always considered to be strictly greater than a neighbor that is outside the array.
// is taken into account while implementing binary search
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n -1;
        while(low <= high) {
            int mid = low + (high - low) / 2; //to prevent overflow
            if((mid == 0 || (nums[mid - 1] < nums[mid])) && (mid == n-1 || (nums[mid] > nums[mid + 1]))) {
                return mid;
            } else if(mid > 0 && nums[mid] < nums[mid - 1]){
                high = mid -1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
