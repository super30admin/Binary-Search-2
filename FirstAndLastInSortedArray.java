// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Treat this problem as two seperate problems, search for leftmost and rightmost index of the target using binary search 
// Based on the return value from both these functions, we return the index of left and last element.

class Solution {
    
    public int binarySearchleft(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){ // if mid is the target
                if(mid==low || nums[mid]>nums[mid-1]){ // if prev of mid is smaller
                    return mid; //we found the starting element of target
                }else{ 
                    high=mid-1; //move to the left
                }
            } else if (nums[mid] < target) {
                low=mid+1; // move to the right
            } else {
                high=mid-1; //move to the left
            }
        }
        return -1;
    }
    
    public int binarySearchright(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){ // if mid is the target
                if(mid==high || nums[mid] < nums[mid+1]){ //if next of mid is larger
                    return mid; //we found the ending element of target
                }else{ 
                    low=mid+1; // move to the right
                }
            } else if (nums[mid] < target) {
                low=mid+1; // move to the right
            } else {
                high=mid-1; //move to the left
            }
        }
        return -1;
    }
    
    
    
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        
        //if element doesnt exist in the array
        if(nums[0]>target || nums[n-1]<target) return new int[]{-1,-1};
        
        int left=binarySearchleft(nums,0,n-1,target);
        
        //if element was not found in binary search
        if (left==-1) return new int[]{-1,-1};
        
        int right=binarySearchright(nums,left,n-1,target);
        return new int[]{left,right};
    }
}