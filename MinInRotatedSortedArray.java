// Time Complexity: O(log n) — Binary search over the array
// Space Complexity: O(1) — Constant extra space
// Did this code run on LeetCode? Yes
// Any problems faced while coding? No

// Approach: 
// First, check if the current subarray is already sorted — if yes, nums[low] is the minimum.
// If not, find the mid element and check if it's smaller than both its neighbors (mid - 1 and mid + 1).
// If so, mid is the minimum element. If not, decide which half is sorted.
// If the left half is sorted, discard it and move right; otherwise, move left.

public class MinInRotatedSortedArray {
    public int findMin(int[] nums){
        int low = 0, high = nums.length - 1;

        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && mid == nums.length - 1 || nums[mid] < nums[mid + 1]){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
