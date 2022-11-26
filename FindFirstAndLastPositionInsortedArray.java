//Time Complexity :O(logN) +O(logN) = O(logN)
//Space Complexity :O(1)
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length ==0) return new int[]{-1,-1};
        int low=0;
        int high=nums.length-1;
        if(target<nums[low] || nums[high]<target) return new int[]{-1,-1};
        int first = leftSearch(nums,low,high,target);
        if(first == -1) return new int[]{-1,-1};
        int last = rightSearch(nums,first,high,target);
        
        return new int[]{first,last};
    }
    public int leftSearch(int [] nums,int low,int high,int target){
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || target!=nums[mid-1]) {
                       return mid;
                   }
                   high =mid-1;
                }else if(nums[mid] <target){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int rightSearch(int [] nums,int low,int high,int target){
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || target!=nums[mid+1]) {
                       return mid;
                   }
                   low =mid+1;
                }else if(nums[mid] <target){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
