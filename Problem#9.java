//FIND FIRST AND LAST POSITION OF ELEMENT IN SORTED ARRAY

// Time Complexity : O(log(n) + log(n)) = 2 * O(log(n)) = O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    private int BinarySearchLeft(int[] nums, int low, int high, int target){
        while(low <= high){ //Iterate as long as low does not become greater than high
            int mid = low + (high - low)/2; //Calculated this way to avoid integer overflow
            if(nums[mid] == target){ //If the element is found
                if(mid == 0 || nums[mid] > nums[mid-1]) //Return the index if it is the first element or if the previous element is less than the target
                    return mid;
                else
                    high = mid -1; //Keep moving towards the left otherwise
            } else if (nums[mid] > target){ //If target is not found and is less than the element at mid
                high = mid - 1; //Move towards the left
            } else{ //If target is not found and is greater than the element at mid
                low = mid + 1; //Move towards the right
            }
        }
        return -1;
    }

    private int BinarySearchRight(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] > nums[mid]){ //Return the index if it is the last element or if the next element is greater than the target
                    return mid;
                } else {
                    low = mid + 1; //Keep moving towards the right otherwise
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) //If there is no array at all(null pointer) or if it is declared, but length is zero return false
            return new int[]{-1, -1};
        if(nums[0] > target || nums[nums.length - 1] < target) //Check whether or not the target lies in the range between element at 0th index and element at (n-1)th index
            return new int[]{-1, -1};
        int left = BinarySearchLeft(nums, 0, nums.length, target); //Get index of the leftmost occurrence of the target
        if(left == -1) //If there is no leftmost occurence, target is not present in nums
            return new int[]{-1, -1};
        int right = BinarySearchRight(nums, left, nums.length, target); //Get index of the rightmost occurrence by doing a separate binary search. Low = index of the leftmost occurrence to reduce search space
        return new int[]{left, right}; //Return leftmost and rightmost indices
    }
}