// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        while(low<=high){  
            if(nums[low]<=nums[high]) {return nums[low];}
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid]<nums[mid-1]) && (mid == n-1 || nums[mid]<nums[mid+1])) {
                return nums[mid];
            }
            else if(nums[mid]<=nums[high]){
                
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return 1;
    }
}