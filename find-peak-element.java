// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] < nums[mid+1]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}