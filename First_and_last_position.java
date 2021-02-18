 // Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : This is easy, couldn't get in O(logn) though, Will see in class

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //create the o/p array
        int [] arr = new int[]{-1,-1};
        int x=0;
        
        if(nums.length<1){
            return arr;
        }
        
        for(int i=0;i<nums.length;i++){
            // if num is found for the first time, store at 0 index of o/p array;
            if(nums[i]==target && x==0){
                arr[x++]=i;
            }
            // if num is found twice, store at 1 index of o/p array
            if(nums[i]==target){
                arr[x]=i;
            }
        }
        return arr;
    }
}
