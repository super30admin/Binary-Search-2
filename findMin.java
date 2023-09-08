// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * the min/pivot lies in the unsorted side of the rotated sorted array so using binary search we can search only in not sorted part 
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n -1;
        int min = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            else if(mid > 0 && nums[mid] < nums[mid -1]){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}