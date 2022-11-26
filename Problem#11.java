//FIND PEAK ELEMENT

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) //If there is no array at all(null pointer) or if it is declared, but length is zero return false
            return -1;
        int low = 0; //Low will point to the first element initially
        int high = nums.length - 1; //High will point to the last element initially
        while(low <= high){ //Iterate as long as low does not become greater than high
            int mid = low + (high - low) / 2; //Calculated this way to avoid integer overflow
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == (nums.length-1) || nums[mid] > nums[mid+1])){ //If the mid element is greater than both its neighbors or if its the first element and is greater than the element towards its right or if its the last element and is greater than the element towards its left
                return mid; //Return the index, it is the peak element's index
            } else if(nums[mid + 1] > nums[mid]){ //Move towards the greater neighbhor. Check if the element towards its right is greater
                low = mid + 1; //If yes, move towards the right
            } else{
                high = mid - 1; //Otherwise move towards the left
            }
        }
        return -1;
    }
}