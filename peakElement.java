// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n -1 ;
        int mid;

        while(low<=high){
            mid = low + (high-low)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid]<nums[mid+1]){
                low =  mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}