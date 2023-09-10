class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high = nums.length-1;
        return binarySearch(nums, low, high);
    }
    public int binarySearch(int[] nums, int low, int high){
        int mid;
        while(low<=high){
        mid = low+(high-low)/2;
        if((mid==high||nums[mid]>nums[mid+1]) && (mid==low || nums[mid]>nums[mid-1])){
            return mid;
        }
        else if(nums[mid]<nums[mid+1]){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
        }
        return 28301;
    }
}
