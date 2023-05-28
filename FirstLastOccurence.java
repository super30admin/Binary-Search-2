// Time Complexity : O(logn) [2 binary search]
// Space Complexity : O(1) //since we are noy using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes . Got array index out of bounds on line 29 and 53 and added a check


// Your code here along with comments explaining your approach in three sentences only
// Implementation by doing 2 binary search to find the first and last occurence

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //base case
        if( nums == null || nums.length == 0 ) return new int[]{-1,-1};
        //check if nums had just one element which is not equal to target
        if(target < nums[0] || target > nums[nums.length - 1] ) return new int[]{-1,-1};

        int first = binarySearchFirstOccurence(nums,target);
       if(first== -1) return new int[]{-1,-1};
       int last = binarySearchLastOccurence(nums,target);
       return new int[]{first,last};
    }
        private int binarySearchFirstOccurence(int[] nums,int target){
            int low=0;
            int high = nums.length-1;
            while(low<=high){
                int mid= low + (high-low)/2;//prevent integer overflow
                if(target ==nums[mid]){
                    //check if its the first occurence
                    if( mid==0 || nums[mid-1] < nums[mid] ){
                        return mid;
                    }
                    else{

                        high = mid-1;
                    }
                }
                else if(target < nums[mid]){
                   high = mid -1;
                }
                else{
                    low =mid+1;
                }
          
            }
           return -1;   
        }
        private int binarySearchLastOccurence(int[] nums,int target){
           int low=0;
           int high = nums.length-1;
           while(low<=high){
               int mid = low+(high - low)/2;//prevent integer overflow
               if( nums[mid]== target){
                 //check if its the last occurence
                  if(mid == nums.length-1 ||nums[mid] < nums[mid+1]){
                      return mid;
                  }
                  else{
                      low = mid+1;
                  }
               }
               else if(target >  nums[mid]){
                 low = mid+1;
               }
               else{
                   high = mid -1;
               }
              
           } 
            
              return -1; 
        }
     
    }
    