// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach:after checking the testcases in rotated sorted array where we find the middle one side will be sorted but the minimum element lies in unsorted array and also if neighbour elements of mid is greather than the mid them mid is our element.
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            if(nums[low]<nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if((mid==0 ||  nums[mid] < nums[mid-1]) && (mid==nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return -1;
    }
}