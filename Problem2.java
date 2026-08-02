
//(logn) time complexity
//faced issues on line where we are returning mid value but other than that its good

//  Find min in rotated sorted array

// Code passed in leetcode : yes

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;

       
        
        while(low <= high) {
             if(nums[low] <= nums[high]){
            return nums[low];
        }

           int  mid = low + (high - low)/2;
            if((mid == low || nums[mid] < nums[mid-1]) && (mid == nums.length- 1 || nums[mid] < nums[mid+1]) ){
                return nums[mid];
            } else if (nums[low] <= nums[mid]){
                low = mid +1;
            } else{
                high = mid -1;
            }


        }
        return -1;
    }
}