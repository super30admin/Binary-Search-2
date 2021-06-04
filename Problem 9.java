// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : explained nicely in lecture, but not sure if I will fully remember it

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if((nums[mid] == low || nums[mid + 1] < nums[mid]) && (mid == high || nums[mid - 1] < nums[mid])){
                return mid;
            }else if(mid > 0 && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }
        
        return -1;
    }
}