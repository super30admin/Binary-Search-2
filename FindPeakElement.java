// Time Complexity :log n
// Space Complexity :0(1)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :getting problem in understanding the condition at line number 12.
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
    while(low<=high){
        int mid= low+(high-low)/2;
        if((mid==n-1||nums[mid]>nums[mid+1])&&(mid==0||nums[mid]>nums[mid-1])){
            return mid;
        }
        else if(nums[mid]>nums[mid+1]){
            high=mid-1;
        }
        else{
            low=mid+1;
        }
    }
    return -1;
    }
}