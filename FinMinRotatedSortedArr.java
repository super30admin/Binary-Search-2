// Find Minimum in Rotated Sorted Array
// Time Complexity : O(log n) as we are using binary search
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// This is a binary search problem where we need to find the minimum element in a rotated sorted array.
// We use binary search to find the minimum element.
// We compare the mid element with the high element to determine if the left half is sorted or the right half is sorted.
// If the left half is sorted, we move the high pointer to mid - 1, else we move the low pointer to mid + 1.


public class FinMinRotatedSortedArr {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            
            // if(nums[low] <= nums[high]) {
            //     return nums[low];
            // }

            int mid = low + (high - low) / 2;

            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            else if(nums[mid] <= nums[high]) { // left sorted
                high = mid - 1;
            } else {
                low = mid + 1;
            }
    }
    return 3434;
}
    public static void main(String[] args) {
        FinMinRotatedSortedArr finMinRotatedSortedArr = new FinMinRotatedSortedArr();
        int[] nums = {3,4,5,1,2};
        System.out.println(finMinRotatedSortedArr.findMin(nums));
    }
}
