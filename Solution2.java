// Time Complexity: O(lgn)
// Space Complexity: O(1)

class Solution2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while( low <= high ) {
            if( nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if( ( mid == 0 ||nums[mid] < nums[mid-1] )&& ( mid == n-1 ||nums[mid] < nums[mid+1])) {
                return nums[mid];
            } else if(nums[low] <= nums[mid] ) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}