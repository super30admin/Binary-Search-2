// Time Complexity : 2 O(LOG N)
//Space Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        
        if(target<nums[0] && target>nums[nums.length-1])
            return new int[]{-1,-1};
        
        int firstOccurence=BinarSearchFirst(nums,target);
       int secondOccurence=BinarSearchSecond(nums,target);
        return new int[]{firstOccurence,secondOccurence};
    } 
        
    
    public int BinarSearchFirst(int[] nums,int target){
          int low=0;
          int high=nums.length-1;

        while(low<=high){
             int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 ||nums[mid-1]<target)
                {
                    return mid;
                }
                //keep moving to the left 
                    high=mid-1;
            }
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
                }
            }
            return -1;
        }
    
      
     public int BinarSearchSecond(int[] nums,int target){
          int low=0;
          int high=nums.length-1;
        int n=nums.length;
        while(low<=high){
             int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==(n-1) || nums[mid+1]>target)
                {
                    return mid;
                }
                //keep moving to the right
                    low=mid+1;
            }
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
                }
            }
            return -1;
        }
    
    
}