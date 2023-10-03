// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        if(nums[0]>target || nums[n-1]<target) return new int[]{-1,-1};
        int firstIndex=firstBinarySearch(nums,low,high,target);
        if(firstIndex==-1){
            return new int[]{-1,-1};
        }
        int secondIndex=secondBinarySearch(nums,firstIndex,high,target);

        return new int[]{firstIndex,secondIndex};
        }
    
    public int firstBinarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    high=mid-1;
                 }
            }else if(nums[mid]<target){
                low =mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return -1;
    }

     public int secondBinarySearch(int[] nums, int low, int high, int target){
         while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]>nums[mid]){
                    return mid;
                }
                else{
                    low=mid+1;
                 }
            }else if(nums[mid]<target){
                low =mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}