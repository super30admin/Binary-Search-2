// Problem: Find Minimum in Rotated Sorted Array
// Time Complexity: O(log n) as we use binary search to eliminate half of the search space in each step.
// Space Complexity: O(1) as we only use a constant amount of extra space for pointers.

/*
Approach:
The algorithm uses binary search to find the pivot point where the rotation occurs by identifying the unsorted half of the array.
At each step, we check if the current range is already sorted; if so, the leftmost element is the minimum.
Otherwise, we move towards the unsorted side because the minimum element always resides in the part of the array that violates the sorted order.
*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;


        // look for minimum
        while(low <= high){
            // if array is sorted
            if(nums[low]<= nums[high]){
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == (nums.length -1) ||nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            if(nums[low]<= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}