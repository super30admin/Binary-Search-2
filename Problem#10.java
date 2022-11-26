//FIND MINIMUM IN ROTATED SORTED ARRAY

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) //If there is no array at all(null pointer) or if it is declared, but length is zero return false
            return -1;
        if(nums[0] <= nums[nums.length - 1])
            return nums[0]; //Return the element at the 0th index if we have a fully sorted array, i.e., array rotated n times.
        int low = 0; //Low will point to the first element initially
        int high = nums.length - 1; //High will point to the last element initially
        while(low <= high){ //Iterate as long as low does not become greater than high
            int mid = low + (high - low) / 2; //Calculated this way to avoid integer overflow
            if(nums[low] <= nums[high])
                return nums[low]; //If the current part of the search space is fully sorted, return element at the 'low' index
            if((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == (nums.length - 1) || nums[mid + 1] > nums[mid])){ //If the mid element is less than both its neighbors or if its the first element and is less than the element towards its right or if its the last element and is less than the element towards its left
                return nums[mid]; 
            } else if(nums[mid] >= nums[low]){ //Move towards the right if left part of the array is sorted
                low = mid + 1;
            } else { //Move towards the left if right part of the array is sorted
                high = mid - 1;
            }
        }
        return 456789; //There will always be a minimum. This part of the code will never get executed
    }
}