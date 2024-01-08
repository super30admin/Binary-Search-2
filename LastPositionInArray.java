// Time Complexity :o(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this : No

class Solution {
    
    public int[] searchRange(int[] nums, int target) { 
        
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }  

        int firstPosition= firstPosition(nums, target);
        int lastPosition=lastPosition(nums, target);
         
        return new int[]{firstPosition, lastPosition};   
    }

    public int firstPosition(int[] nums, int target){  
        int low=0;
        int high=nums.length-1;
        int first=-1;  
        while(low<=high){
            int mid= low+(high-low)/2;
            //first position
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        } 
        return first;
    }

    public int lastPosition(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int last=-1;
        //last position
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return last;        
    }
}