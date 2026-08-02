//(logn) time complexity
//faced issues on line where we are returning mid value but other than that its good

//Peak element

// Code passed in leetcode : yes
class Solution {
    public int findPeakElement(int[] nums) {
        

        // we need to eliminate one side to check for peak
        // lets find mid and theh check if mid > mid -1 and mid > mid+1
        
         //If low is less than mid then low = mid+1 , else high = mid -1

         if(nums.length == 0){
            return -1;
         } else if(nums.length == 1) {
            return 0;
         }

         int low = 0;
         int high = nums.length - 1;
         while(low <= high ) {
            int mid = low + (high-low) / 2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == (nums.length-1) || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1] > nums[mid]){
                low = mid + 1;

            } else {
                high = mid -1;
            }
         }

         return -1 ;
    }
}