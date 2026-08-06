//TC: log(N)
//SC: O(1)
//Approach: Apply BS and compare the mid value wiht adjacent elements, whichever side is greater than mid, choose that side. 
//If both sides have elements lesser than mid, then return mid. 
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int hi = nums.length - 1;
         while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if( (mid == 0 || nums[mid] > nums [mid -1]) &&(mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            if(nums[mid] < nums [mid + 1]) {
                low = mid+1;
            } else {
                hi = mid-1;
            }
         }
         return -1;
    }
}