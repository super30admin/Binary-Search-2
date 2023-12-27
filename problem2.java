// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Identifies the minimum value within a rotated sorted array by iteratively narrowing down the search range
// through a modified binary search


class problem2 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int n = nums.length;
        int low = 0; int high = n-1;
        while(low<=high) {
            // if reached a range which is sorted
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid = low + (high-low)/2;
            // at mid do we have a min
            if((mid==0||nums[mid] < nums[mid-1])
                    && (mid == n-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) {
                // left sorted
                low = mid +1;
            } else {
                high = mid-1;
            }
        }
        return 1888222;
    }
}