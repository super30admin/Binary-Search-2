// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: find mid. if array is sorted then low has min. if left part is sorted then min is in right part and vice versa


public class MinRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        //binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //if array is sorted then min is at low
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                //if mid is the minimum
                return nums[mid];
            } else if(nums[low] <= nums[mid]) { //left part is sorted so min is in right part
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinRotatedSortedArray solver = new MinRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Minimum of nums1: " + solver.findMin(nums1));
        System.out.println("Minimum of nums2: " + solver.findMin(nums2));
    }
}
