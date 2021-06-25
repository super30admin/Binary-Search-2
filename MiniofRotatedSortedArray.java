// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
compare mid value with high element and if mid value is greater than high's value then do binary search on right subarray or else to its left
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low=0;
        int high=nums.length-1;

        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high]){

                low=mid+1;
            }
            else {
                high=mid;
            }

        }

        return nums[low];
    }
}