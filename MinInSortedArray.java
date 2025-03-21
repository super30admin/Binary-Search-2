// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Using Binary Search, found whether given array is left sorted or right sorted.
// Minimum element is present in the unsorted part of the array.
// low moves to mid+1, if array is left sorted or high moves to mid-1, if right sorted.



class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(nums[l]<=nums[r]) return nums[l];
            int m=l+(r-l)/2;
            if((m==0||nums[m]<nums[m-1])&&(m==n-1||nums[m]<nums[m+1])){
                return nums[m];
            }
            
            else if(nums[l]<=nums[m]){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return -1;
    }
}