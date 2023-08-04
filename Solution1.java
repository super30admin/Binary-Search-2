// Time Complexity: O(lgn)
// Space Complexity: O(1)


class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if( nums.length == 0) {
            return result;
        }
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while( low <= high ) {
            mid = low + (high-low)/2;
            if( nums[mid] == target) {
                if( mid == 0) {
                    result[0] = mid;
                    break;
                }
                if( nums[mid-1] < target ) {
                    result[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if( nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        high = nums.length-1;
        low = mid;
        while( low <= high) {
            mid = low + (high-low)/2;
            if( nums[mid] == target) {
                if( mid == nums.length-1) {
                    result[1] = mid;
                    break;
                }
                if( nums[mid] < nums[mid+1]) {
                    result[1] = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else if ( nums[mid] < target ) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return result;
    }
}