// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach in three sentences only
//

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == n-1 ||nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid == n-1 || nums[mid+1]>nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return 1 ;
    }
}