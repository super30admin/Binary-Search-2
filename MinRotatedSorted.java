// Time Complexity : O(logn) 
// Space Complexity : O(1) //since we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes . Got array index out of bounds on line 29 and 53 and added a check


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int findMin(int[] nums) {
        //base case
        if(nums == null || nums.length == 0 ) return -1;
        if(nums.length == 1) return nums[0];
        if(nums[0] <= nums[nums.length-1]) return nums[0];
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            int mid = low+(high-low)/2;//avoid Integer overflow
            //if the entire array is sorted return low as its the min element
            if(nums[low] <= nums[high]){
             return nums[low];
            }
            //check if mid is the min element
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 ||nums[mid] < nums[mid+1])){
            return nums[mid];
                
            }
            else if(nums[low]<= nums[mid]){
                //move towards unsorted part
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 66477558;

    }
}