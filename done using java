34:Find First and Last Position of Element in Sorted Array

Time complexity : O(n)
space complexity: o(1)



class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        result[0] =findStartingIndex(nums,target);
         result[1] =findEndingIndex(nums,target);
        return result;
    }
    
    
    public int findStartingIndex(int []nums , int target){
        int index = -1;
        
         int f=0;
        int e= nums.length-1;
         while( f<=e)
         {
             int mp = f+(e-f)/2;
             if(nums[mp] >= target){
                 e= mp-1;
                 
             }else{
                 f= mp+1;
             }if(nums[mp] == target) index =mp;
                 
         }
        
        
        
return index;
    }
 public int findEndingIndex(int []nums , int target){
        int index = -1;
     
      int f=0;
        int e= nums.length-1;
     
     while( f<=e)
         {
             int mp = f+(e-f)/2;
             if(nums[mp] <= target){
                
                 f= mp+1;
             }else{
                 e= mp-1;
             }if(nums[mp] == target) index =mp;
                 
         }
     
     
     
     return index;
    }
}
