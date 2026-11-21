// Time Complexity - O(logn)
// Space Complexity - O(1)
// Ran on Leetcode - Yes
// Mistake made : wrote this condition that led to ignoring the index 0 and n-1 as peaks - 
// if((mid > 0 && nums[mid] > nums[mid-1]) && (mid < nums.length && nums[mid] > nums[mid+1])) {
//  return mid;
// }
// Need to handle 1st and last index cases by checking mid == 0 and mid == nums.length-1

class Solution {
    public int findPeakElement(int[] nums) {
        // peak = any element whose both neighbors are smaller than it
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            // main condition check for peak
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                    return mid;
            }
            else if(mid > 0 && nums[mid] < nums[mid-1]){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return -1;
    }
}
