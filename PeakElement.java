// Time Complexity : O(logn) [binary search]
// Space Complexity : O(1) //since we are not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes . Got array index out of bounds on line 29 and 53 and added a check


// Your code here along with comments explaining your approach in three sentences only
// We do binary search by moving towards the larger part of array

class Solution {
    public int findPeakElement(int[] nums) {
        //base case
        if(nums.length == 0 || nums== null) return -1;
        if(nums.length == 1) return 0;
        int low= 0;
        int high = nums.length-1;
        while(low<=high){
          int  mid = low+(high-low)/2;
          //we check if the mid is peak and return the index
if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])){
              return mid ;
        }
        // if the right element is greater m0ve towards the right
        else if(nums[mid] < nums[mid+1] ){

            low= mid+1;
                    }
                    else{
                        high = mid-1;
                    }

    }
    return -1;
    }
   
} 