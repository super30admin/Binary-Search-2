// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach in three sentences only
//do binary search and move towards the side where the highest element lies
//if mid is the highest element then return mid

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid  = low + (high-low)/2;
            if ((mid== 0 || nums[mid]> nums[mid -1]) && (mid == nums.length-1 || nums[mid]> nums[mid + 1])){
                return mid;
            }
            else if (nums[mid + 1] > nums[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return -1;
        
    }
}