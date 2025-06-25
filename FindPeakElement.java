// Time Complexity : O(log n)
// Space Complexity : O(1) no additional space is required
//  Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None


//Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findPeakElement(int[] nums) {
        
        //one condition to check mid with this neighbours, if mid is greater than neighbours then return mid
        //one condition to determine mid's higher neighbour and move towards its direction
        //if the mid is 0 or n-1 then its left and right neighbour respectively are -inf

        //base case
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            //get mid
            int mid = low + (high - low) / 2;

            //check if the peak is at mid itself
            //also check for the case if there is just one element in nums
            if( ( mid == 0 || nums[mid] > nums[mid - 1] ) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) ){
                return mid;
            }

            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}