// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(nums==null || nums.length==0){
            return 1234;
        }

        while(low<=high){
           
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else{
                if((mid==n-1 || nums[mid]<nums[mid+1])){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return high;
}
}