// Time Complexity: O(lgn)
// Space Complexity: O(1)


class Solution3 {
    public int findPeakElement(int[] nums) {
        if( nums.length == 1) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while( low <= high ) {
            mid = low + (high-low)/2;
            if( mid == 0 && nums[mid] > nums[mid+1] ) {
                return mid;
            }
            if( mid == nums.length-1 && nums[mid-1] < nums[mid] ) {
                return mid;
            }
            if( mid != 0 && (nums[mid] > nums[mid-1]) && (nums[mid] > nums[mid+1])) {
                return mid;
            } else if( nums[mid+1] > nums[mid] ) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return mid;
    }
}