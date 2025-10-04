// Time Complexity : O(log n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. The approach of going by the peek side from mid of the array and perform binary search
// helped in getting to the solution after all the brainstorming.

// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while (low <= high){
            int mid = low + (high-low)/2;
            if((mid == 0 || (nums[mid-1] < nums[mid])) && ((mid == n-1) || (nums[mid] > nums[mid+1]))){
                return mid;
            }

            else if(nums[mid+1] > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }


        return -1;
    }
}