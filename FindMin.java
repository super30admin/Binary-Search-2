// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[high]) return nums[low];
            if((mid==0 || nums[mid]<nums[mid-1]) &&nums[mid]< nums[mid+1]) return nums[mid];
            else if(nums[low]<=nums[mid]){// left side is sorted so we will eleminate that sorted side
                low =mid+1;
            }else high = mid-1;
        }
        return 69;
    }
}