// Time Complexity : O(log n)
// Space Complexity : O(1) no additional space is required
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

//Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findMin(int[] nums) {
        
        //once we are at mid, we check if the element at mid is less than its neighbours, if so we return the mid.
        //otherwise, we check which side is sorted and which side is unsorted
        //if the value at low is less than the value at mid then we say it is sorted,
        //so we move in the opposite direction, towards high.
        //if mid is less than the value at high then we say that right side is sorted,
        //so we move in the opposite direction, towards low.

        // if(nums == null || nums.length == 0){
        //     return -1;
        // }

        if(nums.length == 1){
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){

            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if( (mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) ){
                return nums[mid];
            }
            
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            } 
            else{
                high = mid - 1;
            }
        }

        return 999999;

    }
}